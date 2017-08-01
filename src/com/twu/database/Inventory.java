/*
 * Created by Tome Lourenco for TWU 101
 * v.1.0
 */

package com.twu.database;

import com.twu.book.Book;
import com.twu.movie.Movie;
import com.twu.user.User;

import java.util.*;
import java.util.List;
/**
 * Created by Tome Lourenco
 * v.2.0
 */
public class Inventory {

    private List<Book> books = new ArrayList<Book>();
    private List<Book> rentedBooks = new ArrayList<Book>();
    private List<Movie> movies = new ArrayList<Movie>();
    private List<Movie> rentedMovies = new ArrayList<Movie>();

    /**
     * Entity that is responsible for maintain books database
     */
    public Inventory() {
        this.createBooklist();
    }

    private void createBooklist() {
        books.add(new Book("Awesome Book 1", "Awesome Author 1", 2017));
        books.add(new Book("Awesome Book 2", "Awesome Author 2", 2017));
        books.add(new Book("Awesome Book 3", "Awesome Author 3", 2017));
        books.add(new Book("Awesome Book 4", "Awesome Author 4", 2017));
        movies.add(new Movie("Awesome Movie 1", 2017, "Awesome Director 1", "10"));
        movies.add(new Movie("Awesome Movie 2", 2017, "Awesome Director 2", "10"));
        movies.add(new Movie("Awesome Movie 3", 2017, "Awesome Director 3", "10"));
        movies.add(new Movie("Awesome Movie 4", 2017, "Awesome Director 4", "10"));

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
     * Method to check all books in database.
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
    public void checkoutBook(Book bookToCheckout, User user) {
        rentedBooks.add(bookToCheckout);
        bookToCheckout.setUserHoldingBook(user);
    }


    /**
     * Method to return a checked out book, by removing it from rentedBooks list.
     * @param bookToReturn
     */
    public void returnBook(Book bookToReturn){
        rentedBooks.remove(bookToReturn);
        bookToReturn.setUserHoldingBook(null);
    }




    //TODO replicate methods to movies

    /**
     * Method to return a list of books currently available for checking out,
     * uses an aux List, created as method is called to compare if books are or not available,
     * meaning that are part or not of rentedMovies list.
     * @return Movies list that are not checked out
     */
    public List<Movie> getAvailableMoviesList(){
        List<Movie> queryResult = new ArrayList<Movie>();
        for(Movie movie : movies){
            if(!rentedMovies.contains(movie)){
                queryResult.add(movie);
            }
        }
        return queryResult;
    }


    /**
     * Method to returns a list of currently rented movies at runtime,
     * uses an aux list created as method is called, to confirm if movies are rented.
     * @return list of checkout movies
     */
    public List<Movie> getCheckedOutMoviesList(){
        List<Movie> queryResult = new ArrayList<Movie>();
        for(Movie movie : movies){
            if(rentedMovies.contains(movie)){
                queryResult.add(movie);
            }
        }
        return queryResult;
    }


    /**
     * Method to check all movies in database.
     * @return a full movies list
     */
    public List<Movie> getMovieList(){
        return Collections.unmodifiableList(movies);
    }

    /**
     * Method to checkout selected movie as a param,
     * basically add that movie to the rentedMovies list
     * @param movieToCheckout
     */
    public void checkoutMovie(Movie movieToCheckout, User user) {
        rentedMovies.add(movieToCheckout);
        movieToCheckout.setUserHoldingMovie(user);
    }


    /**
     * Method to return a checked out movie, by removing it from rentedMovies list.
     * @param movieToReturn
     */
    public void returnMovie(Movie movieToReturn){
        rentedMovies.remove(movieToReturn);
        movieToReturn.setUserHoldingMovie(null);
    }




}
