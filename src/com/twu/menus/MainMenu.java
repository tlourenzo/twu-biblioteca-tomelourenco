package com.twu.menus;

import com.twu.inventory.Inventory;
import com.twu.utilities.DisplayMessages;
import com.twu.utilities.Utilities;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by tlourenzo on 28-07-2017.
 */
public final class MainMenu {

    private Inventory inventory;
    private Scanner input;
    private PrintStream output;
    private CheckoutMenu checkoutMenu = CheckoutMenu.getInstance();
    private ReturnMenu returnMenu = ReturnMenu.getInstance();
    private DisplayMessages display = DisplayMessages.getInstance();
    private boolean exit;

    private final static MainMenu INSTANCE = new MainMenu();

    private MainMenu() {
    }

    public static MainMenu getInstance(){
        return INSTANCE;
    }

    public void run(Inventory inventory) {
        this.inventory = inventory;
        input = new Scanner(System.in);
        output = System.out;
        init();
    }

    private void init() {
        output.print(display.welcomeMessage());
        do {
            output.print(display.mainMenuMessage());
            output.print(display.optionsMessage());
            if(input.hasNext()){
                mainMenuOption(input.nextInt());
            }
        }while(!exit);
    }

    private void mainMenuOption(int inputOption) {
        switch (inputOption){
            case 1:
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
