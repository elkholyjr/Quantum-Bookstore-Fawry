package com.app.quantumbookstore.classes;
import com.app.quantumbookstore.abstractions.Book;

public class PaperBook extends Book {
    private int stock;

    public PaperBook(String isbn, String title, int year, double price, String author, int stock) {
        super(isbn, title, year, price, author);
        this.stock = stock;
    }

    public void reduceStock(int qty) {
        if (qty > this.stock) {
            throw new RuntimeException("Not enough stock for ISBN: " + isbn);
        }
        this.stock -= qty;
    }

    @Override
    public boolean isPurchasable() {return true;}
}
