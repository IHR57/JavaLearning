import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class StudentProcessor {

    public List<String> process(List<Student> students,
                                Function<Student, String> function) {
        ArrayList<String> list = new ArrayList<>();

        for(Student student : students) {
            String name = function.apply(student);
            list.add(name);
        }

        return list;
    }

    public List<Student> filter(List<Student> students,
                                Predicate<Student> predicate) {
        ArrayList<Student> list = new ArrayList<>();

        for(Student student : students) {
            if(predicate.test(student)) {
                list.add(student);
            }
        }

        return list;
    }
}
