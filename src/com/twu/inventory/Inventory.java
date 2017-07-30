package com.twu.inventory;

import com.twu.book.Book;
import java.util.*;
import java.util.List;
/**
 * Created by Tome Lourenco
 * v.1.0
 */
public class Inventory {

    private List<Book> books = new ArrayList<Book>();
    private List<Book> rentedBooks = new ArrayList<Book>();

    /**
     * Entity that is responsible for maintain books inventory
     */
    public Inventory() {
        this.createBooklist();
    }

    private void createBooklist() {
        books.add(new Book("Awesome Book 1", "Awesome Author 1", 2017));
        books.add(new Book("Awesome Book 2", "Awesome Author 2", 2017));
        books.add(new Book("Awesome Book 3", "Awesome Author 3", 2017));
        books.add(new Book("Awesome Book 4", "Awesome Author 4", 2017));
    }

    /**
     * Method to return a list of books currently available for checking out,
     * uses an aux List, created as method is called to compare if books are or not available,
     * meaning that are part or not of rentedBooks list.
     * @return Books list that are not checked out
     */
    public List<Book> getAvailableBooksList(){
        List<Book> queryResult = new ArrayList<Book>();
        for(Book book : books){
            if(!rentedBooks.contains(book)){
                queryResult.add(book);
            }
        }
        return queryResult;
    }


    /**
     * Method to returns a list of currently rented books at runtime,
     * uses an aux list created as method is called, to confirm if books are rented.
     * @return list of checkout books
     */
    public List<Book> getCheckedOutBooksList(){
        List<Book> queryResult = new ArrayList<Book>();
        for(Book book : books){
            if(rentedBooks.contains(book)){
                queryResult.add(book);
            }
        }
        return queryResult;
    }


    /**
     * Method to check all books in inventory.
     * @return a full books list
     */
    public List<Book> getBookList(){
        return Collections.unmodifiableList(books);
    }

    /**
     * Method to checkout selected book as a param,
     * basically add that book to the rentedBooks list
     * @param bookToCheckout
     */
    public void checkoutBook(Book bookToCheckout) {
        rentedBooks.add(bookToCheckout);
    }


    /**
     * Method to return a checked out book, by removing it from rentedBooks list.
     * @param bookToReturn
     */
    public void returnBook(Book bookToReturn){
        rentedBooks.remove(bookToReturn);
    }
}
