package libraryService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {

    Scanner scanner = new Scanner(System.in);
    private final List<Book>books = new ArrayList<>();
    private final List<Member>members = new ArrayList<>();


    public void registerBook(String title, String author) {
        books.add(Book.of(title, author));
    }

    public void registerMember(String name, String id, String passWord) {
        members.add(Member.of(name,id,passWord));
    }

    public Member getMember(String id, String pass) {
        Member member=null;
        for(Member m:members) {
            if( m.getId().equals(id) && m.getPassWord().equals(pass) ) {
                member = m;
            }
        }
        return member;
    }

    public boolean isMember(String id, String pass) {
        for (Member m : members) {
            if ( m.getId().equals(id) && m.getPassWord().equals(pass) ) {
                return true;
            }
        }
        return false;
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
            if (book.getIsAvailable()) {
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
                if (book.getIsAvailable()) {
                    book.changeToCanNotRental();
                    member.addRentBooks(book);
                    System.out.println(book.getTitle() + "을(를) 대여하셨습니다.");
                } else {
                    System.out.println("대여 가능한 책이 아닙니다.");
                }
                return;
            }
        }
        System.out.println("대여할 책의 이름과 저자를 확인해주세요.");
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
                member.removeRentBooks(title, author);
                System.out.println(book.getTitle() + "을(를) 반납하셨습니다.");
                return;
            }
        }

    }



}