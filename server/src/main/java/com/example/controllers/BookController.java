package com.example.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.Book;
import com.example.repositories.BookRepository;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping("")
    public ResponseEntity<List<Book>> getBooks(String searchValue, int offset, int limit) {
        try {
            List<Book> bookList = new ArrayList<Book>();
            bookList = bookRepository.findBookBy(searchValue, offset, limit);
            bookRepository.findBookBy(searchValue, offset, limit).forEach(bookList::add);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }

}
