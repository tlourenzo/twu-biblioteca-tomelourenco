/*
 * Created by Tome Lourenco for TWU 101
 * v.1.0
 */

package com.twu.movie;

import com.twu.user.User;

/**
 * Created by tlourenzo on 30-07-2017.
 */
public class Movie {

    private String movieName;
    private int year;
    private String director;
    private String rating;
    private User userHoldingMovie = null;

    /**
     * This class is a representation of the Movie Entity
     * @param movieName
     * @param year
     * @param director
     * @param rating
     */
    public Movie(String movieName, int year, String director, String rating) {
        this.movieName = movieName;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public User getUserHoldingMovie() {
        return userHoldingMovie;
    }

    public void setUserHoldingMovie(User userHoldingMovie) {
        this.userHoldingMovie = userHoldingMovie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        if (year != movie.year) return false;
        if (!movieName.equals(movie.movieName)) return false;
        if (!director.equals(movie.director)) return false;
        return rating != null ? rating.equals(movie.rating) : movie.rating == null;
    }

    @Override
    public int hashCode() {
        int result = movieName.hashCode();
        result = 31 * result + year;
        result = 31 * result + director.hashCode();
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        return result;
    }
}
