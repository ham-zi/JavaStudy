package libraryService.controller;

import libraryService.Service.RentService;
import libraryService.vo.Book;
import libraryService.vo.Member;

import java.util.List;


public class RentController {
    private final RentService rentService;

    public RentController (RentService rentService) {
        this.rentService = rentService;
    }


    public int borrowBook(Member member, Book book) {
        return rentService.borrowBook(member, book);
    }

    public void registerRent(String id) {
        rentService.registerRent(id);
    }

    public List<String> printRentedBooks(Member member) {
        return rentService.getRentedBooks(member);
    }

    public int returnBook(Member member, Book book) {
        return rentService.returnBook(member, book);
    }

}
