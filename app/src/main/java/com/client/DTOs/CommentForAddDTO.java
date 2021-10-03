package com.client.DTOs;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

public class CommentForAddDTO {
    private String text;
    private String date;
    private int movieId;

    public CommentForAddDTO(String text, int movieId) {
        this.text = text;
        this.movieId = movieId;
        Date date2 = new Date();
        date = new SimpleDateFormat("dd-MM-yyyy", Locale.GERMANY).format(date2);
    }
}
