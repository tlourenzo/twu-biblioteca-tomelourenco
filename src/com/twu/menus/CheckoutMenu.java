package com.twu.menus;

import com.twu.book.Book;
import com.twu.inventory.Inventory;
import com.twu.utilities.DisplayMessages;
import com.twu.utilities.Utilities;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by Tome Lourenco
 * v.1.0
 */
public class CheckoutMenu {

    private Inventory inventory;
    private DisplayMessages display;
    private Scanner input;
    private PrintStream output;
    private boolean back;

    /**
     * Method to start the console display of the checkout menu selection,
     * it receives all necessary streams and inventory to work with, as
     * well as all available messages to be displayed. Ir runs an aux method start();
     * @param inventory
     * @param display
     * @param input
     * @param output
     */
    public void run(Inventory inventory, DisplayMessages display, Scanner input, PrintStream output){
        this.inventory = inventory;
        this.display = display;
        this.input = input;
        this.output = output;
        start();
    }


    /**
     * Aux method to display the right messages and to receive user choice upon the presented list.
     * It is protected from abusing behavior or wrong keys.
     * Uses a recursive method if any wrong key is displayed.
     */
    private void start() {
        output.print(display.availableBooksListTitle());
        output.print(display.bookListingMessage());
        output.print(Utilities.displayFormattedBookList(inventory.getAvailableBooksList()));
        output.print(display.checkoutMessage());
        if(input.hasNext("\\d+")){
            checkoutMenuOption(input.nextInt());
        }else{
            output.print(display.incorrectInputMessage());
            input.nextLine();
            start();
        }

    }


    /**
     * Receiving a right option, this method will invoke the checkout method from the inventory.
     * @param selectOption
     */
    private void checkoutMenuOption(int selectOption) {
        if(selectOption == 0){
            return;
        }
        else{
            if(selectOption >0 && selectOption<=inventory.getAvailableBooksList().size()){
                Book bookToCheckout = inventory.getAvailableBooksList().get(selectOption-1);
                inventory.checkoutBook(bookToCheckout);
                output.print(display.successCheckoutMessage() + " " + bookToCheckout.getBookName() + " by " + bookToCheckout.getAuthor()+ "\n\n");
            }
            else{
                output.print(display.incorrectInputMessage());
                start();
            }
        }

    }

}
