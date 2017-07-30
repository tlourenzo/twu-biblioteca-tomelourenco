package com.twu.menus;

import com.twu.book.Book;
import com.twu.inventory.Inventory;
import com.twu.utilities.DisplayMessages;
import com.twu.utilities.Utilities;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by tlourenzo on 28-07-2017.
 */
public class CheckoutMenu {

    private Inventory inventory;
    private DisplayMessages display;
    private Scanner input;
    private PrintStream output;
    private boolean back;

    public void run(Inventory inventory, DisplayMessages display, Scanner input, PrintStream output){
        this.inventory = inventory;
        this.display = display;
        this.input = input;
        this.output = output;
        start();
    }

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
