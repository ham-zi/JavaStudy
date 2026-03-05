package libraryService;

import java.util.ArrayList;
import java.util.List;

public class Library {

    public List<Book>books = new ArrayList<>();

    public void registerBook(Book book) {
        books.add(book);
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
            if (book.getIsBook()) {
                System.out.println(book.getTitle());
            }
        }
        System.out.println("----------------");
    }



}