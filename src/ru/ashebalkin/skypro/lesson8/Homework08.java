package ru.ashebalkin.skypro.lesson8;

public class Homework08 {
    public static void main (String [] arr){
        testMinimunLevel();
        testAverageLevel();
        testHardLevel();
    }

    public static void testMinimunLevel() {
        Author stKing = new Author("Стивен", "Кинг");
        Book it = new Book("Оно",stKing,2001);
        Book shine = new Book("Сияния", stKing, 2007);

        Author gogol = new Author("Николай", "Гоголь");
        Book deadSouls = new Book("Мертвые души",gogol, 1987);
        Book viy = new Book("Вий", gogol, 1876);

        System.out.println("Предыдущее значение: " + shine.getPublishingYear());
        shine.setPublishingYear(1999);
        System.out.println("Новое значение: " + shine.getPublishingYear());
        System.out.println();
/*
        putBookInArr(books, it, 0);
        putBookInArr(books, shine, 1);
        putBookInArr(books, deadSouls, 2);
        putBookInArr(books, viy, 3);
*/
    }

/*
    public static void putBookInArr(Book [] bookArr, Book book, int num){
        bookArr [num] = book;
    }
*/

    public static void testAverageLevel() {
        int numberOfAddBooks = 5;
        Book [] books = createBookArr(numberOfAddBooks);
        fillCurBookArr(books);
        Author [] authors = createAuthorArr();
        fillCurAuthorArr(authors);
        putNewBookToArr(books,authors, "Чиполино", 1984, "Джанни", "Родари");
        //putNewBookToArr(books,authors, "оно", 2001, "СтивеН", "КИНГ");
        printAllBooks(books);
        System.out.println();
    }

    public static Book [] createBookArr(int n) {
        Book [] books = new Book[Book.getBookCount() + n];
        return books;
    }

    public static Author [] createAuthorArr() {
        Author [] authors = new Author[Author.getNumberOfAuthors()];
        return authors;
    }

    public static void fillCurBookArr (Book [] books) {
        for (int i = 0; i < Book.getInstances().size(); i++) {
            books [i] = (Book) Book.getInstances().get(i);
        }
    }

    public static void fillCurAuthorArr (Author [] authors) {
        for (int i = 0; i < Author.getInstances().size(); i++) {
            authors [i] = (Author) Author.getInstances().get(i);
        }
    }

    public static void putNewBookToArr(Book [] books, Author [] authors, String bookName, int publishingYear, String authorFirstName, String authorLastName){
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
        for (int i = 0; i < books.length; i++){
            if (books[i] != null) {
                if ((books[i].getBookName().equalsIgnoreCase(bookName))
                        && (books[i].getPublishingYear() == publishingYear)
                        && (books[i].getAuthor().equals(addAuthor))) {
                    bookExist = true;
                    addBook = books[i];
                    break;
                }
            } else {
                break;
            }
        }

        if (bookExist == false) {
            addBook = new Book(bookName, addAuthor, publishingYear);
            for (int i = 0; i < books.length; i++){
                if (books[i+1] == null){
                    books[i+1] = addBook;
                    break;
                }
            }
        } else {
            System.out.println("Такая книга с переданным автором уже есть в каталоге");
            System.out.println();
        }
    }

    public static void printAllBooks(Book [] books){
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                break;
            } else {
                System.out.println(books[i].getBookFullInfo());
            }
        }
    }

    public static void testHardLevel() {
        Library newLab = new Library(9);
        Author [] authors = newLab.createAuthorArr();
        newLab.fillCurAuthorArr(authors);
        newLab.findBookByName("СиЯниЕ");
        System.out.println();
        newLab.printAllBooks();
        System.out.println();
        newLab.updatePublishingYearByName("Вий",1555);
    }


}
