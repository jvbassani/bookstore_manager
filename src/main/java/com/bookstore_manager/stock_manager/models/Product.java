/*
===============================================================================
 Project:        bookstore_manager
 File:           Product.java
 Created:        2025-10-13
 Author:         Joao Vitor Bassani
 Description:    Class model for a Product
===============================================================================
*/

package com.bookstore_manager.stock_manager.models;

public class Product
{
    private Long id;
    private String title;
    private String description;
    private double price;

    // Constructors, getters, and setters
    public Product() {}
    public Product(Long id, String title, String description, double price) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}