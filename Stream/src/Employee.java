public class Employee {
    private static long idGen = 0;

    enum Department {
        IT, HR, FINANCE, MARKETING, DEVELOPMENT
    }

    private long id;
    private int age;
    private String name;
    private Department department;

    public Employee(int age, String name, Department department) {
        this.id = ++idGen;
        this.age = age;
        this.name = name;
        this.department = department;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", department=" + department +
                '}';
    }
}
