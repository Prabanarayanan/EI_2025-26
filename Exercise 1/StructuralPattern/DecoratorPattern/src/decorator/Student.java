package decorator;

import java.util.Objects;

public class Student {
    private String name;

    public Student(String name) {
        this.name = Objects.requireNonNull(name, "Student name cannot be null");
    }

    public String getName() {
        return name;
    }
}
