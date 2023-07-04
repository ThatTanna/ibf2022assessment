package com.example.reassessment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.reassessment.repositories.BookRepository;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;
    
}
