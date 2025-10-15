/*
===============================================================================
 Project:        bookstore_manager
 File:           UsersRepository.java
 Created:        2025-10-13
 Author:         Joao Vitor Bassani
 Description:    Creates the appropriate repository for users management
===============================================================================
*/

package com.bookstore_manager.stock_manager.repository;

import com.bookstore_manager.stock_manager.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<UserEntity, Long>
{
    Optional<UserEntity> findByUsername(String username);
}