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
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


/**
 * Created by Tome Lourenco
 * v.1.0
 */
public class MainMenuTest {

    private MainMenu mainMenu;
    private DisplayMessages display;
    private Inventory inventory;
    private CheckoutMenu checkoutMenu;
    private ReturnMenu returnMenu;

    @Before
    public void setUp() throws UnsupportedEncodingException {
        mainMenu = new MainMenu();
        display = DisplayMessages.getInstance();
        inventory = new MockInventory();
        checkoutMenu = new MockCheckoutMenu();
        returnMenu = new MockReturnMenu();
    }

    @Test
    public void testInit(){
        String input = "1\n2\n3\n0\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        final PrintStream printStream = new PrintStream(baos);
        CheckoutMenu checkoutMenu = new MockCheckoutMenu(){
            @Override
            public void run(Inventory inventory, DisplayMessages display, Scanner input, PrintStream output) {
                printStream.print("\n\nCheckout Menu Called\n\n");
            }
        };
        ReturnMenu returnMenu = new MockReturnMenu(){
            @Override
            public void run(Inventory inventory, DisplayMessages display, Scanner input, PrintStream output) {
                printStream.print("\n\nReturn Menu Called\n\n");
            }
        };
        mainMenu.run(inventory,inputStream,printStream,display,checkoutMenu,returnMenu);
        String output = baos.toString();

        assertEquals("Welcome to Bangalore Biblioteca\n" +
                "\n" +
                "Available options:\n" +
                "1 - List available books in inventory\n" +
                "2 - Checkout Book\n" +
                "3 - Return Book\n" +
                "0 - Quit\n" +
                "Select your request by using the corresponding number:\n" +
                "Inventory of our Biblioteca:\n" +
                "\n" +
                "Book ID         Title           Author          Year Published \n" +
                "1               Test Book       TWU             2017           \n" +
                "Available options:\n" +
                "1 - List available books in inventory\n" +
                "2 - Checkout Book\n" +
                "3 - Return Book\n" +
                "0 - Quit\n" +
                "Select your request by using the corresponding number:\n" +
                "\n" +
                "\n" +
                "Checkout Menu Called\n" +
                "\n" +
                "Available options:\n" +
                "1 - List available books in inventory\n" +
                "2 - Checkout Book\n" +
                "3 - Return Book\n" +
                "0 - Quit\n" +
                "Select your request by using the corresponding number:\n" +
                "\n" +
                "\n" +
                "Return Menu Called\n" +
                "\n" +
                "Available options:\n" +
                "1 - List available books in inventory\n" +
                "2 - Checkout Book\n" +
                "3 - Return Book\n" +
                "0 - Quit\n" +
                "Select your request by using the corresponding number:\n" +
                "Thank you for using our automatic checkout system. Best Regards, Bangalore Biblioteca",output);
    }


    @Test
    public void testWrongOptionLetterInMenuOptions(){
        String input = "d\n0\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        final PrintStream printStream = new PrintStream(baos);
        mainMenu.run(inventory,inputStream,printStream,display,checkoutMenu,returnMenu);
        String output = baos.toString();

        assertEquals("Welcome to Bangalore Biblioteca\n" +
                "\n" +
                "Available options:\n" +
                "1 - List available books in inventory\n" +
                "2 - Checkout Book\n" +
                "3 - Return Book\n" +
                "0 - Quit\n" +
                "Select your request by using the corresponding number:\n" +
                "Please select a valid option.\n" +
                "\n" +
                "Available options:\n" +
                "1 - List available books in inventory\n" +
                "2 - Checkout Book\n" +
                "3 - Return Book\n" +
                "0 - Quit\n" +
                "Select your request by using the corresponding number:\n" +
                "Thank you for using our automatic checkout system. Best Regards, Bangalore Biblioteca", output);

        assertTrue(output.contains("Please select a valid option."));
    }

    @Test
    public void testWrongOptionNumberInMenuOptions(){
        String input = "9\n0\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        final PrintStream printStream = new PrintStream(baos);
        mainMenu.run(inventory,inputStream,printStream,display,checkoutMenu,returnMenu);
        String output = baos.toString();

        assertTrue(output.contains("Please select a valid option."));
    }

