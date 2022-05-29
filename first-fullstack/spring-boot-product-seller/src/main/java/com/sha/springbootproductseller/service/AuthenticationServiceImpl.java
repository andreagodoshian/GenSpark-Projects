package com.sha.springbootproductseller.service;

import com.sha.springbootproductseller.model.User;
import com.sha.springbootproductseller.security.UserPrinciple;
import com.sha.springbootproductseller.security.jwt.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

/**
 * @author sa
 * @date 18.12.2021
 * @time 13:42
 */
@Service // Business Logic class
public class AuthenticationServiceImpl implements AuthenticationService
{

    // Authentication Manager is the bridge between user & Spring Security
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtProvider jwtProvider;


    @Override
    public User signInAndReturnJWT(User signInRequest)
    {
        // convert user info to authentication object
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInRequest.getUsername(), signInRequest.getPassword())
        );

        // to reach UserPrinciple, use built-in method
        UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
        // generateToken, so contact jwtProvider
        String jwt = jwtProvider.generateToken(userPrinciple);

        // get User via UserPrinciple
        User signInUser = userPrinciple.getUser();
        // set the token (added to User model)
        signInUser.setToken(jwt);

        return signInUser;
    }
}
