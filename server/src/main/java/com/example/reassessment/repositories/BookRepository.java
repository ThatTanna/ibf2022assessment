package com.example.reassessment.repositories;

import static com.example.reassessment.Constants.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.reassessment.models.Book;

@Repository
public class BookRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Book> findBookBy(String searchValue, Integer limit, Integer offset) {
        return jdbcTemplate.query(SQL_FINDTITLESTARTINGWITH,
                BeanPropertyRowMapper.newInstance(Book.class), searchValue + "%", limit, offset);
    }
    
    public List<Book> findAllBooks(){
        return jdbcTemplate.query("SELECT * FROM book2018 WHERE title LIKE 'a%' LIMIT 10, 20",
        BeanPropertyRowMapper.newInstance(Book.class));
    }

}
