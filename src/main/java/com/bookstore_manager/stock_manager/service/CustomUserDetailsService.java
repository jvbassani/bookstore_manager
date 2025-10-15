/*
===============================================================================
 Project:        bookstore_manager
 File:           CustomUserDetailsService.java
 Created:        2025-10-14
 Author:         Joao Vitor Bassani
 Description:    Class used to define the behavior for user authentication
===============================================================================
*/

package com.bookstore_manager.stock_manager.service;

import com.bookstore_manager.stock_manager.models.UserEntity;
import com.bookstore_manager.stock_manager.repository.UsersRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UsersRepository usersRepository;
    public CustomUserDetailsService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = usersRepository.findByUsername(username)
                    .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        var authorities = userEntity.getRoles().stream()
                    .map(SimpleGrantedAuthority::new)
                    .collect(Collectors.toSet());

        return new org.springframework.security.core.userdetails.User(
            userEntity.getUsername(),
            userEntity.getPassword(),
            userEntity.isEnabled(),
            true,
            true,
            true,
            authorities
        );
    }
}
