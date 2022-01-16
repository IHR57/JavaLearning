import java.util.ArrayList;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReference {
    public static void run() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Dhaka");
        list.add("Chittagong");
        list.add("Khulna");
        list.add("Barisal");

        list.sort((a, b) -> a.compareToIgnoreCase(b));
        // if lambda expression has only one method call in the body then we can use method reference
        list.sort(String::compareToIgnoreCase);         // syntax: Object::methodName
        System.out.println(list.toString());

        // Static Method Reference
        BiFunction<Integer, Integer, Integer> sum = Integer::sum;       // syntax: Class::methodName
        System.out.println(sum.apply(5, 13));

        // Instance Method Reference
        // syntax: objRef::methodName (for default method) or className::methodName (for instance method)

        // constructor reference method
        // if the lambda expression only creates new Object in that case we can use constructor reference
        //Supplier<String> func = () -> new String();     //using lambda
        Supplier<String> func = String::new;    // using constructor reference, syntax: Class::new
    }
}
