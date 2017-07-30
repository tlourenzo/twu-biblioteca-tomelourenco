/*
 * Created by Tome Lourenco for TWU 101
 * v.1.0
 */


package com.twu.utilities;

import java.util.*;
import com.twu.book.Book;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Tome Lourenco
 * v.1.0
 */
public class UtilitiesTest {

    private List<Book> booksList;

    @Before
    public void setUp(){
        booksList = new ArrayList<Book>();
        booksList.add(new Book("Test Book", "Test Author", 2017));
    }

    @Test
    public void testBookListFormat(){
        String toTest = String.format("%-15d %-15s %-15s %-15d\n", 1, "Test Book", "Test Author", 2017);
        assertEquals(Utilities.displayFormattedBookList(booksList), toTest);
    }
}
