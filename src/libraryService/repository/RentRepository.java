package libraryService.repository;

import libraryService.vo.Book;
import libraryService.vo.Rent;

import java.util.List;

public interface RentRepository {

    public void registerRentBooks(Rent rent);

    public Rent findRentBooks(String id);

}
