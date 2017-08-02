/*
 * Created by Tome Lourenco for TWU 101
 * v.1.0
 */

package com.twu.menus;

import com.twu.database.Inventory;
import com.twu.user.User;
import com.twu.utilities.DisplayMessages;
import com.twu.utilities.Utilities;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by tlourenzo on 01-08-2017.
 */
public class LibrarianMenu {

    private Inventory inventory;
    private Scanner input;
    private PrintStream out;
    private DisplayMessages display;
    private User user;

    public LibrarianMenu() {
    }

    public void run(Inventory inventory, InputStream inputStream, PrintStream out, DisplayMessages display, User user) {

        this.inventory = inventory;
        this.input = new Scanner(inputStream);
        this.out = out;
        this.display = display;
        this.user = user;
        start();
    }

    private void start() {
        out.print(display.managementWelcomeMessage());
        out.print(display.librarianListingMessage());
        out.print(Utilities.displayFormattedLibrarianList(inventory.getCheckedOutBooksList()));
        out.print(Utilities.displayFormattedLibrarianList(inventory.getCheckedOutMoviesList()));
        out.print(display.librarianLogoutMessage());
        if(input.hasNext("\\d+")){
            if(input.nextInt()==0){
                return;
            }else{
            out.print(display.incorrectInputMessage());
            input.nextLine();
        }
    }
    }
}
