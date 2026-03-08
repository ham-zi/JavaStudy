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

    public List<Book>getRentBooks() {
        return rentBooks;
    }

    public void printRentedBooks() {
        System.out.println("현재 대여중인 책:");
        for (Book book : rentBooks) {
            System.out.printf("제목:%1$s, 저자:%2$s\n",book.getTitle(),book.getAuthor());
        }
        System.out.println("--------------------");
    }
}
