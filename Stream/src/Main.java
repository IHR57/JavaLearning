import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
Characteristics of stream:
    -> It does not store any data
    -> It does not change any object and support functional programming
    -> Works lazily
    -> It can be infinite
* */
public class Main {
    public static void main(String args[]) {

        // basic stream example
        List<Book> bookList = List.of(new Book("Sapiens", "English", 1000),
                new Book("Problem Solving Strategies", "English", 350),
                new Book("Ekattor bitore baire", "Bangla", 600),
                new Book("Effective Java", "English", 550));

        System.out.println(Book.findEnglishBooksWithoutStream(bookList));
        System.out.println(Book.findEnglishBooksWithStream(bookList));

        // Collection.stream() => make stream from collection
        List<String> list = new ArrayList<>();
        Stream<String> stringStream = list.stream();

        Set<Integer> set = new HashSet<>();
        Stream<Integer> intStream = set.stream();

        // Stream.of(...) => factory method of stream. Create streams from provided arguments
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);

        // Stream.of(T[]) => create stream from array
        String[] countries = {"Australia", "Bangladesh", "Canada", "Denmark", "England"};
        Stream<String> countryStream = Stream.of(countries);

        // Stream.empty() => create empty stream to prevent null pointer exception
        Stream<String> emptyStream = Stream.empty();

        // Stream.iterate(T first, BinaryOperator<T> f) => creates infinite sequence starting from first
        Stream<Integer> sequence = Stream.iterate(1, val -> val * 2);
        sequence.limit(10).forEach(val -> System.out.print(val + ", ")); // 1, 2, 4, 8, 16, 32, 64, 128, 256, 512

        // Stream.iterate(T first, Predicate<T> test, BinaryOperator<T> f) => we can define for how long the sequence will be generate
        Stream<Integer> sequence1 = Stream.iterate(1, val -> val < 100, val -> val * 2);
        sequence1.forEach(val -> System.out.print(val + ", "));

        // Stream.generate(Supplier<T> f) => creates infinite custom stream
        Stream<UUID> uuidStream = Stream.generate(() -> UUID.randomUUID());
        Stream<Double> randomNumbers = Stream.generate(Math::random);      // creates random numbers
        System.out.println();

        // IntStream.range() and IntStream.rangeClosed()
        IntStream.range(0, 10).forEach(value -> System.out.print(value + ", ")); // 0...9
        System.out.println();
        IntStream.rangeClosed(0, 10).forEach(value -> System.out.print(value + ", "));  // 0..10

        // BufferedReader.lines() -> we can create stream from buffered reader
        //BufferedReader reader = new BufferedReader(new InputStreamReader());
        //Stream<String> lines = reader.lines();
        // lines.limit(10).forEach(val -> System.out.println(val));         // print first 10 lines

        // BitSet Stream
        BitSet bitSet = new BitSet(10);
        bitSet.set(4);

        IntStream stream = bitSet.stream();     // creating int stream from bitset


        StreamIntermediateOperation streamIntermediateOperation = new StreamIntermediateOperation();
        streamIntermediateOperation.run();

    }

}
