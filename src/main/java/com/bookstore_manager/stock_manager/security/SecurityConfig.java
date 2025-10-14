/*
===============================================================================
 Project:        bookstore_manager
 File:           SecurityConfig.java
 Created:        2025-10-13
 Author:         Joao Vitor Bassani
 Description:    File to set Spring Boot security configurations
===============================================================================
*/

package com.bookstore_manager.stock_manager.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeHttpRequests(auth -> auth.anyRequest().permitAll())
            .httpBasic().disable();
        return http.build();
    }
}
