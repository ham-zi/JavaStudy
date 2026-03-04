package libraryService;

public class Book {



    private final String title;
    private final String author;
    private final int id;
    private static int bookId = 0;
    private boolean isBook;

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
        this.isBook = true;

    }


    public static Book register(String title, String author) {
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

    public Boolean getIsBook() { return isBook; }

    public void changeToIsNotBook() { isBook = false; }
    public void changeToIsBook() { isBook = true; }


}
