package com.twu.utilities;

import com.twu.book.Book;

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
}
