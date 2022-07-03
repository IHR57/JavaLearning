import java.util.List;
import java.util.stream.Collectors;

public class Summarize {

    public static void run() {
        System.out.println("RUNNING SUMMARIZATION TYPE COLLECTORS...");

        List<Book> bookList = Book.createBooks();
        Long totalBooks = bookList.stream().collect(Collectors.counting());
        System.out.println("Total Books: " + totalBooks);

        Long totalReferenceBook = bookList.stream()
                .filter(book -> book.getBookGenres() == BookGenres.REFERENCE_BOOK)
                .collect(Collectors.counting());
        System.out.println("Total Reference Book: " + totalReferenceBook);

        Long totalReferenceBookPrice = bookList.stream()
                .filter(book -> book.getBookGenres() == BookGenres.REFERENCE_BOOK)
                .collect(Collectors.summingLong(Book::getPrice));
        System.out.println("Total Reference Book Price: " + totalReferenceBookPrice);
    }

}
