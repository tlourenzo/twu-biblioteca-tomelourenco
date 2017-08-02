/*
 * Created by Tome Lourenco for TWU 101
 * v.1.0
 */

package com.twu.biblioteca;

import com.twu.database.Inventory;
import com.twu.database.UsersDB;
import com.twu.menus.*;
import com.twu.utilities.DisplayMessages;

/**
 * Created by Tome Lourenco
 * v.1.0
 */
public class BibliotecaApp {

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        MainMenu mainMenu = new MainMenu();
        LibrarianMenu librarianMenu = new LibrarianMenu();
        CheckoutMenu checkoutMenu = new CheckoutMenu();
        ReturnMenu returnMenu = new ReturnMenu();
        LoginMenu login = new LoginMenu();
        UsersDB usersDB = new UsersDB();
        DisplayMessages displayMessages = DisplayMessages.getInstance();

        login.run(usersDB, System.in, System.out, displayMessages,librarianMenu, mainMenu, checkoutMenu, returnMenu, inventory);
    }
}
