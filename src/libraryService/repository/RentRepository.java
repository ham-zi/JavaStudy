package libraryService.repository;

import libraryService.vo.Rent;

public interface RentRepository {

    public void registerRentBooks(Rent rent);

    public Rent findRentBooks(String id);

}
