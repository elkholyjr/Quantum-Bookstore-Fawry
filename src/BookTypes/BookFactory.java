package BookTypes;

public class BookFactory {
    public static Book createBook(BookType type, String isbn, String title, int year, double price,
                                  String author, Object... extras) {
        switch (type) {
            case PAPER:
                int stock = (int) extras[0];
                return new PaperBook(isbn, title, year, price, author, stock);
            case EBOOK:
                String fileType = (String) extras[0];
                return new EBook(isbn, title, year, price, author, fileType);
            case DEMO:
                return new DemoBook(isbn, title, year, price, author);
            default:
                throw new IllegalArgumentException("Unknown book type");
        }
    }
}

