import java.io.Serializable;
import java.util.Objects;

public class Student implements Comparable<Student>, Serializable {
    int id, score, age;
    String name;

    public Student(int i, String n, int a, int s) {
        id = i;
        name = n;
        age = a;
        score = s;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        String display = String.format("\nid: %d, name: %s, Age: %d, Score: %d\n",
                this.getId(), this.getName(), this.getAge(), this.getScore());

        return display;
    }

    @Override
    public int compareTo(Student s) {
        if(this.getScore() == s.getScore()) {
            if(this.getName().compareTo(s.getName()) > 0) {
                return 1;
            } else {
                return -1;
            }
        } else {
            if(this.getScore() < s.getScore()) {
                return  1;
            } else {
                return -1;
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return id == student.id &&
                score == student.score &&
                age == student.age &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, score, age, name);
    }

}