import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class UtilFunction {
    public static void run() {
        UnaryOperator<String> unaryOperator = (s -> s.toLowerCase());
        System.out.println(unaryOperator.apply("Hello world!"));

        BinaryOperator<Double> binaryOperator = (a, b) -> {
            return Math.pow(a, b);
        };

        System.out.println(binaryOperator.apply(4.0, 5.0));

        Predicate<Integer> primeChecker = (a -> {
            if(a == 2)
                return true;
            if(a == 1 || a % 2 == 0)
                return false;
            for(int i = 3; i * i <= a; i += 2) {
                if(a % i == 0)
                    return false;
            }

            return true;
        });

        System.out.println(primeChecker.test(27));
        System.out.println(primeChecker.test(6));
        System.out.println(primeChecker.test(7));
        System.out.println(primeChecker.test(19));
    }
}
