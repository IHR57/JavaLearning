import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
BitSet creates vector bit array which is resizable
* */
public class StreamIntermediateOperation {
    public void run() {
        System.out.println("\nIntermediate Running...");

        // Stream<T> filter(Predicate<? super T> predicate)
        Stream<Integer> numbers = Stream.of(1,2,3,4,5,6,7,8,9,10);
        Stream<Integer> evenNumbers = numbers.filter(n -> n % 2 == 0);  // filtering even numbers
        evenNumbers.forEach(val -> System.out.print(val + ","));
        System.out.println();

        // <R> Stream<R> map(Function<? super T, ? extends R> mapper) => useful for converting one data type to another
        List<Person> personList = List.of(
                new Person("Rahim", 15, Sex.MALE),
                new Person("Rehenuma", 10, Sex.FEMALE),
                new Person("Kabir", 20, Sex.MALE),
                new Person("Raihan", 21, Sex.MALE),
                new Person("Farhana", 9, Sex.FEMALE)
        );

//        personStream.filter(person -> person.getAge() > 15)         // only get the names where age older than 15
//                .map(person -> person.getName())
//                .forEach(name -> System.out.println(name));
//
        //alternative
        personList.stream().filter(person -> 15 < person.getAge())
                .map(Person::getName)
                .forEach(System.out::println);


        // <R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper
        Developer polyglot = new Developer("Developer X", Set.of("clojure", "scala", "groovy", "go"));
        Developer busy = new Developer("Developer Y", Set.of("java", "javascript"));

        List<Developer> team = new ArrayList<>();
        team.add(polyglot);
        team.add(busy);

        team.stream().map(Developer::getLanguages)
                .forEach(System.out::println);

        // what if we want all languages together: we can use flatMap
        team.stream()
                .map(Developer::getLanguages)
                .flatMap(Collection::stream)
                .forEach(System.out::println);

        // Stream<T> distinct()
        List<Integer> duplicateNumbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        duplicateNumbers.stream().distinct().forEach(System.out::println);  // print unique numbers

        // Stream<T> sorted
        personList
                .stream()
                .sorted(Comparator
                    .nullsLast(Comparator.comparing(Person::getAge))
                    .thenComparing(Comparator
                        .nullsLast(Comparator.comparing(Person::getName))))
                .forEach(this::printPerson);

        // Stream<T> peek(Consumer<? super T> action) => used for debug purposes
        List<Person> people = personList.stream()
                .peek(person -> System.out.println("before Filter: " +
                        person.getAge() + " " + person.getName()))
                .filter(person -> 15 < person.getAge())
                .peek(person -> System.out.println("After Filter: " +
                        person.getAge() + " " + person.getName()))
                .sorted(Comparator.comparing(Person::getName))
                .collect(Collectors.toList());

        // Stream<T> limit(long maxSize)
        System.out.println("Stream<T> limit(long maxSize)");
        IntStream intStream = IntStream.range(0, 1000);
        intStream.filter(this::isPrime)
                .limit(10)
                .forEach(System.out::println);

        System.out.println("Stream<T> skip(long n)");
        IntStream intSkipStream = IntStream.range(0, 20);
        intSkipStream.filter(this::isPrime)
                .skip(5)
                .forEach(System.out::println);

        // Stream<T> takeWhile(Predicate<? super T> predicate) =>
        // filter may not stop working after condition false; in this case we can use drop
        // while to terminate after false condition
        System.out.println("Stream<T> takeWhile(Predicate<? super T> predicate)");
        List<Integer> integerList = List.of(0, 1, 2, 3, 5, 9, 13, 14, 15, 16, 17, 18);
        integerList.stream()
                .peek(val -> System.out.println("before: " + val))
                .takeWhile(num -> num < 15)
                .forEach(num -> System.out.print(num + " "));

        // Stream<T> dropWhile(Predicate<? super T> predicate => opposite of takeWhile

    }

    private void printPerson(Person person) {
        System.out.println(person.getAge() + " " + person.getName());
    }

    private boolean isPrime(int number) {
        if(number < 2)
            return false;

        return IntStream.rangeClosed(2, number / 2)
                .noneMatch(i -> number % i == 0);
    }
}
