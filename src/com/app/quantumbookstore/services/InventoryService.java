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

    public List<Book> removeOutdatedBooks(int maxAge) {
        int currentYear = Year.now().getValue();
        List<String> toRemove = new ArrayList<>();
        List<Book> removedBooks = new ArrayList<>();

        for (Map.Entry<String, Book> entry : inventory.entrySet()) {
            Book book = entry.getValue();
            if ((currentYear - book.getPublishYear()) > maxAge) {
                toRemove.add(entry.getKey());
                removedBooks.add(book);
            }
        }

        for (String isbn : toRemove) {
            inventory.remove(isbn);
            System.out.println("Removed outdated book " + isbn);
        }

        return removedBooks;
    }

    public Book getBook(String isbn) {
        return inventory.get(isbn);
    }
}
