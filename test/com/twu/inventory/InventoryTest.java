package com.twu.inventory;

import com.twu.book.Book;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by tlourenzo on 28-07-2017.
 */
public class InventoryTest {

    private Inventory inventory;
    private static final Book BOOK_1 = new Book("Awesome Book 1", "Awesome Author 1", 2017);
    private static final Book BOOK_2 = new Book("Awesome Book 2", "Awesome Author 2", 2017);

    @Before
    public void setUp(){
        inventory = new Inventory();
    }

    @Test
    public void testCreateBooksList(){
        assertEquals(BOOK_1, inventory.getBookList().get(0));
        assertEquals(BOOK_2, inventory.getBookList().get(1));
    }
}
