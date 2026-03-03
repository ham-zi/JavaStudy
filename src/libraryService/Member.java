package libraryService;

import java.util.ArrayList;
import java.util.List;

public class Member {

    private final String name;
    private final int id;
    private List <String> rentedBooks= new ArrayList<>();
    private static int memberId = 0;

    private Member(String name) {
        if ( name == null || name.isEmpty() ) {
            throw new IllegalArgumentException("Member name");
        }

        this.name = name;
        this.id = ++memberId;
    }

    public static Member of(String name) {
        return new Member(name);
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void printRentedBooks(List<String>list){
        for (String book : list) {
            System.out.println(book);
        }
    }

}
