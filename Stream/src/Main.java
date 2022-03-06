import java.util.List;

public class Main {
    public static void main(String args[]) {

        List<Book> bookList = List.of(new Book("Sapiens", "English", 1000),
                new Book("Problem Solving Strategies", "English", 350),
                new Book("Ekattor bitore baire", "Bangla", 600),
                new Book("Effective Java", "English", 550));

        System.out.println(Book.findEnglishBooksWithoutStream(bookList));
        System.out.println(Book.findEnglishBooksWithStream(bookList));
    }

}
