package com.sha.springbootproductseller.security.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author sa
 * @date 18.12.2021
 * @time 13:31
 */

// Spring Boot can apply different types of filters...
// can even chain different filters together??
// OncePerRequestFilter is an Abstract class
// "guarantees to be just executed once per request"
public class JwtAuthorizationFilter extends OncePerRequestFilter
{
    // but wait! how can we implement filter, if it isn't a @Bean???
    // (we added to the SecurityConfig)

    @Autowired
    private JwtProvider jwtProvider;

    // generate authentication from http request
    // if you remember, we already did a lot of this in JwtProvider
    // (that's why we autowired it... duhhhhhhhh)
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException
    {
        Authentication authentication = jwtProvider.getAuthentication(request);

        if (authentication != null && jwtProvider.isTokenValid(request))
        {
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);
    }
}