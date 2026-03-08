package libraryService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {

    Scanner scanner = new Scanner(System.in);
    private final List<Book>books = new ArrayList<>();


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
            if (book.getHasBook()) {
                System.out.printf("제목:%1$s, 저자:%2$s\n",book.getTitle(),book.getAuthor());
            }
        }
        System.out.println("----------------");
    }
    public void rentalBook(Member member) {
        System.out.println("대여할 책의 이름과 저자를 입력해주세요.");
        System.out.println("책 이름 :");
        String title = scanner.nextLine();
        System.out.println("책 저자 :");
        String author = scanner.nextLine();
        for (Book book : books) {
            if (title.equals(book.getTitle()) && author.equals(book.getAuthor())) {
                if (book.getHasBook()) {
                    book.changeToCanNotRental();
                    member.getRentBooks().add(book);
                    System.out.println(book.getTitle() + "을(를) 대여하셨습니다.");
                } else {
                    System.out.println("대여 가능한 책이 아닙니다.");
                }
                return;
            }
        }
        System.out.println("오류 : 대여할 책의 이름과 저자를 확인해주세요.");
    }

    public void returnBook(Member member) {
        System.out.println("반납할 책의 이름과 저자를 입력해주세요.");
        System.out.println("책 이름:");
        String title = scanner.nextLine();
        System.out.println("책 저자:");
        String author = scanner.nextLine();
        for (Book book :member.getRentBooks()) {
            if (title.equals(book.getTitle()) && author.equals(book.getAuthor())) {
                book.changeToCanRental();
                member.getRentBooks().remove(book);
                System.out.println(book.getTitle() + "을(를) 반납하셨습니다.");
            }
        }

    }



}