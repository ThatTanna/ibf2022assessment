package com.example.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.models.Book;
import com.fasterxml.jackson.databind.BeanProperty;

import static com.example.Constants.*;

@Repository
public class BookRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Book> findBookBy(String searchValue, int offset, int limit) {
        return jdbcTemplate.query(SQL_FINDTITLESTARTINGWITH,
                BeanPropertyRowMapper.newInstance(Book.class), searchValue + "%", offset, limit);
    }

}
