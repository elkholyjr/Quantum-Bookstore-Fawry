import BookServices.QuantumBookstoreSystem;
import BookTypes.*;

public class BookstoreTest {
    public static void main(String[] args) {
        QuantumBookstoreSystem bookstore = new QuantumBookstoreSystem();

        Book paperBook = BookFactory.createBook(BookType.PAPER, "ISBN001", "Java Basics", 2020, 30.0, "Alice", 10);
        Book ebook = BookFactory.createBook(BookType.EBOOK, "ISBN002", "AI for Everyone", 2022, 15.0, "Bob", "PDF");
        Book demoBook = BookFactory.createBook(BookType.DEMO, "ISBN003", "Free Preview", 2021, 0.0, "Carol");

        bookstore.addBook(paperBook);
        bookstore.addBook(ebook);
        bookstore.addBook(demoBook);

        Book removed = bookstore.removeOutdatedBook("ISBN003", 2, 2025);
        if (removed != null) {
            System.out.println("Successfully removed outdated book.");
        } else {
            System.out.println("Book is not outdated yet.");
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
