import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Stream;

public class StreamTerminalOperation {

    public void run() {
        // long count() => returns number of elements of stream processing
        System.out.println("\n\n*** Stream Terminal Operation ***");
        List<Integer> listOfNumbers = List.of(1, 2, 3, 4, 5, 6, 7, 8);
        long quantity = listOfNumbers.stream().count();
        System.out.println("QTY: " + quantity);

        // forEachOrdered() => use if order matters
        Stream.of(listOfNumbers).parallel().sorted()
                .forEachOrdered(System.out::println);

        // toArray()
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8);
        //Object[] integers = integerStream.toArray();
        Integer[] integers = integerStream.toArray(size-> new Integer[size]);

        // min(), max()
        // Optional<Employee> minId = employees.stream().min(Comparator::comparing(Employee::getId));
        // for primitive types
        OptionalInt min = Stream.of(2, 3, 5, 7, 11, 13).mapToInt(Integer::intValue).min();
        System.out.println("MIN: " + min);

        // boolean anyMatch(Predicate<? super T> predicate)
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(19, "Roger", Employee.Department.HR));
        employees.add(new Employee(21, "Waters", Employee.Department.IT));
        employees.add(new Employee(23, "David", Employee.Department.IT));

        boolean anyMatch = employees.stream().anyMatch(employee -> employee.getDepartment()
                == Employee.Department.IT);
        System.out.println("Has IT department employee? :    " + ((anyMatch) ? "YES" : "NO"));

        boolean allMatch = employees.stream().allMatch(employee -> employee.getAge() > 18);
        System.out.println("All are adults? : " + ((allMatch) ? "YES" : "NO"));

        boolean noneMatch = employees.stream().noneMatch(employee -> employee.getAge() < 18);

        // findAny(), findFirst()
        Optional<Employee> itEmployee = employees.stream()
                .filter(e -> e.getDepartment() == Employee.Department.IT)
                .findAny();
        System.out.println(itEmployee.get());

        Optional<Employee> itEmployeeFirst = employees.stream()
                .filter(e -> e.getDepartment() == Employee.Department.DEVELOPMENT)
                .findFirst();
        System.out.println(itEmployeeFirst.isPresent() ? itEmployeeFirst.get() : "NO EMPLOYEE FOUND!");

        // reduce() => return a single value combining all values based on conditions
        int sum = listOfNumbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println("SUM: " + sum);
        System.out.println("MUL: " + listOfNumbers.stream().reduce(1, (a, b) -> a * b));
        // total employee age
        int totalEmployeeAge = employees.stream().mapToInt(Employee::getAge)
                .reduce(0, Integer::sum);
        int employeeMaxAge = employees.stream()
                .filter(employee -> employee.getDepartment() == Employee.Department.IT)
                .mapToInt(Employee::getAge)
                .reduce(0, Integer::max);
        int employeeMinAge = employees.stream()
                .filter(employee -> employee.getDepartment() == Employee.Department.IT)
                .mapToInt(Employee::getAge)
                .reduce(1000, (e1, e2) -> e1 < e2 ? e1 : e2);
        System.out.println("Total Employee Age: " + totalEmployeeAge + " Max Age: " + employeeMaxAge +
                " Min Age: " + employeeMinAge);
    }
}
