/*
 * Created by Tome Lourenco for TWU 101
 * v.1.0
 */

package com.twu.utilities;

import com.twu.book.Book;
import com.twu.movie.Movie;

import java.util.List;

/**
 * Created by Tome Lourenco
 * v.1.0
 */
public class Utilities {

    /**
     *
     * Receiving a book list, this method is designed to maintain a certain structure in displaying that list,
     * to keep a column for each field.
     * @param bookList
     * @return
     */
    public static String displayFormattedBookList(List<Book> bookList) {
        String formattedBookList = "";
        int index = 0;

        for (Book book : bookList) {
            index++;
            formattedBookList += String.format("%-15d %-15s %-15s %-15d\n", index, book.getBookName(), book.getAuthor(), book.getYearPublished());
        }
        return formattedBookList;
    }

    public static String displayFormattedMovieList(List<Movie> movieList) {
        String formattedMovieList = "";
        int index = 0;

        for (Movie movie : movieList) {
            index++;
            formattedMovieList += String.format("%-15d %-15s %-15s %-15d\n", index, movie.getMovieName(), movie.getDirector(), movie.getYear(), movie.getRating());
        }
        return formattedMovieList;
    }

    public static String displayFormattedLibrarianList(List list){
        String formattedList = "";
        for(Object object : list){
            if(object.getClass().equals(Movie.class)){
                Movie movie = (Movie) object;
                formattedList += String.format("%-15s %-15s %-15s %-15s\n","Movie", movie.getMovieName(), movie.getDirector(), movie.getUserHoldingMovie().getUsername());
            } else if(object.getClass().equals(Book.class)){
                Book book = (Book) object;
                formattedList += String.format("%-15s %-15s %-15s %-15s\n", "Book", book.getBookName(), book.getAuthor(), book.getUserHoldingBook().getUsername());
            }
            }
            return formattedList;
    }

}
