/*
 * Created by Tome Lourenco for TWU 101
 * v.1.0
 */

package com.twu.database;

import com.twu.book.Book;
import com.twu.movie.Movie;
import com.twu.user.User;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Tome Lourenco
 * v.2.0
 */
public class InventoryTest {

    private Inventory inventory;
    private static final Book BOOK_1 = new Book("Awesome Book 1", "Awesome Author 1", 2017);
    private static final Book BOOK_2 = new Book("Awesome Book 2", "Awesome Author 2", 2017);
    private static final Movie MOVIE_1 = new Movie("Awesome Movie 1", 2017, "Awesome Director 1", "10");
    private static final Movie MOVIE_2 = new Movie("Awesome Movie 2", 2017, "Awesome Director 2", "9");
    private static final User MOCKUSER = new User("123-1234", "1234","Test User","Test@Email", "0000000");

    @Before
    public void setUp(){
        inventory = new Inventory();
    }

    @Test
    public void testCreateBooksList(){
        assertEquals(BOOK_1, inventory.getBookList().get(0));
        assertEquals(BOOK_2, inventory.getBookList().get(1));
        assertEquals(MOVIE_1, inventory.getMovieList().get(0));
        assertEquals(MOVIE_2,inventory.getMovieList().get(1));
    }
    @Test
    public void testListsSize(){
        assertEquals(inventory.getBookList().size(), inventory.getAvailableBooksList().size()+inventory.getCheckedOutBooksList().size());
        assertEquals(inventory.getMovieList().size(), inventory.getAvailableMoviesList().size()+inventory.getCheckedOutMoviesList().size());
    }

    @Test
    public void testCheckOutBook(){
        Book bookToCheckout = inventory.getAvailableBooksList().get(0);
        inventory.checkoutBook(bookToCheckout, MOCKUSER);
        assertFalse(inventory.getAvailableBooksList().contains(bookToCheckout));
        assertTrue(inventory.getCheckedOutBooksList().contains(bookToCheckout));
    }

    @Test
    public void testReturnBook(){
        Book bookToReturn = inventory.getAvailableBooksList().get(0);
        inventory.checkoutBook(bookToReturn, MOCKUSER);
        assertFalse(inventory.getAvailableBooksList().contains(bookToReturn));
        inventory.returnBook(bookToReturn);
        assertTrue(inventory.getAvailableBooksList().contains(bookToReturn));
    }

    @Test
    public void testCheckOutMovie(){
        Movie movieToCheckout = inventory.getAvailableMoviesList().get(0);
        inventory.checkoutMovie(movieToCheckout, MOCKUSER);
        assertFalse(inventory.getAvailableBooksList().contains(movieToCheckout));
        assertTrue(inventory.getCheckedOutMoviesList().contains(movieToCheckout));
    }

    @Test
    public void testReturnMovie(){
        Movie movieToReturn = inventory.getAvailableMoviesList().get(0);
        inventory.checkoutMovie(movieToReturn, MOCKUSER);
        assertFalse(inventory.getAvailableMoviesList().contains(movieToReturn));
        inventory.returnMovie(movieToReturn);
        assertTrue(inventory.getAvailableMoviesList().contains(movieToReturn));
    }

}
