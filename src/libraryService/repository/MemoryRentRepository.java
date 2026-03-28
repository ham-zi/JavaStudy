package libraryService.repository;

import libraryService.vo.Book;
import libraryService.vo.Rent;

import java.util.ArrayList;
import java.util.List;

public class MemoryRentRepository implements RentRepository {
    private final List<Rent> rentBooksOfMembers = new ArrayList<>();


    @Override
    public void registerRentBooks(Rent rent) {
        rentBooksOfMembers.add(rent);
    }

    @Override
    public Rent findRentBooks(String id) {
        Rent rent = null;
        for(Rent r : rentBooksOfMembers) {
            if(r.getMemberID().equals(id)) {
                rent = r;
            }
        }
        return rent;
    }


}