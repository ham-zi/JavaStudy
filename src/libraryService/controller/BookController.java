package libraryService.controller;

import libraryService.Service.BookService;
import libraryService.vo.Book;

import java.util.List;

public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

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

    public void printIdToBook(List<String>list) {
        bookService.printIdToBook(list);
    }

}
