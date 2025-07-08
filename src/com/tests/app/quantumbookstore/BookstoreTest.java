package com.tests.app.quantumbookstore;

import com.app.quantumbookstore.QuantumBookstoreSystem;
import com.app.quantumbookstore.abstractions.*;
import com.app.quantumbookstore.factories.*;
import com.app.quantumbookstore.enums.*;

import java.util.List;

public class BookstoreTest {
    public static void main(String[] args) {
        QuantumBookstoreSystem bookstore = new QuantumBookstoreSystem();

        Book paperBook = BookFactory.createBook(BookType.PAPER, "ISBN001", "Java Basics", 2021, 30.0, "Alice", 10);
        Book ebook = BookFactory.createBook(BookType.EBOOK, "ISBN002", "AI for Everyone", 2022, 15.0, "Bob", "PDF");
        Book demoBook = BookFactory.createBook(BookType.DEMO, "ISBN003", "Free Preview", 2020, 0.0, "Carol");

        bookstore.addBook(paperBook);
        bookstore.addBook(ebook);
        bookstore.addBook(demoBook);

        List<Book> removedBooks = bookstore.removeOutdatedBooks(4);
        if (!removedBooks.isEmpty()) {
            System.out.println("Removed outdated books:");
            for (Book b : removedBooks) {
                System.out.println("- " + b.getTitle() + " (" + b.getIsbn() + ")");
            }
        } else {
            System.out.println("No books were outdated.");
        }

        try {
            double paid = bookstore.buyBook("ISBN001", 5, "user@example.com", "123 Main St");
            System.out.println("Payment completed: $" + paid);
        } catch (Exception e) {
            System.out.println("ERROR - " + e.getMessage());
        }

        try {
            double paid = bookstore.buyBook("ISBN002", 1, "user@example.com", null);
            System.out.println("Payment completed: $" + paid);
        } catch (Exception e) {
            System.out.println("ERROR - " + e.getMessage());
        }

        try {
            bookstore.buyBook("ISBN003", 1, "user@example.com", "456 Side St");
        } catch (Exception e) {
            System.out.println("Expected Error - " + e.getMessage());
        }

        try {
            bookstore.buyBook("ISBN001", 100, "user@example.com", "789 High St");
        } catch (Exception e) {
            System.out.println("Expected Error - " + e.getMessage());
        }
    }
}