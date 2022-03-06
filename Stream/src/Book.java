import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Book {
    private String bookName;
    private String language;
    private Integer price;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Book(String bookName, String language, Integer price) {
        this.bookName = bookName;
        this.language = language;
        this.price = price;
    }

    public static String findEnglishBooksWithoutStream(List<Book> bookList) {
        List<Book> englishBooks = new ArrayList<>();
        for(Book book : bookList) {
            if(book.getLanguage().equals("English")
                    && book.getPrice() >= 500
                    && book.getPrice() <= 1000) {
                englishBooks.add(book);
            }
        }

        Collections.sort(englishBooks, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return Double.compare(o1.getPrice(), o2.getPrice());
            }
        });

        final String comma = ", ";
        StringBuilder bookBuilder = new StringBuilder();

        for(Book englishBook : englishBooks) {
            bookBuilder.append(englishBook).append(comma);
        }

        return bookBuilder.toString();
    }

    public static String findEnglishBooksWithStream(List<Book> englishBooks) {

        return englishBooks.stream()
                .filter(book -> book.getLanguage().equals("English"))
                .filter(book -> 500 <= book.getPrice() && book.getPrice() <= 1000)
                .sorted(Comparator.comparingDouble(Book::getPrice))
                .map(Book::toString)
                .collect(Collectors.joining(", "));
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", language='" + language + '\'' +
                ", price=" + price +
                '}';
    }
}
