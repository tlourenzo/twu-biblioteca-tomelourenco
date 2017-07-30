/*
 * Created by Tome Lourenco for TWU 101
 * v.1.0
 */


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
public class ReturnMenu {

    private Inventory inventory;
    private DisplayMessages display;
    private Scanner input;
    private PrintStream output;


    /**
     * Method to start the console display of the return menu selection,
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
        output.print(display.returninBooksListTitle());
        output.print(display.bookListingMessage());
        output.print(Utilities.displayFormattedBookList(inventory.getCheckedOutBooksList()));
        output.print(display.returnMessage());
        if(input.hasNext("\\d+")){
            returnMenuOption(input.nextInt());
        }else{
            output.print(display.incorrectInputMessage());
            input.nextLine();
            start();
        }

    }

    /**
     * Receiving a right option, this method will invoke the return method from the inventory.
     * @param selectOption
     */
    private void returnMenuOption(int selectOption) {
        if(selectOption == 0){
            return;
        }
        else{
            if(selectOption >0 && selectOption<=inventory.getCheckedOutBooksList().size()){
                Book bookToReturn = inventory.getCheckedOutBooksList().get(selectOption-1);
                inventory.returnBook(bookToReturn);
                output.print(display.successReturnMessage() + " " + bookToReturn.getBookName() + " by " + bookToReturn.getAuthor()+ "\n\n");
            }
            else{
                output.print(display.incorrectInputMessage());
                start();
            }
        }

    }
}
