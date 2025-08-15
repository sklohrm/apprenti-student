public class Book {

    private String title;
    private String author;
    boolean isAvailable;

    public Book(String title, String author, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.isAvailable = isAvailable;
    }

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        isAvailable = true;
    }

    public void borrowBook() {
        isAvailable = false;
    }
}
