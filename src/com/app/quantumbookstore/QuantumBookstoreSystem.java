package com.app.quantumbookstore;

import com.app.quantumbookstore.abstractions.Book;
import com.app.quantumbookstore.services.*;

import java.util.List;

public class QuantumBookstoreSystem {
    private final InventoryService inventoryService;
    private final PurchaseService purchaseService;

    public QuantumBookstoreSystem() {
        this.inventoryService = new InventoryService();
        this.purchaseService = new PurchaseService(new ShippingService(), new MailService());
    }

    public void addBook(Book book) {
        inventoryService.addBook(book);
    }

    public List<Book> removeOutdatedBooks(int maxAge) {
        return inventoryService.removeOutdatedBooks(maxAge);
    }


    public double buyBook(String isbn, int quantity, String email, String address) {
        Book book = inventoryService.getBook(isbn);
        if (book == null) {
            throw new RuntimeException("Book not found in inventory");
        }
        return purchaseService.purchase(book, quantity, email, address);
    }
}
