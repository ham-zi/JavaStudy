package libraryService.Service;

import libraryService.repository.RentRepository;
import libraryService.vo.Book;
import libraryService.vo.Member;
import libraryService.vo.Rent;

import java.util.List;

public class RentService {
    private final RentRepository rentRepository;

    public RentService(RentRepository rentRepository) {
        this.rentRepository = rentRepository;
    }

    public int borrowBook(Member member, Book book) {
        Rent rent = rentRepository.findRentBooks(member.getId());
        if(book.getStock() == 0) {
            return 4;
        }
        if (rent == null) {
            return 2;
        }
        if (rent.rentBookRole(book)) {
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
        } else {return 3;
        }



    }

    public void registerRent(String id) {
        Rent rent = Rent.of(id);
        rentRepository.registerRentBooks(rent);
    }

    public List<String> getRentedBooks(Member member) {
        Rent rent = rentRepository.findRentBooks(member.getId());
        return rent.getRentBooks();

        }
    }


