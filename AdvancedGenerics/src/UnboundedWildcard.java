import java.util.List;

/*
    ? - Means type is not known
    we can use size(), contains, forEach() methods but we can not use add() method when type is not known

    disadvantage: we can not write any value, we can only use Object methods
*/
public class UnboundedWildcard {
    public static void process(List<?> list) {
        list.forEach(o -> {
            System.out.println(o.toString());
        });
    }
}
