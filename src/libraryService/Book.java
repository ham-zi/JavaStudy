package libraryService;

public class Book {

    private final String title;
    private final String author;
    private int count=0;
    private final int id;
    private static int bookId = 0;

    private Book(String title, String author) {

        if ( title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Book title");
        }
        if ( author == null || author.isEmpty()) {
            throw new IllegalArgumentException("Book author");
        }

        this.title = title;
        this.author = author;
        this.count ++;
        this.id = ++bookId;

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

    public int getCount() {
        return count;
    }

    public void isRented() {
        if (count == 0) {
            System.out.printf("\"%s\"는 재고가 없습니다.\n",title);
        }else {
            System.out.printf("\"%s\"는 %d권 존재합니다.\n",title,count);
        }
    }


}
