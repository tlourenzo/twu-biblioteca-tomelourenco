package com.twu.utilities;

import com.twu.book.Book;

import java.util.List;

/**
 * Created by tlourenzo on 28-07-2017.
 */
public class Utilities {

    public static String displayFormattedBookList(List<Book> bookList) {
        String formattedBookList = "";
        int index = 0;

        for (Book book : bookList) {
            index++;
            formattedBookList += String.format("%-15d %-15s %-15s %-15d\n", index, book.getBookName(), book.getAuthor(), book.getYearPublished());
        }
        return formattedBookList;
    }
}
