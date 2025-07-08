package BookServices;

import BookTypes.Book;

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

    public Book removeOutdatedBook(String isbn, int maxAge, int currentYear) {
        return inventoryService.removeOutdatedBook(isbn, maxAge, currentYear);
    }

    public double buyBook(String isbn, int quantity, String email, String address) {
        Book book = inventoryService.getBook(isbn);
        if (book == null) {
            throw new RuntimeException("Book not found in inventory");
        }
        return purchaseService.purchase(book, quantity, email, address);
    }
}
