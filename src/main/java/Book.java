public class Book {
    @Pseudonym("Author")
    private String author;
    private String title;
    @Ignore
    private int pages;

    public Book(String author, String title, int pages) {
        this.author = author;
        this.title = title;
        this.pages = pages;
    }
}