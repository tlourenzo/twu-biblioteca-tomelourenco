package com.twu.menus;


import com.twu.book.Book;
import com.twu.inventory.Inventory;
import com.twu.utilities.DisplayMessages;
import com.twu.utilities.Utilities;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by tlourenzo on 28-07-2017.
 */
public final class ReturnMenu {

    private final static ReturnMenu INSTANCE = new ReturnMenu();
    private Inventory inventory;
    private DisplayMessages display;
    private Scanner input;
    private PrintStream output;

    private ReturnMenu() {
    }

    public static ReturnMenu getInstance() {
        return INSTANCE;
    }

    public void run(Inventory inventory, DisplayMessages display, Scanner input, PrintStream output){

        this.inventory = inventory;
        this.display = display;
        this.input = input;
        this.output = output;
        start();
    }

    private void start() {
        output.print(display.bookListingMessage());
        output.print(Utilities.displayFormattedBookList(inventory.getCheckedOutBooksList()));
        output.print(display.returnMessage());
        returnMenuOption(input.nextInt());
    }

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
