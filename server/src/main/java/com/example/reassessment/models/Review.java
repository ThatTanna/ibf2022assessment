package com.example.reassessment.models;

import java.sql.Date;

import lombok.Data;

@Data
public class Review {
    private String bookTitle;
    private String author;
    private String reviewer;
    private Date reviewDate;
    private String summary;
    private String link;
}
