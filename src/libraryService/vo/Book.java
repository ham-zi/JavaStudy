package libraryService.vo;

import java.time.LocalDate;

public class Book {

    private final String title;
    private final String author;
    private final String id;
    private static int bookId = 0;
    private int stock;

    private Book(String title, String author) {

        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Book title");
        }
        if (author == null || author.isEmpty()) {
            throw new IllegalArgumentException("Book author");
        }

        this.title = title;
        this.author = author;
        this.id = Integer.toString(++bookId);
        this.stock = 1;
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

    public String getId() {
        return id;
    }

    public int getStock() {
        return stock;
    }

    public void plusStock() {
        stock++;
    }

    public void minusStock() {
        stock--;
    }

    @Override
    public String toString(){
        return "[제목:"+getTitle()+", 작가:"+getAuthor()+", 재고:"+ getStock() + "]";
    }

}
