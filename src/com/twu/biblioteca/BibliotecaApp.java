package com.twu.biblioteca;

import com.twu.inventory.Inventory;
import com.twu.menus.CheckoutMenu;
import com.twu.menus.MainMenu;
import com.twu.menus.ReturnMenu;
import com.twu.utilities.DisplayMessages;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        MainMenu mainMenu = MainMenu.getInstance();
        CheckoutMenu checkoutMenu = CheckoutMenu.getInstance();
        ReturnMenu returnMenu = ReturnMenu.getInstance();
        DisplayMessages displayMessages = DisplayMessages.getInstance();

        mainMenu.run(inventory, System.in, System.out, displayMessages, checkoutMenu, returnMenu);
    }
}
