/*
 * Created by Tome Lourenco for TWU 101
 * v.1.0
 */

package com.twu.utilities;

/**
 * Created by Tome Lourenco
 * v.1.0
 */
public final class DisplayMessages {

    private final static DisplayMessages INSTANCE = new DisplayMessages();


    /**
     * Singleton created with the purpose to handle all app messages.
     * Its several messages/methods are used around the app.
     */
    private DisplayMessages() {
    }

    public static DisplayMessages getInstance() {
        return INSTANCE;
    }

    public String welcomeMessage(){
        return "Welcome to Bangalore Biblioteca\n\n";
    }

    public String mainMenuMessage(){
        return "Available options:\n"+
                "1 - List available books in database\n"+
                "2 - Checkout Book\n"+
                "3 - Return Book\n"+
                "0 - Quit\n";
    }

    public String optionsMessage(){
        return "Select your request by using the corresponding number:\n";
    }

    public String availableBooksListTitle(){
        return "Books available to checkout:\n\n";
    }

    public String returninBooksListTitle(){
        return "Books to be returned:\n\n";
    }

    public String allBooksListTitle(){
        return "Inventory of our Biblioteca:\n\n";
    }

    public String bookListingMessage(){
        return String.format("%-15s %-15s %-15s %-15s\n", "Book ID", "Title", "Author", "Year Published");
    }

    public String incorrectInputMessage(){
        return "Please select a valid option.\n\n";
    }

    public String incorrectBookReturnMessage(){
        return "No books to be returned.\n\n";
    }

    public String incorrectCheckoutMessage(){
        return "No available books to checkout.\n\n";
    }

    public String exitMessage(){
        return "Thank you for using our automatic checkout system. Best Regards, Bangalore Biblioteca";
    }

    public String successCheckoutMessage(){
        return "Thank you for checking your book out! Enjoy ";
    }

    public String successReturnMessage(){
        return "Thank you for returning your book. We hope you have enjoyed reading ";
    }

    public String checkoutMessage(){
        return "Please select the book to checkout by Book ID or press 0 to return to main Menu:\n\n";
    }

    public String returnMessage(){
        return "Please select the returning book by Book ID or press 0 to return to main Menu:\n\n";
    }

}
