package libraryService.repository;

import libraryService.vo.Book;

import java.util.ArrayList;
import java.util.List;

public class MemoryBookRepository implements BookRepository {

    private final List<Book> books = new ArrayList<>();

    @Override
    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public List<Book> getBooks() {
        return books;
    }

    @Override
    public Book findBook(String title, String author) {
        Book result = null;
        for (Book book : books) {
            if (title.equals(book.getTitle()) && author.equals(book.getAuthor())) {
                result = book;
                break;
            }
        }
        return result;
    }

    @Override
    public String getIdToBook(String bookId) {
        for (Book book : books) {
            if (book.getId().equals(bookId)) {
                return "[제목:" + book.getTitle() + ", 저자:" + book.getAuthor() + "]";
            }
        }
        return null;
    }
}


