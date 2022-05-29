package com.sha.springbootproductseller.utils;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author sa
 * @date 18.12.2021
 * @time 12:44
 */
public class SecurityUtils
{
    // functionality of this class:
    // create methods && fields for Security, etc

    public static final String ROLE_PREFIX = "ROLE_";

    // this is for JWT
    public static final String AUTH_HEADER = "authorization";
    public static final String AUTH_TOKEN_TYPE = "Bearer";
    public static final String AUTH_TOKEN_PREFIX = AUTH_TOKEN_TYPE + " ";

    // the following converts from Role to Authority
    // BUT!!!!!!!!! In Spring...
    // role values need to start with role prefix
    public static SimpleGrantedAuthority convertToAuthority(String role)
    {
        String formattedRole = role.startsWith(ROLE_PREFIX) ? role : ROLE_PREFIX + role;

        return new SimpleGrantedAuthority(formattedRole);
    }

    // for the JwtProviderImpl
    // get the header, check the size && prefix, return substring
    public static String extractAuthTokenFromRequest(HttpServletRequest request)
    {
        String bearerToken = request.getHeader(AUTH_HEADER);

        if (StringUtils.hasLength(bearerToken) && bearerToken.startsWith(AUTH_TOKEN_PREFIX))
        {
            return bearerToken.substring(7);
        }
        return null;
        // ^^ if it's not provided, return null
    }
}
