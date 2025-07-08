package com.app.quantumbookstore.services;
import com.app.quantumbookstore.abstractions.Book;

import java.time.Year;
import java.util.*;

public class InventoryService {
    private Map<String, Book> inventory = new HashMap<>();

    public void addBook(Book book) {
        System.out.println("Adding book " + book.getTitle() + " " +book.getIsbn());
        inventory.put(book.getIsbn(), book);
    }

    public Book removeOutdatedBook(String isbn, int maxAge) {
        int currentYear = Year.now().getValue();
        Book book = inventory.get(isbn);
        if (book != null && (currentYear - book.getPublishYear()) > maxAge) {
            inventory.remove(isbn);
            System.out.println("Removed outdated book " + isbn);
            return book;
        }
        return null;
    }

    public Book getBook(String isbn) {
        return inventory.get(isbn);
    }
}
