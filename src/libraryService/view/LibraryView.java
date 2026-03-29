
package libraryService.view;

import libraryService.controller.BookController;
import libraryService.controller.MemberController;
import libraryService.controller.RentController;
import libraryService.vo.Book;
import libraryService.vo.Member;

import java.util.Scanner;

public class LibraryView {
    private final Scanner scanner = new Scanner(System.in);
    private final MemberController memberController;
    private final BookController bookController;
    private final RentController rentController;

    public LibraryView (MemberController memberController, BookController bookController, RentController rentController) {
        this.memberController = memberController;
        this.bookController = bookController;
        this.rentController = rentController;
    }



    public void menu() {
        Member loginMember = null;
        while (true) {
            System.out.println("도서관 서비스에 오신걸 환영합니다.");
            System.out.println("1 : 로그인 하시겠습니까?");
            System.out.println("2 : 회원가입 하시겠습니까?");
            System.out.print("메뉴를 입력해주세요 >");
            String num = scanner.nextLine();
            switch (num) {
                case "1":
                    loginMember = libraryLogin();
                    break;
                case "2":
                    signUp();
                default:
            }
            if (loginMember != null) {
                break;
            }
        }
        while (true) {
            System.out.println("****공유 도서관 시스템****");
            System.out.println("1: 책 전체 목록");
            System.out.println("2: 대여 가능한 책 전체 목록");
            System.out.println("3: 책 등록하기");
            System.out.println("4: 책 대여하기");
            System.out.println("5: 책 반납하기");
            System.out.println("6: 대여한 책 목록");
            System.out.println("7: 시스템 종료");
            System.out.println("*******************");
            System.out.print("번호 입력 : ");
            String systemNum = scanner.nextLine();

            switch (systemNum) {
                case "1":
                    // books.printBooks(); 책 전체 목록 프린트
                    bookController.printBooks();
                    break;

                case "2":
                    // books.printCanRental(); 책 대여 가능 목록 프린트
                    bookController.printAvailableRentalBooks();
                    break;

                case "3":
                    registerBook();
                    break;

                case "4":
                    //책 대여하기
                    // 2026 - 03 - 28 로직 확인할것.
                    borrowBook(loginMember);
                    break;

                case "5":
                    returnBook(loginMember);
                    break;


                case "6":
                    //대여한 책 목록 보기
                    try {
                        bookController.printIdToBook( rentController.printRentedBooks(loginMember) );
                    }catch (NullPointerException e) {
                        System.out.println("빌린 책이 없습니다.");
                        continue;
                    }
                    break;

                case "7":
                    //시스테 종료
                    System.out.println("시스템을 종료합니다.");
                    scanner.close();
                    return;

                default:
                    System.out.println("번호를 잘못 입력했습니다.");
            }
        }

    }


    private void signUp() {
        System.out.println("회원가입 진행하겠습니다.");
        System.out.println();
        System.out.println("이름 : ");
        String signUpName = scanner.nextLine();
        System.out.println("ID : ");
        String signUpID = scanner.nextLine();
        System.out.println("PASSWORD : ");
        String signIpPW = scanner.nextLine();

        if (memberController.isEqualsID(signUpID)) {
            System.out.println("ID가 중복입니다.");
        } else {
            memberController.signUp(signUpName, signUpID, signIpPW);
            rentController.registerRent(signUpID);
            System.out.println("회원가입이 완료되었습니다.");
        } //아이디 확인 및 아이디 생성
    }

    private Member libraryLogin() {
        System.out.println("로그인 하겠습니다.");
        System.out.println();
        System.out.println("ID :");
        String loginID = scanner.nextLine();
        System.out.println("PASSWORD");
        String loginPW = scanner.nextLine();
        if (memberController.login(loginID, loginPW) == null) {
            System.out.println("아이디 혹은 비밀번호를 확인 해주세요.");
        }
        return memberController.login(loginID, loginPW);
        // 멤버 찾기

    }

    private void registerBook() {
        System.out.println("---------------");
        System.out.println("책 등록 하겠습니다.");
        System.out.print("제목 :");
        String title = scanner.nextLine();
        System.out.print("저자 :");
        String author = scanner.nextLine();
        bookController.registerBook(title, author);

    }

    private void borrowBook(Member loginMember) {
        //책 대여하기
        System.out.println("대여할 책의 이름과 저자를 입력해주세요.");
        System.out.println("책 이름 :");
        String titleRental = scanner.nextLine();
        System.out.println("책 저자 :");
        String authorRental = scanner.nextLine();
        Book br = bookController.getBook(titleRental,authorRental);
        if (br == null) {
            System.out.println("책의 이름과 저자를 확인해주세요.");
            return;
        }
        switch(rentController.borrowBook(loginMember, br )) {
            case 1 :
                System.out.println(titleRental + "을(를) 성공적으로 대여하셨습니다.");
                break;
            case 2 :
                System.out.println("Rent 객체 생성 오류");
                break;
            case 3 :
                System.out.println("책 3권 이하로 빌릴 수 있으며, 똑같은 책은 대여 불가능합니다.");
                break;
            case 4 :
                System.out.println("책 재고가 없어서 빌릴 수 없는 책입니다.");
                break;
            default:
                break;
        }
    }
    private void returnBook(Member loginMember) {
        //책 반납하기
        System.out.println("반납할 책의 이름과 저자를 입력해주세요.");
        System.out.println("책 이름:");
        String returnTitle = scanner.nextLine();
        System.out.println("책 저자:");
        String returnAuthor = scanner.nextLine();
        Book rb = bookController.getBook(returnTitle,returnAuthor);
        if(rb == null) {
            System.out.println("반납할 책과 저자를 확인 해주세요.");
            return;
        }
        int returnNum = rentController.returnBook(loginMember,rb);
        switch(returnNum) {
            case 1 :
                System.out.println(returnTitle+"을(를) 성공적으로 반납하셨습니다.");
                break;
            case 2 :
                System.out.println("반납할 책과 저자를 확인 해주세요");
                break;
            case 3 :
                System.out.println("갖고 있지 않는 책입니다.");
            default:
                break;
        }
        //library.returnBook(member, member.isBook(titleReturn, authorReturn));
    }

}
