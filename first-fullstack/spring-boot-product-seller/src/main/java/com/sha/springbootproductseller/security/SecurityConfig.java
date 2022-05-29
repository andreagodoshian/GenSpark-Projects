package com.sha.springbootproductseller.security;

import com.sha.springbootproductseller.model.Role;
import com.sha.springbootproductseller.security.jwt.JwtAuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author sa
 * @date 18.12.2021
 * @time 12:53
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
    // remember, service layer does the talking
    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    // A.M.B. is in charge of authentication
    // so we need to override & set type of authentication
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
    }

    // then, create a Bean for the Authentication Manager
    @Override
    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    public AuthenticationManager authenticationManagerBean() throws Exception
    {
        return super.authenticationManagerBean();
    }

    // once specified & bean is overridden, can configure
    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.cors(); // (Cross-Origin Resource Sharing)
        // "Often, the host that serves the JS (e.g. example.com) is different
        // from the host that serves the data (e.g. api.example.com).
        // In such a case, CORS enables cross-domain communication."

        // " back end and front end - so we need it :) "
        // what a nice guy

        http.csrf().disable(); // Cross-Site Request Forgery (CSRF)
        // also known as "one click attack" or "session riding"
        // USING JWT **this is complex, need to revisit**

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        // policies: always, ifRequired, never, stateless
        // we are using "stateless" because it guarantees
        // every request needs to be authenticated
        // (remember: we will use JWT)

        // then we can authorize requests
        // by default, we will authorize all except log-in
        // plan log-in endpoints to end with /api/authentication
        http.authorizeRequests()
                .antMatchers("/api/authentication/**").permitAll()
                .antMatchers(HttpMethod.GET, "/api/product").permitAll()
                .antMatchers("/api/product/**").hasRole(Role.ADMIN.name())
                .anyRequest().authenticated();

        // related to jwt filter
        http.addFilterBefore(jwtAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    // bean or component??
    // "Why don't we describe it as a component, because of scope."
    // (only related to security)
    @Bean
    public JwtAuthorizationFilter jwtAuthorizationFilter()
    {
        return new JwtAuthorizationFilter();
    }

    // in Spring, describe beans in configuration class
    // therefore, it's possible to put it in main's class
    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    // finally, since we enabled cors (full-stack)
    // we need to configure it
    // (sorry my notes suck)
    @Bean
    public WebMvcConfigurer corsConfigurer()
    {
        return new WebMvcConfigurer()
        {
            @Override
            public void addCorsMappings(CorsRegistry registry)
            {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedMethods("*");
            }
        };
    }
}
