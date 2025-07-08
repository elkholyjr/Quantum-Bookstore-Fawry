package com.app.quantumbookstore.services;
import com.app.quantumbookstore.classes.EBook;
public class MailService {
    public void email(EBook book, String email) {
        System.out.println("Emailing eBook to " + email);
    }
}

