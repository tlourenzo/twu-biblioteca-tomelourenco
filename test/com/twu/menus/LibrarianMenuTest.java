package com.twu.menus;

import com.twu.book.Book;
import com.twu.database.Inventory;
import com.twu.movie.Movie;
import com.twu.user.User;
import com.twu.utilities.DisplayMessages;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class LibrarianMenuTest {

    private DisplayMessages display;
    private Inventory inventory;
    private User loggedUser;
    private LibrarianMenu librarianMenu;

    @Before
    public void setUp() throws UnsupportedEncodingException {
        display = DisplayMessages.getInstance();
        inventory = new MockInventory();
        loggedUser = new User("000-0000", "1234","Test Librarian","Test@Email", "0000000");
        librarianMenu = new LibrarianMenu();


    }


    @Test
    public void testLibrarianMenuInit(){
        String input = "";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);

        librarianMenu.run(inventory, inputStream, printStream, display, loggedUser);
        String output = baos.toString();

        assertEquals("\n" +
                "\n" +
                "Welcome to the Management Menu \n" +
                "\n" +
                "Type            Title           Author/Director Current Holder \n" +
                "Book            Test Book       TWU             000-0000       \n" +
                "Movie           Test Movie      TestDirector    000-0000       \n" +
                "\n" +
                "Please press 0 to exit." +
                "\n", output);
    }


    private class MockInventory extends Inventory {

        Book bookTotest = new Book("Test Book", "TWU", 2017);
        Movie movieToTest = new Movie("Test Movie", 2017, "TestDirector", "10");

        @Override
        public List<Book> getAvailableBooksList() {
            bookTotest.setUserHoldingBook(loggedUser);
            return Collections.singletonList(bookTotest);
        }

        @Override
        public List<Book> getCheckedOutBooksList() {
            bookTotest.setUserHoldingBook(loggedUser);
            return Collections.singletonList(bookTotest);
        }

        @Override
        public List<Movie> getMovieList() {
            movieToTest.setUserHoldingMovie(loggedUser);
            return Collections.singletonList(movieToTest);
        }

        @Override
        public List<Movie> getAvailableMoviesList() {
            movieToTest.setUserHoldingMovie(loggedUser);
            return Collections.singletonList(movieToTest);
        }

        @Override
        public List<Movie> getCheckedOutMoviesList() {
            movieToTest.setUserHoldingMovie(loggedUser);
            return Collections.singletonList(movieToTest);
        }

        @Override
        public List<Book> getBookList() {
            bookTotest.setUserHoldingBook(loggedUser);
            return Collections.singletonList(bookTotest);
        }

    }
}
