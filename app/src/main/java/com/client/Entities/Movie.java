package com.client.Entities;

import java.util.Date;

public class Movie {
    private int id;
    private String title;
    private String director;
    private String screenwriter;
    private Date productionDate;
    private String filmGenre;
    private String descriptionShort;
    private String descriptionLong;
    private String imageURL;
    private int durationTimeMinutes;

    public Movie(int id, String title, String director, String screenwriter, Date productionDate, String filmGenre, String descriptionShort, String descriptionLong, String imageURL, int durationTimeMinutes) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.screenwriter = screenwriter;
        this.productionDate = productionDate;
        this.filmGenre = filmGenre;
        this.descriptionShort = descriptionShort;
        this.descriptionLong = descriptionLong;
        this.imageURL = imageURL;
        this.durationTimeMinutes = durationTimeMinutes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getScreenwriter() {
        return screenwriter;
    }

    public void setScreenwriter(String screenwriter) {
        this.screenwriter = screenwriter;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public String getFilmGenre() {
        return filmGenre;
    }

    public void setFilmGenre(String filmGenre) {
        this.filmGenre = filmGenre;
    }

    public String getDescriptionShort() {
        return descriptionShort;
    }

    public void setDescriptionShort(String descriptionShort) {
        this.descriptionShort = descriptionShort;
    }

    public String getDescriptionLong() {
        return descriptionLong;
    }

    public void setDescriptionLong(String descriptionLong) {
        this.descriptionLong = descriptionLong;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public int getDurationTimeMinutes() {
        return durationTimeMinutes;
    }

    public void setDurationTimeMinutes(int durationTimeMinutes) {
        this.durationTimeMinutes = durationTimeMinutes;
    }
}
