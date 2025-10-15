/*
===============================================================================
 Project:        bookstore_manager
 File:           UserController.java
 Created:        2025-09-15
 Author:         Joao Vitor Bassani
 Description:    Controller to define User RESTful API
===============================================================================
*/

package com.bookstore_manager.stock_manager.controller;

import com.bookstore_manager.stock_manager.models.UserEntity;
import com.bookstore_manager.stock_manager.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


// -----------------------------------------------------------------------------
// Functions
// -----------------------------------------------------------------------------

@RestController
@RequestMapping("/api/v1/users")
public class UsersController
{
    private final UserService userService;
    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        System.out.println("Getting all users from database");
        List<UserEntity> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UserEntity> addUser(@RequestBody UserEntity data) {
        System.out.println("Adding user");
        UserEntity createdUser = userService.createUser(data.getUsername(),
                                                        data.getPassword(),
                                                        data.getRoles());
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{userId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        System.out.println("Deleting user with ID: " + userId);
        userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}