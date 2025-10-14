/*
===============================================================================
 Project:        bookstore_manager
 File:           BooksRepository.java
 Created:        2025-10-13
 Author:         Joao Vitor Bassani
 Description:    Creates the appropriate repository for books management
===============================================================================
*/

package com.bookstore_manager.stock_manager.repository;

import com.bookstore_manager.stock_manager.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository extends JpaRepository<Book, Long>
{
    
}