package libraryService.repository;

import libraryService.vo.Book;

import java.util.ArrayList;
import java.util.List;

public class MemoryBookRepository implements BookRepository {

    private final List<Book> books = new ArrayList<>();

    @Override
    public void addBook(Book book){
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


    /*


    public void removeRentBooks(Book book) {
        Iterator<Book> it = rentBooks.iterator();
        while (it.hasNext()) {
            Book current = it.next();
            if (current.equals(book)) {
                it.remove();
                return;
            }
        }
    }*/

}
