package com.twu.biblioteca;

import com.twu.inventory.Inventory;
import com.twu.menus.MainMenu;

public class BibliotecaApp {

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        MainMenu mainMenu = new MainMenu(inventory);
        mainMenu.launch();
    }
}
