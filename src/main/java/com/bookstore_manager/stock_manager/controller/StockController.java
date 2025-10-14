/*
===============================================================================
 Project:        bookstore_manager
 File:           StockController.java
 Created:        2025-09-15
 Author:         Joao Vitor Bassani
 Description:    Controller to define Stock RESTful API
===============================================================================
*/

package com.bookstore_manager.stock_manager.controller;

import com.bookstore_manager.stock_manager.models.Book;
import com.bookstore_manager.stock_manager.service.StockService;

import jakarta.validation.Valid; // refactor!!!!
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;



// -----------------------------------------------------------------------------
// Functions
// -----------------------------------------------------------------------------

class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String message) {
        super(message);
    }
}

@RestController
@RequestMapping("/api/v1/books")
public class StockController
{
    private final StockService stockService;
    @Autowired
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        System.out.println("Getting all books from stock");
        List<Book> books = stockService.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping(value = "/{bookId}",  produces = "application/json")
    public ResponseEntity<Book> getBook(@PathVariable Long bookId) {
        System.out.println("Getting book with id " + bookId);
        Optional<Book> book = stockService.getBookById(bookId);
        return book.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                   .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Book> addBook(@RequestBody @Valid Book data) {
        System.out.println("Adding book");
        Book createdBook = stockService.createBook(data);
        return new ResponseEntity<>(createdBook, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{bookId}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Book> updateBook(@PathVariable Long bookId, @RequestBody @Valid Book data) {
        System.out.println("Updating book with ID: " + bookId + " with data: " + data);
        Book updatedBook = stockService.updateBook(bookId, data);
        if (updatedBook != null) {
            return new ResponseEntity<>(updatedBook, HttpStatus.OK);
        } else {
            throw new BookNotFoundException("Book with id " + bookId + " not found");
        }
    }

    @DeleteMapping(value = "/{bookId}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long bookId) {
        System.out.println("Deleting book with ID: " + bookId);
        stockService.deleteBook(bookId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<String> handleBookNotFound(BookNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}