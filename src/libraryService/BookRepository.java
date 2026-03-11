package libraryService;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {

    private final List<Book> books = new ArrayList<>();

    public void registerBook(String title, String author) {
        books.add(Book.of(title, author));
    }

    public void printBooks() {
        System.out.println("책 전체 목록");
        for (Book book : books) {
            System.out.println(book.getTitle());
        }
        System.out.println("----------------");
    }

    public void printCanRental() {
        System.out.println("대여 가능한 책 목록:");
        for (Book book : books) {
            if (book.isAvailable()) {
                System.out.printf("제목:%1$s, 저자:%2$s\n",book.getTitle(),book.getAuthor());
            }
        }
        System.out.println("----------------");
    }
    public Book isBook(String title, String author) {
        Book result = null;
        for (Book book : books) {
            if (title.equals(book.getTitle()) && author.equals(book.getAuthor())) {
                result = book;
                break;
            }
        }
        return result;
    }
}
