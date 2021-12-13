/*
    Immutable Objects are always thread safe

    Conditions to be a immutable class
        1. Can not change state (field variable)
        2. every field must be start with final keyword

    Conditions to create a immutable object:
        1. every field must be start with private final
        2. no setter method allowed
        3. No subclass cannot be created
        4. class's instance field can be mutable but not allowed to changed

 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class Immutable {

    private final String name;
    private final int age;
    private final List<String> friends;

    public Immutable(String name, int age, List<String> friends) {
        this.name = name;
        this.age = age;
        this.friends = new ArrayList<>(friends);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<String> getFriends() {
        return Collections.unmodifiableList(this.friends);
    }
}
