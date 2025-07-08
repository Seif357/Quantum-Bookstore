import java.time.LocalDate;

public abstract class Book {
    private final String ISBN;
    private final String title;
    private final LocalDate publishDate;
    private final Double price;
    public Book(String ISBN, String title, LocalDate publishDate, Double price) {
        this.ISBN = ISBN;
        this.title = title;
        this.publishDate = publishDate;
        this.price = price;
    }
    public String getISBN() {
        return ISBN;
    }
    public String getTitle() {
        return title;
    }
    public LocalDate getPublishDate() {
        return publishDate;
    }
    public Double getPrice() {
        return price;
    }
}
