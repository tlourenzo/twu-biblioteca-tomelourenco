/*
 * Created by Tome Lourenco for TWU 101
 * v.1.0
 */

package com.twu.menus;

import com.twu.database.Inventory;
import com.twu.database.UsersDB;
import com.twu.user.User;
import com.twu.utilities.DisplayMessages;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by tlourenzo on 30-07-2017.
 */
public class LoginMenu {

    private UsersDB usersDB;
    private Scanner input;
    private PrintStream output;
    private DisplayMessages display;
    private LibrarianMenu librarianMenu;
    private MainMenu mainmenu;
    private CheckoutMenu checkoutMenu;
    private ReturnMenu returnMenu;
    private Inventory inventory;

    public void run(UsersDB usersDB, InputStream input, PrintStream output, DisplayMessages display, LibrarianMenu librarianMenu, MainMenu mainmenu, CheckoutMenu checkoutMenu, ReturnMenu returnMenu, Inventory inventory) {

        this.usersDB = usersDB;
        this.input = new Scanner(input);
        this.output = output;
        this.display = display;
        this.librarianMenu = librarianMenu;
        this.mainmenu = mainmenu;
        this.checkoutMenu = checkoutMenu;
        this.returnMenu = returnMenu;
        this.inventory = inventory;
        start();
    }

    private void start() {
        output.print(display.welcomeMessage());
        boolean exit = false;
        int wrongLoginAttempts =0;
        do {
            output.print(display.loginPageMessage());
            output.print(display.insertLoginMessage());
            if(input.hasNext("\\d{3}-\\d{4}")){
                String username = input.nextLine();
                output.print(display.insertPasswordMessage());
                String password = input.nextLine();
                login(username,password);
            }else{
                output.print(display.incorrectUsernameFormatMessage());
                input.nextLine();
                wrongLoginAttempts++;
                if(wrongLoginAttempts>=3){
                    exit = true;
                }
            }
        }while(!exit);
    }

    private void login(String username, String password) {

        try{
            if(!usersDB.getUserByID(username).equals(null)){
                User user = usersDB.getUserByID(username);
                if(user.getPassword().equals(password)){
                    output.print(display.loginSuccessfullyMessage());
                    if(user.getUsername().equals("000-0000")){
                        librarianMenu.run(inventory,System.in, System.out, display, user);
                    }else{
                        mainmenu.run(inventory, System.in, System.out, display, checkoutMenu, returnMenu, user);
                    }
                }else{
                    output.print(display.wrongPasswordMessage());
                }
            }

        }catch(Exception e){
            e.printStackTrace();
            output.print(display.userNotFoundMessage());
        }
    }
}
