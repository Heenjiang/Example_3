package com.example.zoey.example_3.data.helpers;

import com.example.zoey.example_3.data.models.Film;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class FilmHelper {
    public static List<Film> getFilmList(int numOfFilm){
        List<Film> listOfFilm = new ArrayList<Film>();
        for(int i = 0; i < numOfFilm; i++ ){
            Film flim = new Film("The Avengers" + i, "film_" + i % 7, new Date(), "The level of this film is: " + i);
            listOfFilm.add(flim);
        }
        return listOfFilm;
    }
}
