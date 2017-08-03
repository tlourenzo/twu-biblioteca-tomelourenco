package com.twu.menus;

import com.twu.database.Inventory;
import com.twu.user.User;
import com.twu.utilities.DisplayMessages;
import com.twu.utilities.Utilities;
import java.io.PrintStream;
import java.util.Scanner;

public class UserMenu {

    private Inventory inventory;
    private Scanner input;
    private PrintStream out;
    private DisplayMessages display;
    private User user;

    public void run(Inventory inventory, Scanner input, PrintStream out, DisplayMessages display, User user) {

        this.inventory = inventory;
        this.input = input;
        this.out = out;
        this.display = display;
        this.user = user;
        start();
    }

    private void start() {
        out.print(display.userDetailsWelcomeMessage());
        out.print("\nUserName: " + user.getUsername());
        out.print("\nPassword: " + user.getPassword());
        out.print("\nName: " + user.getName());
        out.print("\nEmail: " + user.getEmail());
        out.print("\nPhoneNumber: " + user.getPhonenumber());

        out.print("\n"+display.userListsMessage());
        out.print(display.librarianListingMessage());
        out.print(Utilities.displayFormattedLibrarianList(inventory.getCheckedOutBooksListByUser(user)));
        out.print(Utilities.displayFormattedLibrarianList(inventory.getCheckedOutMoviesListByUser(user)));
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
