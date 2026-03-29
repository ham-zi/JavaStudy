package libraryService.repository;

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
        for (Rent r : rentBooksOfMembers) {
            if (r.getMemberID().equals(id)) {
                return r;
            }
        }
        return null;
    }


}