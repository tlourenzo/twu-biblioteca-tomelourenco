/*
 * Created by Tome Lourenco for TWU 101
 * v.1.0
 */


package com.twu.utilities;

import java.util.*;
import com.twu.book.Book;
import com.twu.movie.Movie;
import com.twu.user.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Tome Lourenco
 * v.1.0
 */
public class UtilitiesTest {

    private List<Book> booksList;
    private List<Movie> movieList;
    private Book testBook;
    private Movie testMovie;
    private User testUser;

    @Before
    public void setUp(){
        testUser = new User("123-1234", "0000", "Test User", "test@email.com", "1234");
        booksList = new ArrayList<Book>();
        movieList = new ArrayList<Movie>();
        testBook = new Book("Test Book", "Test Author", 2017);
        testBook.setUserHoldingBook(testUser);
        testMovie = new Movie("Test Movie", 2017,"Test Director", "10");
        testMovie.setUserHoldingMovie(testUser);
        booksList.add(testBook);
        movieList.add(testMovie);
    }

    @Test
    public void testBookListFormat(){
        String toTest = String.format("%-15d %-15s %-15s %-15d\n", 1, "Test Book", "Test Author", 2017);
        assertEquals(Utilities.displayFormattedBookList(booksList), toTest);
    }

    @Test
    public void testMovieListFormat(){
        String toTest = String.format("%-15d %-15s %-15s %-15d %-15s\n", 1, "Test Movie", "Test Director",2017, "10");
        assertEquals(Utilities.displayFormattedMovieList(movieList), toTest);
    }

    @Test
    public void testLibrarianListFormat(){
        String toTestBook = String.format("%-15s %-15s %-15s %-15s\n", "Book", "Test Book","Test Author",testUser.getUsername());
        String toTestMovie = String.format("%-15s %-15s %-15s %-15s\n", "Movie", "Test Movie","Test Director",testUser.getUsername());
        assertEquals(Utilities.displayFormattedLibrarianList(booksList), toTestBook);
        assertEquals(Utilities.displayFormattedLibrarianList(movieList), toTestMovie);
    }
}
