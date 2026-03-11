package libraryService;

import java.util.*;

public class Member {


    private final String name;
    private final String id;
    private final String passWord;
    private final List<Book> rentBooks = new ArrayList<>();
    private int rentBooksCount;


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
        this.rentBooksCount = 0;

    }

    public static Member of(String name, String id, String passWord) {
        return new Member(name, id , passWord);

    }

    public int getRentBooksCount() { return  rentBooksCount;}

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

    // booksCount method

    public void checkBooksCount() { rentBooksCount = rentBooks.size(); }

    // rentedBooks method

    public void printRentedBooks() {
        System.out.println("현재 대여중인 책:");
        for (Book book : rentBooks) {
            System.out.printf("제목:%1$s, 저자:%2$s\n", book.getTitle(), book.getAuthor());
        }
        System.out.println("현재 대여중인 책의 개수는 " + getRentBooksCount() + "권 입니다.");
        System.out.println( 3 - getRentBooksCount() + "권 빌릴 수 있습니다.");
        System.out.println("--------------------");
    }



    public void addRentBooks(Book book) {
        rentBooks.add(book);
    }

    public Book isBook(String title, String author) {
        Book result = null;
        for(Book book : rentBooks) {
            if(book.getTitle().equals(title) && book.getAuthor().equals(author)) {
                result = book;
                break;
            }
        }
        return result;
    }

    public void removeRentBooks(Book book) {
        Iterator<Book> it = rentBooks.iterator();
            while (it.hasNext()) {
                Book current = it.next();
                if (current.equals(book)) {
                    it.remove();
                    return;
                }
            }
    }
}

