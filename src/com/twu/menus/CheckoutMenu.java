/*
 * Created by Tome Lourenco for TWU 101
 * v.1.0
 */

package com.twu.menus;

import com.twu.book.Book;
import com.twu.database.Inventory;
import com.twu.movie.Movie;
import com.twu.user.User;
import com.twu.utilities.DisplayMessages;
import com.twu.utilities.Utilities;

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
    private User loggedUser;
    private boolean back;

    /**
     * Method to startCheckoutBook the console display of the checkout menu selection,
     * it receives all necessary streams and database to work with, as
     * well as all available messages to be displayed. Ir runs an aux method startCheckoutBook();
     * @param inventory
     * @param display
     * @param input
     * @param output
     */
    public void run(String typeOfItemToBeCheckout, Inventory inventory, DisplayMessages display, Scanner input, PrintStream output, User loggedUser){
        this.inventory = inventory;
        this.display = display;
        this.input = input;
        this.output = output;
        this.loggedUser = loggedUser;
        if(typeOfItemToBeCheckout.equals("book")){
            startCheckoutBook();
        }else if(typeOfItemToBeCheckout.equals("movie")){
            startCheckoutMovie();
        }
    }


    /**
     * Aux method to display the right messages and to receive user choice upon the presented list.
     * It is protected from abusing behavior or wrong keys.
     * Uses a recursive method if any wrong key is displayed.
     */
    private void startCheckoutBook() {
        output.print(display.availableBooksListTitle());
        output.print(display.bookListingMessage());
        output.print(Utilities.displayFormattedBookList(inventory.getAvailableBooksList()));
        output.print(display.checkoutBookMessage());
        if(input.hasNext("\\d+")){
            checkoutBookMenuOption(input.nextInt());
        }else{
            output.print(display.incorrectInputMessage());
            input.nextLine();
            startCheckoutBook();
        }

    }

    private void startCheckoutMovie() {
        output.print(display.availableMoviesListTitle());
        output.print(display.movieListingMessage());
        output.print(Utilities.displayFormattedMovieList(inventory.getAvailableMoviesList()));
        output.print(display.checkoutMovieMessage());
        if(input.hasNext("\\d+")){
            checkoutMovieMenuOption(input.nextInt());
        }else{
            output.print(display.incorrectInputMessage());
            input.nextLine();
            startCheckoutMovie();
        }
    }

    /**
     * Receiving a right option, this method will invoke the checkout method from the database.
     * @param selectOption
     */
    private void checkoutBookMenuOption(int selectOption) {
        if(selectOption == 0){
            return;
        }
        else{
            if(selectOption >0 && selectOption<=inventory.getAvailableBooksList().size()){
                Book bookToCheckout = inventory.getAvailableBooksList().get(selectOption-1);
                inventory.checkoutBook(bookToCheckout, loggedUser);
                output.print(display.successBookCheckoutMessage() + " " + bookToCheckout.getBookName() + " by " + bookToCheckout.getAuthor()+ "\n\n");
                return;
            }
            else{
                output.print(display.incorrectInputMessage());
                startCheckoutBook();
            }
        }

    }

    private void checkoutMovieMenuOption(int selectOption) {
        if(selectOption == 0){
            return;
        }
        else{
            if(selectOption >0 && selectOption<=inventory.getAvailableMoviesList().size()){
                Movie movieToCheckout = inventory.getAvailableMoviesList().get(selectOption-1);
                inventory.checkoutMovie(movieToCheckout, loggedUser);
                output.print(display.successMovieCheckoutMessage() + " " + movieToCheckout.getMovieName() + " by " + movieToCheckout.getDirector()+ "\n\n");
                return;
            }
            else{
                output.print(display.incorrectInputMessage());
                startCheckoutMovie();
            }
        }
    }


}
