package libraryService;

import java.util.ArrayList;
import java.util.List;

public class Book {

    private final String title;
    private final String author;
    private final int id;
    private static int bookId = 0;
    private boolean isAvailable;

    private Book(String title, String author) {

        if ( title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Book title");
        }
        if ( author == null || author.isEmpty()) {
            throw new IllegalArgumentException("Book author");
        }

        this.title = title;
        this.author = author;
        this.id = ++bookId;
        this.isAvailable = true;

    }


    public static Book of(String title, String author) {
        return new Book(title, author);
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getId() {
        return id;
    }

    public Boolean getIsAvailable() { return isAvailable; }


    public void changeToCanNotRental() { isAvailable = false; }
    public void changeToCanRental() { isAvailable = true; }


}
