import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class StudentProcessorDemo {
    public static void run() {

        List<Student> studentList = Arrays.asList(
                new Student("Hafeez", 30, Student.Gender.MALE),
                new Student("Hameed", 28, Student.Gender.MALE),
                new Student("Haneefa", 60, Student.Gender.FEMALE),
                new Student("Helal", 32, Student.Gender.MALE),
                new Student("Hamida", 29, Student.Gender.FEMALE),
                new Student("Huraira", 51, Student.Gender.MALE)
        );

        Function<Student, String> nameFunc = (Student s) -> s.getName();
        Function<Student, String> ageFunc = (Student s) -> String.valueOf(s.getAge());
        Function<Student, String> genderFunc = (Student s) -> s.getGender().toString();

        StudentProcessor studentProcessor = new StudentProcessor();

        List<String> names = studentProcessor.process(studentList, nameFunc);
        List<String> ages = studentProcessor.process(studentList, ageFunc);
        List<String> genders = studentProcessor.process(studentList, genderFunc);

        Predicate<Student> olderThan50 = (Student s) -> s.getAge() > 50;
        Predicate<Student> femaleOnly = (Student s) ->
                s.getGender().toString().equalsIgnoreCase("Female");

        List<Student> studentsOlderThan50 = studentProcessor.filter(studentList, olderThan50);
        List<Student> femaleStudents = studentProcessor.filter(studentList, femaleOnly);

        System.out.println("Older Than 50: ");
        for(Student student : studentsOlderThan50) {
            System.out.println(student.toString());
        }

        System.out.println("Female Students: ");
        for(Student student : femaleStudents) {
            System.out.println(student.toString());
        }
    }
}
