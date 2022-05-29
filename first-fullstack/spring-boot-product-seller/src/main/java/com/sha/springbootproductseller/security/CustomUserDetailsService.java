package com.sha.springbootproductseller.security;

import com.sha.springbootproductseller.model.User;
import com.sha.springbootproductseller.service.UserService;
import com.sha.springbootproductseller.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author sa
 * @date 18.12.2021
 * @time 12:42
 */
@Service
public class CustomUserDetailsService implements UserDetailsService
{
    // UserDetailsService is an Abstract class
    // (also why this is named "Custom")

    @Autowired
    private UserService userService;

    // this method is built-in to the Abstract class
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        User user = userService.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));

        // Spring Security has classes to describe authority
        // "GrantedAuthority" (Interface - Abstract)
        // "SimpleGrantedAuthority" (Implementation Class for GA)
        Set<GrantedAuthority> authorities = Set.of(SecurityUtils.convertToAuthority(user.getRole().name()));

        // UserDetails is Abstract - contains details of the User
        // it's NOT the service layer! (ex. UserDetailsService)
        // summary: implemented in UserPrinciple
        return UserPrinciple.builder()
                .user(user)
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .authorities(authorities)
                .build();
        // postscript: this is a typical builder pattern
        // @Builder in lombok!!
    }
}
