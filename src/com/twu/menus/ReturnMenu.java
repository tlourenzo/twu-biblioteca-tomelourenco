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
 * v.2.0
 */
public class ReturnMenu {

    private String typeOfItemToReturn;
    private Inventory inventory;
    private DisplayMessages display;
    private Scanner input;
    private PrintStream output;
    private User loggedUser;


    /**
     * Method to startReturnBook the console display of the return menu selection,
     * it receives all necessary streams and database to work with, as
     * well as all available messages to be displayed. Ir runs an aux method startReturnBook();
     * @param typeOfItemToReturn
     * @param inventory
     * @param display
     * @param input
     * @param output
     * @param loggedUser
     */
    public void run(String typeOfItemToReturn, Inventory inventory, DisplayMessages display, Scanner input, PrintStream output, User loggedUser){
        this.typeOfItemToReturn = typeOfItemToReturn;
        this.inventory = inventory;
        this.display = display;
        this.input = input;
        this.output = output;
        this.loggedUser = loggedUser;
        if(typeOfItemToReturn.equals("book")){
            startReturnBook();
        }else if(typeOfItemToReturn.equals("movie")){
            startReturnMovie();
        }
    }

    /**
     * Aux method to display the right messages and to receive user choice upon the presented list.
     * It is protected from abusing behavior or wrong keys.
     * Uses a recursive method if any wrong key is displayed.
     */
    private void startReturnBook() {
        output.print(display.returningBooksListTitle());
        output.print(display.bookListingMessage());
        output.print(Utilities.displayFormattedBookList(inventory.getCheckedOutBooksList()));
        output.print(display.returnBookMessage());
        if(input.hasNext("\\d+")){
            returnBookMenuOption(input.nextInt());
        }else{
            output.print(display.incorrectInputMessage());
            input.nextLine();
            startReturnBook();
        }

    }

    /**
     * Receiving a right option, this method will invoke the return method from the database.
     * @param selectOption
     */
    private void returnBookMenuOption(int selectOption) {
        if(selectOption == 0){
            return;
        }
        else{
            if(selectOption >0 && selectOption<=inventory.getCheckedOutBooksList().size()){
                Book bookToReturn = inventory.getCheckedOutBooksList().get(selectOption-1);
                inventory.returnBook(bookToReturn);
                output.print(display.successBookReturnMessage() + " " + bookToReturn.getBookName() + " by " + bookToReturn.getAuthor()+ "\n\n");
            }
            else{
                output.print(display.incorrectInputMessage());
                startReturnBook();
            }
        }

    }

    /**
     * Aux method to display the right messages and to receive user choice upon the presented list.
     * It is protected from abusing behavior or wrong keys.
     * Uses a recursive method if any wrong key is displayed.
     */
    private void startReturnMovie() {
        output.print(display.returningMoviesListTitle());
        output.print(display.movieListingMessage());
        output.print(Utilities.displayFormattedMovieList(inventory.getCheckedOutMoviesList()));
        output.print(display.returnMovieMessage());
        if(input.hasNext("\\d+")){
            returnMovieMenuOption(input.nextInt());
        }else{
            output.print(display.incorrectInputMessage());
            input.nextLine();
            startReturnMovie();
        }

    }

    /**
     * Receiving a right option, this method will invoke the return method from the database.
     * @param selectOption
     */
    private void returnMovieMenuOption(int selectOption) {
        if(selectOption == 0){
            return;
        }
        else{
            if(selectOption >0 && selectOption<=inventory.getCheckedOutMoviesList().size()){
                Movie movieToReturn = inventory.getCheckedOutMoviesList().get(selectOption-1);
                inventory.returnMovie(movieToReturn);
                output.print(display.successMovieReturnMessage() + " " + movieToReturn.getMovieName() + " by " + movieToReturn.getDirector()+ "\n\n");
            }
            else{
                output.print(display.incorrectInputMessage());
                startReturnBook();
            }
        }

    }
}
