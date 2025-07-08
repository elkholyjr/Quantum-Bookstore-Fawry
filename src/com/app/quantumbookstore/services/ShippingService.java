package com.app.quantumbookstore.services;
import com.app.quantumbookstore.classes.PaperBook;
public class ShippingService {
    public void ship(PaperBook book, String address) {
        System.out.println("Shipping paper book to " + address);
    }
}

