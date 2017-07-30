package com.twu.book;

import com.twu.inventory.Inventory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Tome Lourenco
 * v.1.0
 */
public class BookTest {

    private static final Book BOOK_1 = new Book("Awesome Book 1", "Awesome Author 1", 2017);
    private static final Book BOOK_2 = new Book("Awesome Book 2", "Awesome Author 2", 2017);
    private Inventory inventory;

    @Before
    public void setUp(){
        inventory = new Inventory();
    }

    @Test
    public void verifyBookAuthor(){
        assertEquals(BOOK_1.getAuthor(), inventory.getBookList().get(0).getAuthor());
        assertEquals(BOOK_2.getAuthor(), inventory.getBookList().get(1).getAuthor());
    }

    @Test
    public void verifyBookName(){
        assertEquals(BOOK_1.getBookName(), inventory.getBookList().get(0).getBookName());
        assertEquals(BOOK_2.getBookName(), inventory.getBookList().get(1).getBookName());
    }

    @Test
    public void verifyBookYear(){
        assertEquals(BOOK_1.getYearPublished(), inventory.getBookList().get(0).getYearPublished());
        assertEquals(BOOK_2.getYearPublished(), inventory.getBookList().get(1).getYearPublished());
    }

    @Test
    public void verifyIfEqualBooks(){
        assertTrue(BOOK_1.equals(BOOK_1));
        assertFalse(BOOK_1.equals(BOOK_2));
    }
}
