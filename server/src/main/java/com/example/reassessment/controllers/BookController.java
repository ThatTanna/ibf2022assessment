package com.example.reassessment.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.reassessment.models.Book;
import com.example.reassessment.repositories.BookRepository;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("")
    public ResponseEntity<List<Book>> getBooks(
            @RequestParam(required = true) String searchValue,
            @RequestParam(defaultValue = "10") Integer limit,
            @RequestParam(defaultValue = "0") Integer offset) {
        System.out.println(searchValue);
        try {
            List<Book> bookList = new ArrayList<Book>();
            // bookList = bookRepository.findBookBy(searchValue, limit, offset);
            bookRepository.findBookBy(searchValue, limit, offset).forEach(bookList::add);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }

    @GetMapping("/all")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> bookList = new ArrayList<Book>();
        bookList = bookRepository.findAllBooks();
        if (bookList.isEmpty()) {
            return new ResponseEntity<List<Book>>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<List<Book>>(bookList, HttpStatus.NOT_FOUND);
        }

    }

}
