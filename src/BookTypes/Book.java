package BookTypes;

public abstract class Book {
    protected String isbn;
    protected String title;
    protected int year;
    protected double price;
    protected String author;

    public Book(String isbn, String title, int year, double price, String author) {
        this.isbn = isbn;
        this.title = title;
        this.year = year;
        this.price = price;
        this.author = author;
    }

    public String getIsbn() { return isbn; }
    public int getYear() { return year; }
    public double getPrice() { return price; }
    public abstract boolean isPurchasable();
    public String getTitle() { return title; }
}

