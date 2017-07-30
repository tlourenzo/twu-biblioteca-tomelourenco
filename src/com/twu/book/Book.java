/*
 * Created by Tome Lourenco for TWU 101
 * v.1.0
 */

package com.twu.book;
/**
 * Created by Tome Lourenco
 * v.1.0
 */
public class Book {
    private String bookName;
    private String author;
    private int yearPublished;


    /**
     * Entity that represents each book in database
     * @param bookName
     * @param author
     * @param yearPublished
     */
    public Book(String bookName, String author, int yearPublished) {
        this.bookName = bookName;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (yearPublished != book.yearPublished) return false;
        if (!bookName.equals(book.bookName)) return false;
        return author.equals(book.author);
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", yearPublished=" + yearPublished +
                '}';
    }
}
