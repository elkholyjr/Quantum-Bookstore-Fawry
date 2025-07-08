package BookServices;
import BookTypes.PaperBook;
public class ShippingService {
    public void ship(PaperBook book, String address) {
        System.out.println("Shipping paper book to " + address);
    }
}

