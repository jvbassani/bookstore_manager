/*
===============================================================================
 Project:        bookstore_manager
 File:           StockManagerApplication.java
 Created:        2025-09-15
 Author:         Joao Vitor Bassani
 Description:    Main application to control a bookstore
===============================================================================
*/

package com.bookstore_manager.stock_manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
public class StockManagerApplication 
{
    public static void main(String[] args) {
        SpringApplication.run(StockManagerApplication.class, args);
    }
}
