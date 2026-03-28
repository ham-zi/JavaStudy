package libraryService.repository;

import libraryService.vo.Book;

import java.util.List;

public interface BookRepository {
    public List<Book>getBooks();
    public Book findBook(String title, String author);
    public void addBook(Book book);

}