    @Test
    public void testMenuOption1(){
        String input = "1\n0\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        final PrintStream printStream = new PrintStream(baos);
        mainMenu.run(inventory,inputStream,printStream,display,checkoutMenu,returnMenu);
        String output = baos.toString();

        assertEquals("Welcome to Bangalore Biblioteca\n" +
                "\n" +
                "Available options:\n" +
                "1 - List available books in inventory\n" +
                "2 - Checkout Book\n" +
                "3 - Return Book\n" +
                "0 - Quit\n" +
                "Select your request by using the corresponding number:\n" +
                "Inventory of our Biblioteca:\n" +
                "\n" +
                "Book ID         Title           Author          Year Published \n" +
                "1               Test Book       TWU             2017           \n" +
                "Available options:\n" +
                "1 - List available books in inventory\n" +
                "2 - Checkout Book\n" +
                "3 - Return Book\n" +
                "0 - Quit\n" +
                "Select your request by using the corresponding number:\n" +
                "Thank you for using our automatic checkout system. Best Regards, Bangalore Biblioteca",output);

    }

    @Test
    public void testMenuOption2(){
        String input = "2\n0\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        final PrintStream printStream = new PrintStream(baos);
        CheckoutMenu checkoutMenu = new MockCheckoutMenu(){
            @Override
            public void run(Inventory inventory, DisplayMessages display, Scanner input, PrintStream output) {
                printStream.print("\n\nCheckout Menu Called\n\n");
            }
        };

        mainMenu.run(inventory,inputStream,printStream,display,checkoutMenu,returnMenu);
        String output = baos.toString();

        assertEquals("Welcome to Bangalore Biblioteca\n" +
                "\n" +
                "Available options:\n" +
                "1 - List available books in inventory\n" +
                "2 - Checkout Book\n" +
                "3 - Return Book\n" +
                "0 - Quit\n" +
                "Select your request by using the corresponding number:\n" +
                "\n" +
                "\n" +
                "Checkout Menu Called\n" +
                "\n" +
                "Available options:\n" +
                "1 - List available books in inventory\n" +
                "2 - Checkout Book\n" +
                "3 - Return Book\n" +
                "0 - Quit\n" +
                "Select your request by using the corresponding number:\n" +
                "Thank you for using our automatic checkout system. Best Regards, Bangalore Biblioteca",output);

    }

    @Test
    public void testMenuOption3(){
        String input = "3\n0\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        final PrintStream printStream = new PrintStream(baos);
        ReturnMenu returnMenu = new MockReturnMenu(){
            @Override
            public void run(Inventory inventory, DisplayMessages display, Scanner input, PrintStream output) {
                printStream.print("\n\nReturn Menu Called\n\n");
            }
        };
        mainMenu.run(inventory,inputStream,printStream,display,checkoutMenu,returnMenu);
        String output = baos.toString();

        assertEquals("Welcome to Bangalore Biblioteca\n" +
                "\n" +
                "Available options:\n" +
                "1 - List available books in inventory\n" +
                "2 - Checkout Book\n" +
                "3 - Return Book\n" +
                "0 - Quit\n" +
                "Select your request by using the corresponding number:\n" +
                "\n" +
                "\n" +
                "Return Menu Called\n" +
                "\n" +
                "Available options:\n" +
                "1 - List available books in inventory\n" +
                "2 - Checkout Book\n" +
                "3 - Return Book\n" +
                "0 - Quit\n" +
                "Select your request by using the corresponding number:\n" +
                "Thank you for using our automatic checkout system. Best Regards, Bangalore Biblioteca",output);
    }

    @Test
    public void testMenuOption0(){
        String input = "0\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        final PrintStream printStream = new PrintStream(baos);

        mainMenu.run(inventory,inputStream,printStream,display,checkoutMenu,returnMenu);
        String output = baos.toString();

        assertEquals("Welcome to Bangalore Biblioteca\n" +
                "\n" +
                "Available options:\n" +
                "1 - List available books in inventory\n" +
                "2 - Checkout Book\n" +
                "3 - Return Book\n" +
                "0 - Quit\n" +
                "Select your request by using the corresponding number:\n" +
                "Thank you for using our automatic checkout system. Best Regards, Bangalore Biblioteca",output);

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
        public boolean checkoutMenuCalled = false;
        @Override
        public void run(Inventory inventory, DisplayMessages display, Scanner input, PrintStream output) {
            checkoutMenuCalled = true;
        }
    }

    private class MockReturnMenu extends ReturnMenu {
        public boolean returnMenuCalled = false;
        @Override
        public void run(Inventory inventory, DisplayMessages display, Scanner input, PrintStream output) {
            returnMenuCalled = true;
        }
    }
}


