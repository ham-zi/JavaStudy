
package libraryService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        LibraryService library = new LibraryService();
        BookRepository books = new BookRepository();
        MemberRepository members = new MemberRepository();
        Scanner scanner = new Scanner(System.in);
        members.registerMember("1234", "1234", "1234");
        books.registerBook("쓰기가문해력이다", "EBS");
        books.registerBook("공책", "EBS");
        books.registerBook("개미", "베르베르나르나르");
        books.registerBook("수학의정석", "정석");

        while (true) {
            System.out.println("계정이 있으신가요? (숫자 입력) \n 1 : 계정있습니다. \n 2 : 계정없습니다.");
            String login = scanner.nextLine();
            switch (login) {
                case "1":
                    break;
                case "2":
                    while (true) {
                        System.out.println("회원가입 진행하겠습니다.");
                        System.out.println();
                        System.out.println("이름 : ");
                        String name = scanner.nextLine();
                        System.out.println("ID : ");
                        String id = scanner.nextLine();
                        System.out.println("PASSWORD : ");
                        String passWord = scanner.nextLine();
                        if (members.isID(id)) {
                            System.out.println("ID가 중복입니다.");
                        } else {
                            members.registerMember(name, id, passWord);
                            System.out.println("회원가입이 완료되었습니다.");
                            break;
                        }
                    }
                    break;
                default:
                    System.out.println("다시 입력해주세요.");
                    continue;
            }
            break;
        }

        outer:
        while (true) {
            System.out.println("1 : 로그인");
            System.out.println("2 : 종료");
            String num = scanner.nextLine();
            switch (num) {
                case "1":
                    System.out.println("로그인 하겠습니다.");
                    System.out.println();
                    System.out.println("ID :");
                    String id = scanner.nextLine();
                    System.out.println("PASSWORD");
                    String pass = scanner.nextLine();
                    if (members.getMember(id, pass) != null) {
                        Member member = members.getMember(id, pass);
                        while (true) {
                            System.out.println("****도서관 시스템****");
                            System.out.println("1: 책 전체 목록");
                            System.out.println("2: 대여 가능한 책 전체 목록");
                            System.out.println("3: 책 대여하기");
                            System.out.println("4: 책 반납하기");
                            System.out.println("5: 대여한 책 목록");
                            System.out.println("6: 시스템 종료");
                            System.out.println("*******************");
                            String systemNum = scanner.nextLine();
                            switch (systemNum) {
                                case "1":
                                    books.printBooks();
                                    break;

                                case "2":
                                    books.printCanRental();
                                    break;

                                case "3":
                                    System.out.println("대여할 책의 이름과 저자를 입력해주세요.");
                                    System.out.println("책 이름 :");
                                    String titleRental = scanner.nextLine();
                                    System.out.println("책 저자 :");
                                    String authorRental = scanner.nextLine();
                                    library.rentalBook(member, books.isBook(titleRental, authorRental));
                                    break;

                                case "4":
                                    System.out.println("반납할 책의 이름과 저자를 입력해주세요.");
                                    System.out.println("책 이름:");
                                    String titleReturn = scanner.nextLine();
                                    System.out.println("책 저자:");
                                    String authorReturn = scanner.nextLine();
                                    library.returnBook(member, member.isBook(titleReturn, authorReturn));
                                    break;


                                case "5":
                                    member.printRentedBooks();
                                    break;

                                case "6":
                                    System.out.println("시스템을 종료합니다.");
                                    break outer;

                                default:
                                    System.out.println("잘못 입력했습니다.");
                            }
                        }
                    } else {
                        System.out.println("아이디 혹은 비밀번호가 틀렸습니다.");
                    }
                    break;
                case "2":
                    break outer;
                default:
                    System.out.println("잘못 입력하였습니다.");
            }
        }
    }
}
