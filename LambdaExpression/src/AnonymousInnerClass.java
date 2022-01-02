import java.util.ArrayList;
import java.util.List;

public class AnonymousInnerClass {
    public static void runAnonymousInnerClass() {
        Person person1 = new Person(1, "ABC", 20);
        Person person2 = new Person(1, "DEF", 30);
        Person person3 = new Person(1, "GHIJ", 35);
        Person person4 = new Person(1, "KLMN", 10);
        Person person5 = new Person(1, "OPS", 28);

        List<Person> personList = new ArrayList<>();
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);
        personList.add(person5);

        Filterable filterable = new Filterable() {
            @Override
            public boolean apply(Person person) {
                return person.getAge() > 25;
            }
        };

        List<Person> filteredList = filter(personList, filterable);

        for(Person person : filteredList) {
            System.out.println("Name: " + person.getName()
                    + " Age: " + person.getAge().toString()
                    + " ID: " + person.getId().toString());
        }
    }

    public static List<Person> filter(List<Person> personList, Filterable filterable) {
        List<Person> filteredList = new ArrayList<>();
        for(Person person : personList) {
            if(filterable.apply(person)) {
                filteredList.add(person);
            }
        }

        return filteredList;
    }
}
