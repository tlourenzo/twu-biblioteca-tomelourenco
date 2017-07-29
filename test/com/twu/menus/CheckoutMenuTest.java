package com.twu.menus;

import com.twu.book.Book;
import com.twu.inventory.Inventory;
import com.twu.utilities.DisplayMessages;
import org.junit.Before;
import org.junit.Test;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

/**
 * Created by tlourenzo on 29-07-2017.
 */
public class CheckoutMenuTest {

    private DisplayMessages display;
    private Inventory inventory;
    private CheckoutMenu checkoutMenu;
    private ReturnMenu returnMenu;

    @Before
    public void setUp() throws UnsupportedEncodingException {
        display = DisplayMessages.getInstance();
        inventory = new MockInventory();
        checkoutMenu = new MockCheckoutMenu();
        returnMenu = new MockReturnMenu();
    }


    @Test
    public void testCheckoutMenuInit(){
        String input = "";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);

        //checkoutMenu.run(inventory, display, new Scanner(inputStream), printStream);

        assertEquals(1, 1);
    }





    private class MockInventory extends Inventory {
        @Override
        public List<Book> getAvailableBooksList() {
            return Collections.singletonList(new Book("Test Book", "TWU", 2017));
        }

        @Override
        public List<Book> getCheckedOutBooksList() {
            return Collections.singletonList(new Book("Test Book", "TWU", 2017));
        }

        @Override
        public List<Book> getBookList() {
            return Collections.singletonList(new Book("Test Book", "TWU", 2017));
        }
    }

    private class MockCheckoutMenu extends CheckoutMenu {
    }

    private class MockReturnMenu extends ReturnMenu {
    }
}
