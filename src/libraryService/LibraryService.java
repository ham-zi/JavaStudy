package libraryService;

public class LibraryService {

    public void rentalBook(Member member, Book book ) {
        if (book != null) {
            if (member.getRentBooksCount() < 3) {
                if (book.isAvailable()) {
                    book.makeUnavailable();
                    book.setLendDay();
                    member.addRentBooks(book);
                    member.checkBooksCount();
                    System.out.println(book.getTitle() + "을(를) 대여하셨습니다.");
                } else {
                    System.out.println("대여 가능한 책이 아닙니다.");
                }
            } else {
                System.out.println("최대 대여 개수를 초과하셨습니다.");
            }
        } else {
            System.out.println("책 이름이나 저자를 잘못 입력하셨습니다.");
        }
    }

    public void returnBook(Member member,Book book) {
        if(book != null) {
            book.makeAvailable();
            book.resetLendDay();
            member.removeRentBooks(book);
            member.checkBooksCount();
            System.out.println(book.getTitle() + "을(를) 반납하셨습니다.");
        }else {
            System.out.println("책 이름이나 저자를 잘못 입력하셨습니다.");
        }
    }
}