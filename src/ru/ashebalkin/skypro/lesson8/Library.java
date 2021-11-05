package ru.ashebalkin.skypro.lesson8;

public class Library {
    //private int arrRange;
    private final Book [] books;

    public Library(int arrRange){
        this.books = new Book [arrRange];
        fillCurBookArr(this.books);
    }

    public Author [] createAuthorArr() {
        Author [] authors = new Author[Author.getNumberOfAuthors()];
        return authors;
    }

    public void fillCurBookArr (Book [] books) {
        for (int i = 0; i < Book.getInstances().size(); i++) {
            books [i] = (Book) Book.getInstances().get(i);
        }
    }

    public void fillCurAuthorArr (Author [] authors) {
        for (int i = 0; i < Author.getInstances().size(); i++) {
            authors [i] = (Author) Author.getInstances().get(i);
        }
    }

    public void putNewBookToArr(Author [] authors, String bookName, int publishingYear, String authorFirstName, String authorLastName){
        boolean authorExist = false;
        Author addAuthor = null;
        for (int i = 0; i < authors.length; i++) {
            if ((authors[i].getLastName().equalsIgnoreCase(authorLastName))
                    && (authors[i].getFirstName().equalsIgnoreCase(authorFirstName))) {
                authorExist = true;
                addAuthor = authors[i];
                break;
            }
        }

        if (authorExist == false){
            addAuthor = new Author(authorFirstName, authorLastName);
        }

        boolean bookExist = false;
        Book addBook = null;
        for (int i = 0; i < this.books.length; i++){
            if (books[i] != null) {
                if ((this.books[i].getBookName().equalsIgnoreCase(bookName))
                        && (this.books[i].getPublishingYear() == publishingYear)
                        && (this.books[i].getAuthor().equals(addAuthor))) {
                    bookExist = true;
                    addBook = this.books[i];
                    break;
                }
            } else {
                break;
            }
        }

        if (bookExist == false) {
            addBook = new Book(bookName, addAuthor, publishingYear);
            for (int i = 0; i < this.books.length; i++){
                if (this.books[i+1] == null){
                    this.books[i+1] = addBook;
                    break;
                }
            }
        } else {
            System.out.println("Такая книга с переданным автором уже есть в каталоге");
            System.out.println();
        }
    }

    public void printAllBooks(){
        for (int i = 0; i < this.books.length; i++) {
            if (books[i] == null) {
                break;
            } else {
                System.out.println(this.books[i].getBookFullInfo());
            }
        }
    }

    public void findBookByName(String bookName){
        for (int i = 0; i < this.books.length; i++){
            if (this.books[i] != null) {
                if (this.books[i].getBookName().equalsIgnoreCase(bookName)){
                    System.out.println("Книга " + this.books[i].getBookName() + " написана " + this.books[i].getAuthorFullName() + " и была опубликована  в " + this.books[i].getPublishingYear());
                    break;
                }
            } else {
                break;
            }
        }
        System.out.println("Книги с таким названием не найдено");
    }

    public void updatePublishingYearByName(String bookName, int newPublishingYear){
        for (int i = 0; i < this.books.length; i++){
            if (this.books[i] != null) {
                if (this.books[i].getBookName().equalsIgnoreCase(bookName)){
                    System.out.println("Старое значение года: " +  this.books[i].getPublishingYear());
                    this.books[i].setPublishingYear(newPublishingYear);
                    System.out.println("Новое значение года: " + this.books[i].getPublishingYear());
                    break;
                }
            } else {
                System.out.println("Книги с таким названием не найдено");
                break;

            }
        }

    }

}
