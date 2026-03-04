package libraryService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {

    public final List <Book> books = new ArrayList<>();



    public boolean isBookInList(Book book) {
        boolean result = false;
        for (Book other : books) {
            if ( book == other ) {
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean isThisBook(String title) {
        boolean result = false;
        for ( Book book : books ) {
            if ( book.getTitle().equals(title)) {
                result = true;
                break;
            }
        }
        return  result;
    }

    // main method

    public Book findBook(String title) {
        Book result = null;
        for (Book book : books) {
            if ( book.getTitle().equals(title) ) {
                result = book;
                break;
            }else {
                System.out.println("잘못입력했습니다.");
            }
        }
        System.out.println(result);
        return result;
    }


    public void registerBooks(Book book) {
        books.add(book);
    }

    public void printBooks() {
        for (Book book : books) {
            System.out.println(book.getTitle());
        }
    }

    public void printCanRental() {
        for (Book book : books) {
            if(book.getIsBook()) {
                System.out.println(book.getTitle());
            }
        }
    }

}