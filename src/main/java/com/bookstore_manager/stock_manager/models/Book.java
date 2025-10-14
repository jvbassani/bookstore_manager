/*
===============================================================================
 Project:        bookstore_manager
 File:           Book.java
 Created:        2025-09-15
 Author:         Joao Vitor Bassani
 Description:    Class model for a book
===============================================================================
*/

package com.bookstore_manager.stock_manager.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "books")
@Data @NoArgsConstructor @AllArgsConstructor
public class Book
{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is required")
    @Size(min = 2, max = 255, message = "Title must be between 2 and 255 characters")
    @Column(name = "title", nullable = false)
    private String title;

    @Size(max = 1000, message = "Description cannot exceed 1000 characters")
    @Column(name = "description")
    private String description;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.01", message = "Price must be greater than or equal to 0.01")
    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Min(value = 1, message = "Quantity must be greater than or equal to 0")
    @Column(name = "quantity")
    private Integer quantity;
}