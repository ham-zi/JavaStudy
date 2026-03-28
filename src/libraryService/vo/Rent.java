package libraryService.vo;

import java.util.ArrayList;
import java.util.List;

public class Rent {
    private final String memberID;
    List<String> rentBooks = new ArrayList<>();

    private Rent(String memberID) {
        this.memberID = memberID;
    }

    public static Rent of(String memberID) {
        return new Rent(memberID);
    }

    public String getMemberID() {
        return memberID;
    }

    public List<String> getRentBooks() {
        return rentBooks;
    }

    public int getStockRentBooks() {
        return rentBooks.size();
    }


    public boolean hasThisBook(Book book) {
        for(String other : rentBooks) {
            if( book.getId().equals(other) ) {
                return true;
            }
        }
        return false;
    }

    public void addRentBooks(Book book) {
        rentBooks.add(book.getId());
    }

    public void removeRentBooks(Book book) {
        rentBooks.remove(book.getId());
    }

}
