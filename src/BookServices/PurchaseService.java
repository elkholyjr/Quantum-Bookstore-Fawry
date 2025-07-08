package BookServices;
import BookTypes.Book;
import BookTypes.EBook;
import BookTypes.PaperBook;

public class PurchaseService {
    private final ShippingService shippingService;
    private final MailService mailService;

    public PurchaseService(ShippingService shippingService, MailService mailService) {
        this.shippingService = shippingService;
        this.mailService = mailService;
    }

    public double purchase(Book book, int quantity, String email, String address) {
        if (!book.isPurchasable()) {
            throw new RuntimeException("Book not available for sale");
        }

        double total = book.getPrice() * quantity;

        if (book instanceof PaperBook pb) {
            pb.reduceStock(quantity);
            shippingService.ship(pb, address);
        } else if (book instanceof EBook eb) {
            mailService.email(eb, email);
        }

        System.out.println("Purchased " + book.getIsbn()+ " "+ book.getTitle() + " for $" + total);
        return total;
    }
}

