import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String args[]) {

        // simple generic example
        Holder<Integer> integerHolder = new Holder<>();
        integerHolder.setObject(10);
        System.out.println(integerHolder.getObject());

        // Unbounded Wildcard example
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        UnboundedWildcard.process(numbers);

        List<Double> doubles = List.of(3.4, 3.5, 3.6, 7.9);
        UnboundedWildcard.process(doubles);

        List<?> list = List.of("this", "is", "a", LocalDateTime.now());
        UnboundedWildcard.process(list);

        // Upper bounded wildcard example
        UpperBoundedWildcard.sumAll(numbers);
        UpperBoundedWildcard.sumAll(doubles);
        // UpperBoundedWildcard.sumAll(list);      // will give error

        // Lower bounded wildcard example
        LowerBoundedWildcard.printListItems(numbers);
        // LowerBoundedWildcard.printListItems(doubles);   // will give error
    }
}
