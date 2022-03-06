import java.util.List;

/*
    we can define a certain type using upper bounded wildcard
* */
public class UpperBoundedWildcard {
    public static double sumAll(List<? extends Number> numbers) {       // we can only use Number and it's subclass list
        double sum = 0;
        for(Number number : numbers) {
            sum += number.doubleValue();
        }

        System.out.println("SUM " + sum);
        return sum;
    }
}
