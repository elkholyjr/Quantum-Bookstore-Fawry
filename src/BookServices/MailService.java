package BookServices;
import BookTypes.EBook;
public class MailService {
    public void email(EBook book, String email) {
        System.out.println("Emailing eBook to " + email);
    }
}

