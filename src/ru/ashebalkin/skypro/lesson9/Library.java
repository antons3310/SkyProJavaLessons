package ru.ashebalkin.skypro.lesson9;

public class Library {
    private final Book[] books;

    public Library(int arrRange){
        this.books = new Book [arrRange];
    }

    public void addBook(Book book){
        for (int i = 0; i < this.books.length; i++) {
            if (this.books[i] == null) {
                this.books[i] = book;
                return;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder();
        for (Book book : this.books) {
            text.append(book.toString()).append("\n");
        }
            return "Library:" + "\n" + text;
    }
}
