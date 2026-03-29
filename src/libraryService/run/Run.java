package libraryService.run;

import libraryService.Service.BookService;
import libraryService.Service.MemberService;
import libraryService.Service.RentService;
import libraryService.controller.BookController;
import libraryService.controller.MemberController;
import libraryService.controller.RentController;
import libraryService.repository.*;
import libraryService.view.LibraryView;

public class Run {

    public static void main(String[] args) {

        BookRepository bookRepository = new MemoryBookRepository();
        MemberRepository memberRepository = new MemoryMemberRepository();
        RentRepository rentRepository = new MemoryRentRepository();

        BookService bookService = new BookService(bookRepository);
        MemberService memberService = new MemberService(memberRepository);
        RentService rentService = new RentService(rentRepository);

        BookController bookController = new BookController(bookService);
        MemberController memberController = new MemberController(memberService);
        RentController rentController = new RentController(rentService);



        new LibraryView(memberController, bookController, rentController).menu();
    }

}
