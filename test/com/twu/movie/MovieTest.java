/*
 * Created by Tome Lourenco for TWU 101
 * v.1.0
 */

package com.twu.movie;

import com.twu.database.Inventory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by tlourenzo on 01-08-2017.
 */
public class MovieTest {

    private static final Movie MOVIE_1 = new Movie("Awesome Movie 1", 2017, "Awesome Director 1", "10");
    private static final Movie MOVIE_2 = new Movie("Awesome Movie 2", 2017, "Awesome Director 2", "9");
    private Inventory inventory;

    @Before
    public void setUp(){
        inventory = new Inventory();
    }

    @Test
    public void verifyDirector(){
        assertEquals(MOVIE_1.getDirector(), inventory.getMovieList().get(0).getDirector());
        assertEquals(MOVIE_2.getDirector(), inventory.getMovieList().get(1).getDirector());
    }

    @Test
    public void verifyMovieName(){
        assertEquals(MOVIE_1.getMovieName(), inventory.getMovieList().get(0).getMovieName());
        assertEquals(MOVIE_2.getMovieName(), inventory.getMovieList().get(1).getMovieName());
    }

    @Test
    public void verifyMovieYear(){
        assertEquals(MOVIE_1.getYear(), inventory.getMovieList().get(0).getYear());
        assertEquals(MOVIE_2.getYear(), inventory.getMovieList().get(1).getYear());
    }

    @Test
    public void verifyIfEqualMovies(){
        assertTrue(MOVIE_1.equals(MOVIE_1));
        assertFalse(MOVIE_1.equals(MOVIE_2));
    }

    @Test
    public void verifyMovieRating(){
        assertEquals(MOVIE_1.getDirector(), inventory.getMovieList().get(0).getDirector());
        assertEquals(MOVIE_2.getDirector(), inventory.getMovieList().get(1).getDirector());
    }

}
