package com.twu.utilities;

/**
 * Created by tlourenzo on 28-07-2017.
 */
public class DisplayMessages {

    public String welcomeMessage(){
        return "Welcome to Bangalore Library";
    }

    public String mainMenuMessage(){
        return "Enter one of the following available options:\n"+
                "1 - List available books in inventory\n"+
                "2 - Quit\n";
    }

    public String optionsMessage(){
        return "Enter one of the following available options:\n"+
                "1 - Checkout Book\n"+
                "2 - Return Book\n"+
                "3 - Main Menu\n";
    }

    public String bookListMessage(){
        return null;
    }

    public String incorrectInputMessage(){
        return null;
    }

    public String incorrectBookReturnMessage(){
        return null;
    }

    public String incorrectCheckoutMessage(){
        return null;
    }

    public String exitMessage(){
        return null;
    }

    public String successCheckoutMessage(){
        return null;
    }

    public String successReturnMessage(){
        return null;
    }


}
