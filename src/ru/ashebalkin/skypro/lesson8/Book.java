package ru.ashebalkin.skypro.lesson8;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private static final List instances = new ArrayList();
    private static int bookCount = 0;
    private final String bookName;
    private final Author author;
    public int id;
    private int publishingYear;

    public Book(String bookName, Author author, int publishingYear){
        this(bookName,author,publishingYear,0);
    }

    public Book(String bookName, Author author, int publishingYear, int id){
        this.bookName = bookName;
        this.author = author;
        this.publishingYear = publishingYear;
        this.id = Book.bookCount + 1;
        instances.add(this);
        bookCount = Book.bookCount + 1;

    }

    public static int getBookCount(){
        return bookCount;
    }

    public static List getInstances() {
        return instances;
    }

    public String getBookName(){
        return bookName;
    }

    public int getPublishingYear(){
        return publishingYear;
    }

    public void setPublishingYear(int year){
        this.publishingYear = year;
    }

    public Author getAuthor(){
        return author;
    }

    public String getAuthorFullName(){
        return author.getFirstName() + " " + author.getLastName();
    }

    public String getBookFullInfo(){
        return author.getFirstName() + " " + author.getLastName() + ": " + bookName + ": " + publishingYear;
    }

}
