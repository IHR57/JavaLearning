import java.util.List;

/*
Lower bounded wildcard is used to restrict the unknown type to be a specific type or a super type of
that type using ‘?’ with super keyword
* */
public class LowerBoundedWildcard {
    //Work for Number and any of its sub types.
    public static void printListItems(List<? super Integer> list) {
        for(Object num : list) {
            System.out.println(num);
        }
    }
}
