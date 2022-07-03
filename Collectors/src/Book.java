import java.util.List;

enum BookGenres {
    REALISTIC_FICTION,
    HISTORICAL_FICTION,
    HUMOR,
    MYSTERY,
    REFERENCE_BOOK,
    YOUNG_ADULT_FICTION
}
public class Book {
    private String name;
    private int price;
    private Author author;
    private Boolean fiction;
    private BookGenres bookGenres;
    private int rating;

    public Book(String name, int price, Author author, Boolean fiction, BookGenres bookGenres) {
        this.name = name;
        this.price = price;
        this.author = author;
        this.fiction = fiction;
        this.bookGenres = bookGenres;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Boolean getFiction() {
        return fiction;
    }

    public void setFiction(Boolean fiction) {
        this.fiction = fiction;
    }

    public BookGenres getBookGenres() {
        return bookGenres;
    }

    public void setBookGenres(BookGenres bookGenres) {
        this.bookGenres = bookGenres;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", author=" + author +
                ", fiction=" + fiction +
                ", bookGenres=" + bookGenres +
                ", rating=" + rating +
                '}';
    }

    public static List<Book> createBooks() {
        Author hAhmed = new Author("Humayun", "Ahmed");
        Author zIqbal = new Author("Zafor", "Iqbal");

        return List.of(
                new Book("Nondito Noroke", 90, hAhmed, true, BookGenres.REALISTIC_FICTION),
                new Book("Deyal", 323, hAhmed, true, BookGenres.HISTORICAL_FICTION),
                new Book("Hijibiji", 213, hAhmed, true, BookGenres.HUMOR),
                new Book("Elebele", 90, hAhmed, true, BookGenres.HUMOR),
                new Book("Misir Ali", 114, hAhmed, true, BookGenres.MYSTERY),

                new Book("Nat Baltu", 132, zIqbal, true, BookGenres.YOUNG_ADULT_FICTION),
                new Book("Ami Topu", 132, zIqbal, true, BookGenres.YOUNG_ADULT_FICTION),
                new Book("Amar Bondhu Rashed", 141, zIqbal, true, BookGenres.HISTORICAL_FICTION),
                new Book("Theory of Relativity", 154, zIqbal, false, BookGenres.REFERENCE_BOOK),
                new Book("Quantum Mechanics", 141, zIqbal, false, BookGenres.REFERENCE_BOOK)
        );
    }
}
