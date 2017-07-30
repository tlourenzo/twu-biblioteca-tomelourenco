package com.twu.biblioteca;

import com.twu.inventory.Inventory;
import com.twu.menus.CheckoutMenu;
import com.twu.menus.MainMenu;
import com.twu.menus.ReturnMenu;
import com.twu.utilities.DisplayMessages;

import java.util.Scanner;

/**
 * Created by Tome Lourenco
 * v.1.0
 */
public class BibliotecaApp {

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        MainMenu mainMenu = new MainMenu();
        CheckoutMenu checkoutMenu = new CheckoutMenu();
        ReturnMenu returnMenu = new ReturnMenu();
        DisplayMessages displayMessages = DisplayMessages.getInstance();

        mainMenu.run(inventory, System.in, System.out, displayMessages, checkoutMenu, returnMenu);
    }
}
