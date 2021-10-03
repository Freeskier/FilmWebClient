package com.client.DTOs;

public class RatingForAddDTO {
    private int movieId;
    private int stars;

    public RatingForAddDTO(int movieId, int stars) {
        this.movieId = movieId;
        this.stars = stars;
    }
}
