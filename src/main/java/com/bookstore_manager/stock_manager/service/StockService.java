/*
===============================================================================
 Project:        bookstore_manager
 File:           StockService.java
 Created:        2025-10-13
 Author:         Joao Vitor Bassani
 Description:    Service operations for stock management
===============================================================================
*/

package com.bookstore_manager.stock_manager.service;

import com.bookstore_manager.stock_manager.models.Book;
import com.bookstore_manager.stock_manager.repository.BooksRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockService
{
    private final BooksRepository booksRepository;
    @Autowired
    public StockService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public List<Book> getAllBooks() {
        return booksRepository.findAll();
    }

    public Optional<Book> getBookById(Long id) {
        return booksRepository.findById(id);
    }

    public Book createBook(Book book) {
        return booksRepository.save(book);
    }

    public Book updateBook(Long id, Book book) {
        Optional<Book> existingBook = booksRepository.findById(id);
        if (existingBook.isPresent()) {
            book.setId(id);
            return booksRepository.save(book);
        } else {
            return null;
        }
    }

    public void deleteBook(Long id) {
        booksRepository.deleteById(id);
    }
}