package com.example.zoey.example_3.data.models;

import java.text.DateFormat;
import java.util.Date;

public class Film {
    private String name;
    private String filmPoster;
    private Date dateOfFirstShow;
    private String description;

    public Film(String name, String filmPoster, Date dateOfFirstShow, String description) {
        this.name = name;
        this.filmPoster = filmPoster;
        this.dateOfFirstShow = dateOfFirstShow;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFilmPoster() {
        return filmPoster;
    }

    public void setFilmPoster(String filmPoster) {
        this.filmPoster = filmPoster;
    }

    public Date getDateOfFirstShow() {
        return dateOfFirstShow;
    }

    public void setDateOfFirstShow(Date dateOfFirstShow) {
        this.dateOfFirstShow = dateOfFirstShow;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
