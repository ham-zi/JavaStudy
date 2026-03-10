package libraryService;

import java.util.*;

public class Member {


    private final String name;
    private final String id;
    private final String passWord;
    private final List<Book> rentBooks = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);


    private Member(String name, String id, String passWord) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Member name");
        }

        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("Member ID");
        }

        if (passWord == null || passWord.isEmpty()) {
            throw new IllegalArgumentException("Member PASSWORD");
        }


        this.name = name;
        this.id = id;
        this.passWord = passWord;

    }

    public static Member of(String name, String id, String passWord) {
        return new Member(name, id , passWord);

    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getPassWord() { return passWord;}

    public List<Book> getRentBooks() {
        return rentBooks;
    }

    public void printRentedBooks() {
        System.out.println("현재 대여중인 책:");
        for (Book book : rentBooks) {
            System.out.printf("제목:%1$s, 저자:%2$s\n", book.getTitle(), book.getAuthor());
        }
        System.out.println("--------------------");
    }

    public void addRentBooks(Book book) {
        rentBooks.add(book);
    }

    public void removeRentBooks(String title, String author) {
        rentBooks.removeIf(book -> title.equals(book.getTitle()) && author.equals(book.getAuthor()));
    }
}

