package libraryService.Service;

import libraryService.repository.BookRepository;
import libraryService.repository.MemoryBookRepository;
import libraryService.vo.Book;
import libraryService.vo.Member;

import java.util.List;

public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void printBooks(){
        for (Book book : bookRepository.getBooks()){
            System.out.println(book);
        }
    }

    public Book getBook(String title, String author) {
        return bookRepository.findBook(title, author);
    }

    public void printAvailableRentalBooks(){
        for(Book book : bookRepository.getBooks()) {
            if(book.getStock() > 0) {
                System.out.println(book);
            }
        }
    }

    public void registerBook(String title, String author){
        if ( bookRepository.findBook(title, author) == null) {
            Book book = Book.of(title, author);
            bookRepository.addBook(book);
        } else {
            bookRepository.findBook(title, author).plusStock();
        }
    }

    public void printIdToBook(List<String>list) {
        for(String bookId : list) {
            System.out.println(bookRepository.getIdToBook(bookId));
        }
    }

}