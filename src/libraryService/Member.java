package libraryService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Member {

    Library library = new Library();

    private final String name;
    private final int id;
    private final List <String> rentedBooks= new ArrayList<>();
    private static int memberId = 0;

    private Member(String name) {
        if ( name == null || name.isEmpty() ) {
            throw new IllegalArgumentException("Member name");
        }

        this.name = name;
        this.id = ++memberId;


    }

    public static Member register(String name) {
        return new Member(name);

    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public boolean isRentedBook(Book book){
        boolean result = false;
        for (String other : rentedBooks) {
            if(book.getTitle().equals(other)) {
              result = true;
              break;
            }
        }
        return result;
    }

    // main method

    public void printRentedBooks(){
        for (String book : rentedBooks) {
            System.out.println(book);
        }
    }

    public void rentalBook(String title) {
        if( library.isThisBook(title) ) {
            library.findBook(title).changeToIsNotBook();
            rentedBooks.add(library.findBook(title).getTitle());
        } else {
            System.out.println("대여 가능한 책이 아닙니다.");
        }
    }

    public void returnBook(Book book) {
        if(isRentedBook(book)) {
            book.changeToIsBook();
            rentedBooks.remove(book.getTitle());
        } else {
            System.out.println("대여한 책이 아닙니다.");
        }
    }

}
