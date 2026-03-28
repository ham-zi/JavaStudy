package libraryService.controller;

import libraryService.Service.BookService;
import libraryService.vo.Book;

public class BookController {
    BookService bookService = new BookService();


    // BookRepository
    public void printBooks() {
        bookService.printBooks();
    }

    public void printAvailableRentalBooks() {
        bookService.printAvailableRentalBooks();
    }

    public void registerBook(String title, String author) {
        bookService.registerBook(title, author);
    }

    public Book getBook(String title, String author) {
        return bookService.getBook(title,author);
    }

}
