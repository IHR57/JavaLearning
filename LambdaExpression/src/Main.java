import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.*;

public class Main {
    public static void main(String args[]) {
        //AnonymousInnerClass.runAnonymousInnerClass();   // running anonymous inner class example
        //ContactApp.runContactApp();
        //FrequencyCounter.run();
        //StringConverter.run();
        StudentProcessorDemo.run();
        // lambda expression using java.util.function
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
