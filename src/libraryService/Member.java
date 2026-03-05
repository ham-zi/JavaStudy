package libraryService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Member {


    private final String name;
    private final int id;
    private final List<Book> rentBooks = new ArrayList<>();
    private static int memberId = 0;

    private Member(String name) {
        if (name == null || name.isEmpty()) {
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


    // main method

    public void printRentedBooks() {
        for (Book book : rentBooks) {
            System.out.println(book.getTitle());
        }
    }

    public boolean isRentBook(Book book) {
        boolean result = false;
        for (Book other : rentBooks) {
            if (other == book) {
                result = true;
                break;
            }
        }
        return result;
    }

    public void rentalBook(Book book) {
        out:
        if (book.getIsBook()) {
            book.changeToCanNotRental();
            rentBooks.add(book);
            System.out.println(book.getTitle() + "을(를) 대여하였습니다.");
            break out;
        } else {
            System.out.println("대여가 불가능합니다.");
        }
    }

    public void returnBook(Book book) {
        if (isRentBook(book)) {
            book.changeToCanRental();
            rentBooks.remove(book);
            System.out.println(book.getTitle() + "을(를) 반납하였습니다.");
        } else {
            System.out.println("대여한 책이 아닙니다.");
        }
    }

}
