package com.twu.inventory;

import com.twu.book.Book;
import java.util.*;
import java.util.List;

/**
 * Created by tlourenzo on 28-07-2017.
 */
public class Inventory {

    private List<Book> books = new ArrayList<Book>();
    private List<Book> rentedBooks = new ArrayList<Book>();

    public Inventory() {
        this.createBooklist();
    }

    private void createBooklist() {
        books.add(new Book("Awesome Book 1", "Awesome Author 1", 2017));
        books.add(new Book("Awesome Book 2", "Awesome Author 2", 2017));
        books.add(new Book("Awesome Book 3", "Awesome Author 3", 2017));
        books.add(new Book("Awesome Book 4", "Awesome Author 4", 2017));
    }

    public List<Book> getAvailableBooksList(){
        List<Book> queryResult = new ArrayList<Book>();
        for(Book book : books){
            if(!rentedBooks.contains(book)){
                queryResult.add(book);
            }
        }
        return queryResult;
    }

    public List<Book> getCheckedOutBooksList(){
        List<Book> queryResult = new ArrayList<Book>();
        for(Book book : books){
            if(rentedBooks.contains(book)){
                queryResult.add(book);
            }
        }
        return queryResult;
    }

    public List<Book> getBookList(){
        return Collections.unmodifiableList(books);
    }
}
