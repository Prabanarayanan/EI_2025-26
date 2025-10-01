package observer;

public class Teacher implements Observer {
    private String name;

    public Teacher(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println("Teacher " + name + " received update: " + message);
    }
}
