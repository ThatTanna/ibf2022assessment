package com.example.reassessment.models;

import lombok.Data;

@Data
public class Book {
    private String title;
    private String author;
    private Integer pages;
    private Integer rating;
    private String genre;
}