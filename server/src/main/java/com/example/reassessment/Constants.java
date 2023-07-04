package com.example.reassessment;

public class Constants {
    public static final String SQL_FINDTITLESTARTINGWITH = "SELECT * FROM book2018 WHERE title LIKE ? LIMIT ?, ?";
    public static final String SQL_FINDBYEMAIL = "SELECT * FROM book2018 WHERE email=?";
    public static final String SQL_COUNT = "SELECT COUNT(*) FROM book2018";
}
