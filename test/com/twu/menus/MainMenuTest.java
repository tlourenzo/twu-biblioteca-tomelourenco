package com.twu.menus;


import com.twu.book.Book;
import com.twu.inventory.Inventory;
import com.twu.utilities.DisplayMessages;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.Collections;
import java.util.List;


/**
 * Created by tlourenzo on 29-07-2017.
 */
public class MainMenuTest {

    private MainMenu mainMenu;
    private DisplayMessages display;
    private Inventory inventory;
    private CheckoutMenu checkoutMenu;
    private ReturnMenu returnMenu;

    @Before
    public void setUp() throws UnsupportedEncodingException {
        mainMenu = MainMenu.getInstance();
        display = DisplayMessages.getInstance();
        inventory = new MockInventory();
        checkoutMenu = CheckoutMenu.getInstance();
        returnMenu = ReturnMenu.getInstance();
    }

    @Test
    public void testInit(){
        //todo
    }

    @Test
    public void testMainMenuOptions(){

    }

    @Test
    public void testWrongOptionNumberInMenuOptions(){

    }

    @Test
    public void testLetterInputInMenuOptions(){

    }

    @Test
    public void testMenuOption1(){

    }

    @Test
    public void testMenuOption2(){

    }

    @Test
    public void testMenuOption3(){

    }

    @Test
    public void testMenuOption0(){

    }

    @Test
    public void testMenuOptionDefault(){

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

}


