/*
 * Created by Tome Lourenco for TWU 101
 * v.1.0
 */

package com.twu.menus;

import com.twu.book.Book;
import com.twu.database.Inventory;
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
import static org.junit.Assert.assertTrue;

/**
 * Created by Tome Lourenco
 * v.1.0
 */
public class ReturnMenuTest {

    private DisplayMessages display;
    private Inventory inventory;
    private CheckoutMenu checkoutMenu;
    private ReturnMenu returnMenu;
    private User loggedUser;

    @Before
    public void setUp() throws UnsupportedEncodingException {
        display = DisplayMessages.getInstance();
        inventory = new MockInventory();
        checkoutMenu = new MockCheckoutMenu();
        returnMenu = new MockReturnMenu();
        loggedUser = new User("123-1234", "1234","Test User","Test@Email", "0000000");
    }

    @Test
    public void testReturnMenuInit(){
        String input = "1\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);

        returnMenu.run(input, inventory, display, new Scanner(inputStream), printStream, loggedUser);
        String output = baos.toString();

        assertEquals("Books to be returned:\n" +
                "\n" +
                "Book ID         Title           Author          Year Published \n" +
                "1               Test Book       TWU             2017           \n" +
                "Please select the returning book by Book ID or press 0 to return to main Menu:\n" +
                "\n" +
                "Thank you for returning your book. We hope you have enjoyed reading  Test Book by TWU\n" +
                "\n", output);
    }

    @Test
    public void testWrongIdInput(){
        String input = "9\n0\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);

        checkoutMenu.run("book", inventory, display, new Scanner(inputStream), printStream, loggedUser);
        String output = baos.toString();

        assertTrue(output.contains("Please select a valid option."));
    }

    @Test
    public void testWrongIdInputAsLetter() {
        String input = "a\n0\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);

        checkoutMenu.run("book", inventory, display, new Scanner(inputStream), printStream,loggedUser);
        String output = baos.toString();

        assertTrue(output.contains("Please select a valid option."));
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
