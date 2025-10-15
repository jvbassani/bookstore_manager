/*
===============================================================================
 Project:        bookstore_manager
 File:           UserService.java
 Created:        2025-10-13
 Author:         Joao Vitor Bassani
 Description:    Service operations for user management
===============================================================================
*/

package com.bookstore_manager.stock_manager.service;

import com.bookstore_manager.stock_manager.models.UserEntity;
import com.bookstore_manager.stock_manager.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserService
{
    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    public UserService(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<UserEntity> getAllUsers() {
        return usersRepository.findAll();
    }

    public UserEntity createUser(String username, String rawPassword, Set<String> roles) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(username);
        userEntity.setPassword(passwordEncoder.encode(rawPassword));
        userEntity.setRoles(roles);
        userEntity.setEnabled(true);
        return usersRepository.save(userEntity);
    }

    public void deleteUser(Long id) {
        usersRepository.deleteById(id);
    }
}
