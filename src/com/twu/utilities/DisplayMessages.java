package com.twu.utilities;

/**
 * Created by tlourenzo on 28-07-2017.
 */
public final class DisplayMessages {

    private final static DisplayMessages INSTANCE = new DisplayMessages();
    private DisplayMessages() {
    }

    public static DisplayMessages getInstance() {
        return INSTANCE;
    }

    public String welcomeMessage(){
        return "Welcome to Bangalore Biblioteca\n\n";
    }

    public String mainMenuMessage(){
        return "Enter one of the following available options:\n"+
                "1 - List available books in inventory\n"+
                "2 - Checkout Book\n"+
                "3 - Return Book\n"+
                "0 - Quit\n";
    }

    public String optionsMessage(){
        return "Enter one of the following available options:\n";
    }

    public String bookListingMessage(){
        String availableBooks = "Available Books:\n\n";
        String formattedColumnTitle = String.format("%-15s %-15s %-15s %-15s\n", "Book ID", "Title", "Author", "Year Published");
        return availableBooks + formattedColumnTitle;
    }

    public String incorrectInputMessage(){
        return "Please select a valid option.";
    }

    public String incorrectBookReturnMessage(){
        return "No books to be returned.";
    }

    public String incorrectCheckoutMessage(){
        return "No available books to checkout.";
    }

    public String exitMessage(){
        return "Thank you for using our automatic checkout system. Best Regards, Bangalore Biblioteca";
    }

    public String successCheckoutMessage(){
        return "Thank you for checking out your book! Enjoy!" ;
    }

    public String successReturnMessage(){
        return "Thank you for returning your book. Hope you have enjoyed reading it!";
    }

    public String checkoutMessage(){
        return "Please select your book by is Book ID or press 0 to return to main Menu.";
    }

}
