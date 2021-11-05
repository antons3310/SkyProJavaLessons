package ru.ashebalkin.skypro.lesson9;

import java.util.Objects;

public class Book {
    private final String bookName;
    private final Author author;
    private final int publishingYear;

    public Book(String bookName, Author author, int publishingYear){
        this.bookName = bookName;
        this.author = author;
        this.publishingYear = publishingYear;
    }

    @Override
    public String toString() {
        return "Book: " + bookName + " by " + author.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return publishingYear == book.publishingYear && bookName.equals(book.bookName) && author.equals(book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookName, author, publishingYear);
    }
}
