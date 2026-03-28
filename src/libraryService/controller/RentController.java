package libraryService.controller;

import libraryService.Service.RentService;
import libraryService.vo.Book;
import libraryService.vo.Member;

public class RentController {
    private final RentService rentService = new RentService();


    public int borrowBook(Member member, Book book) {
        return rentService.borrowBook(member, book);
    }

    public void registerRent(String id) {
        rentService.registerRent(id);
    }

    public void printRentedBooks(Member member) {
        rentService.printRentedBooks(member);
    }

    public int returnBook(Member member, Book book) {
        return rentService.returnBook(member, book);
    }

}
