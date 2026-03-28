package libraryService.Service;

import libraryService.repository.MemoryRentRepository;
import libraryService.repository.RentRepository;
import libraryService.vo.Book;
import libraryService.vo.Member;
import libraryService.vo.Rent;

public class RentService {
    private final RentRepository rentRepository = new MemoryRentRepository();

    public int borrowBook(Member member, Book book) {
        Rent rent = rentRepository.findRentBooks(member.getId());

        if (rent == null) {
            return 2;
        }
        if (rent.getStockRentBooks() > 3 && !rent.hasThisBook(book)) { // 3개 미만이냐, 똑같은책없냐
            rent.addRentBooks(book);
            book.minusStock();
            return 1;
        } else {
            return 3;
        }
    }

    public int returnBook(Member member, Book book) {
        Rent rent = rentRepository.findRentBooks(member.getId());
        if (rent == null) {
            return 2;
        }
        if (rent.hasThisBook(book)) {
            rent.removeRentBooks(book);
            book.plusStock();
            return 1;
        } else {return 3; }



    }

    public void registerRent(String id) {
        Rent.of(id);
    }

    public void printRentedBooks(Member member) {
        Rent rent = rentRepository.findRentBooks(member.getId());
        for (String s : rent.getRentBooks()) {
            System.out.println(s);
        }
    }


}
