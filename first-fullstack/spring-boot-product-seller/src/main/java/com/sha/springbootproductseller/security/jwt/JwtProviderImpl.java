package com.sha.springbootproductseller.security.jwt;

import com.sha.springbootproductseller.security.UserPrinciple;
import com.sha.springbootproductseller.utils.SecurityUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Arrays;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author sa
 * @date 18.12.2021
 * @time 13:14
 */
@Component
public class JwtProviderImpl implements JwtProvider
{
    // call application.properties to get info we configured
    @Value("${app.jwt.secret}")
    private String JWT_SECRET;

    // call application.properties to get info we configured
    @Value("${app.jwt.expiration-in-ms}")
    private Long JWT_EXPIRATION_IN_MS;

    // first, generate the token
    // remember: UserPrinciple implements UserDetails
    @Override
    public String generateToken(UserPrinciple auth)
    {
        String authorities = auth.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        // we need a key to encode the token
        // RSA is asymmetric is HMAC is symmetric
        // (in terms of encryption and decryption)
        Key key = Keys.hmacShaKeyFor(JWT_SECRET.getBytes(StandardCharsets.UTF_8));

        // Jwts Object, can store everything related to user && session
        // Jwts has "builder" included
        return Jwts.builder()
                .setSubject(auth.getUsername())
                .claim("roles", authorities)
                .claim("userId", auth.getId())
                .setExpiration(new Date(System.currentTimeMillis() + JWT_EXPIRATION_IN_MS))
                .signWith(key, SignatureAlgorithm.HS512) // long, safe "signature algorithm"
                .compact();
    }

    // extract the claims from the authorization header
    @Override
    public Authentication getAuthentication(HttpServletRequest request)
    {
        Claims claims = extractClaims(request);

        // if null, exit immediately
        if (claims == null)
        {
            return null;
        }

        // if ok, start to get User's information
        String username = claims.getSubject();
        Long userId = claims.get("userId", Long.class);

        // check the authorities - remember "role prefix"
        Set<GrantedAuthority> authorities = Arrays.stream(claims.get("roles").toString().split(","))
                .map(SecurityUtils::convertToAuthority)
                .collect(Collectors.toSet());

        // use builder to build the UserDetails
        UserDetails userDetails = UserPrinciple.builder()
                .username(username)
                .authorities(authorities)
                .id(userId)
                .build();

        if (username == null)
        {
            return null;
        }
        // Spring Security provides this class that describes object
        return new UsernamePasswordAuthenticationToken(userDetails, null, authorities);
    }

    // check if the token is valid (remember, one day)
    @Override
    public boolean isTokenValid(HttpServletRequest request)
    {
        // we defined "extractClaims" below
        Claims claims = extractClaims(request);

        if (claims == null)
        {
            return false;
        }

        if (claims.getExpiration().before(new Date()))
        {
            return false;
        }
        return true;
    }

    // extract token value from SecurityUtils && http request
    private Claims extractClaims(HttpServletRequest request)
    {
        String token = SecurityUtils.extractAuthTokenFromRequest(request);

        if (token == null)
        {
            return null;
        }

        // we chose HMAC earlier, so use it again
        Key key = Keys.hmacShaKeyFor(JWT_SECRET.getBytes(StandardCharsets.UTF_8));

        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
