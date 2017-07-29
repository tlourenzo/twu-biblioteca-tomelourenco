package com.twu.menus;


import com.twu.inventory.Inventory;
import com.twu.utilities.DisplayMessages;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by tlourenzo on 28-07-2017.
 */
public final class ReturnMenu {

    private final static ReturnMenu INSTANCE = new ReturnMenu();
    private ReturnMenu() {
    }

    public static ReturnMenu getInstance() {
        return INSTANCE;
    }

    public void run(Inventory inventory, DisplayMessages display, Scanner input, PrintStream output){

    }
}
