/*
 * Created by Tome Lourenco for TWU 101
 * v.1.0
 */


package com.twu.menus;

import com.twu.inventory.Inventory;
import com.twu.utilities.DisplayMessages;
import com.twu.utilities.Utilities;

import java.io.IOException;
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
    private DisplayMessages display;
    private boolean exit;

    /**
     * Starting point of the entire program, as the main menu, this method receives all necessary streams to display and
     * receive user input, as well as display messages, and the existing inventory.
     * Uses an aux method init() to start displaying choices.
     *
     * @param inventory
     * @param inputStream
     * @param outputStream
     * @param displayMessages
     * @param checkoutMenu
     * @param returnMenu
     */
    public void run(Inventory inventory, InputStream inputStream, PrintStream outputStream,
                    DisplayMessages displayMessages, CheckoutMenu checkoutMenu, ReturnMenu returnMenu) {
        this.inventory = inventory;
        this.input = new Scanner(inputStream);
        this.output = outputStream;
        this.display = displayMessages;
        this.checkoutMenu = checkoutMenu;
        this.returnMenu = returnMenu;
        init();
    }

    /**
     * Aux method used by run() method to display menu information and keep it as loop
     * as long user don't quit the program.
     * uses an aux method, mainMenuOption() to handle user choices.
     */
    private void init() {
        output.print(display.welcomeMessage());
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
                    output.print(display.incorrectCheckoutMessage());
                }else{
                    checkoutMenu.run(inventory, display, input, output);
                }
                break;
            case 3:
                if(inventory.getCheckedOutBooksList().isEmpty()){
                    output.print(display.incorrectBookReturnMessage());
                }else{
                    returnMenu.run(inventory, display, input, output);
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
