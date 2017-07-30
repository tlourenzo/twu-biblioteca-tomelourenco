/*
 * Created by Tome Lourenco for TWU 101
 * v.1.0
 */

package com.twu.inventory;

import com.twu.book.Book;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Tome Lourenco
 * v.1.0
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
    @Test
    public void testListsSize(){
        assertEquals(inventory.getBookList().size(), inventory.getAvailableBooksList().size()+inventory.getCheckedOutBooksList().size());
    }

    @Test
    public void testCheckOutBook(){
        Book bookToCheckout = inventory.getAvailableBooksList().get(0);
        inventory.checkoutBook(bookToCheckout);
        assertFalse(inventory.getAvailableBooksList().contains(bookToCheckout));
        assertTrue(inventory.getCheckedOutBooksList().contains(bookToCheckout));
    }

    @Test
    public void testReturnBook(){
        Book bookToReturn = inventory.getAvailableBooksList().get(0);
        inventory.checkoutBook(bookToReturn);
        assertFalse(inventory.getAvailableBooksList().contains(bookToReturn));
        inventory.returnBook(bookToReturn);
        assertTrue(inventory.getAvailableBooksList().contains(bookToReturn));
    }
}
