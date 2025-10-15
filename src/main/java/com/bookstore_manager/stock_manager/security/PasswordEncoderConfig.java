/*
===============================================================================
 Project:        bookstore_manager
 File:           PasswordEncoderConfig.java
 Created:        2025-10-13
 Author:         Joao Vitor Bassani
 Description:    File to set Spring Boot security configurations
===============================================================================
*/

package com.bookstore_manager.stock_manager.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordEncoderConfig
{
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}