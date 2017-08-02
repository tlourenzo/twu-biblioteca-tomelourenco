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
 * Created by Tome Lourenco
 * v.1.0
 */
public class MainMenu {

    private Inventory inventory;
    private Scanner input;
    private PrintStream output;
    private CheckoutMenu checkoutMenu;
    private ReturnMenu returnMenu;
    private User loggedUser;
    private DisplayMessages display;
    private boolean exit;

    /**
     * Starting point of the entire program, as the main menu, this method receives all necessary streams to display and
     * receive user input, as well as display messages, and the existing database.
     * Uses an aux method start() to start displaying choices.
     *
     * @param inventory
     * @param inputStream
     * @param outputStream
     * @param displayMessages
     * @param checkoutMenu
     * @param returnMenu
     */
    public void run(Inventory inventory, InputStream inputStream, PrintStream outputStream,
                    DisplayMessages displayMessages, CheckoutMenu checkoutMenu, ReturnMenu returnMenu, User loggedUser) {
        this.inventory = inventory;
        this.input = new Scanner(inputStream);
        this.output = outputStream;
        this.display = displayMessages;
        this.checkoutMenu = checkoutMenu;
        this.returnMenu = returnMenu;
        this.loggedUser = loggedUser;
        start();
    }

    /**
     * Aux method used by run() method to display menu information and keep it as loop
     * as long user don't quit the program.
     * uses an aux method, mainMenuOption() to handle user choices.
     */
    private void start() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        output.print(display.welcomeMessage() + loggedUser.getName() +"\n\n");
        do {
            output.print(display.mainMenuMessage());
            output.print(display.optionsMessage());
            if(input.hasNext("\\d+")){
                mainMenuOption(input.nextInt());
            }else{
                output.print(display.incorrectInputMessage());
                input.nextLine();
            }
        }while(!exit);
    }

    /**
     * Method to handle user choices and proceed to the right action.
     * uses user input to trigger the right method.
     * @param inputOption
     */
    private void mainMenuOption(int inputOption) {
        switch (inputOption){
            case 1:
                output.print(display.allBooksListTitle());
                output.print(display.bookListingMessage());
                output.print(Utilities.displayFormattedBookList(inventory.getAvailableBooksList()));
                break;
            case 2:
                if(inventory.getAvailableBooksList().isEmpty()){
                    output.print(display.incorrectBookCheckoutMessage());
                }else{
                    checkoutMenu.run("book",inventory, display, input, output, loggedUser);
                }
                break;
            case 3:
                if(inventory.getCheckedOutBooksList().isEmpty()){
                    output.print(display.incorrectBookReturnMessage());
                }else{
                    returnMenu.run("movie", inventory, display, input, output, loggedUser);
                }
                break;
            case 4:
                if(inventory.getAvailableMoviesList().isEmpty()){
                    output.print(display.incorrectBookCheckoutMessage());
                }else{
                    checkoutMenu.run("movie",inventory, display, input, output, loggedUser);
                }
                break;

            case 5:
                if(inventory.getCheckedOutMoviesList().isEmpty()){
                    output.print(display.incorrectMovieReturnMessage());
                }else{
                    returnMenu.run("movie",inventory, display, input, output, loggedUser);
                }
                break;
            case 0:
                output.print(display.exitMessage());
                exit = true;
                break;
            default:
                output.print(display.incorrectInputMessage());
                break;
        }
    }
}
