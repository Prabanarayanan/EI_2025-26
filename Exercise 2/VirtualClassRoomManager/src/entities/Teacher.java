package entities;

import observers.Observer;

public class Teacher implements Observer {
    private String id;

    public Teacher(String id) { this.id = id; }

    public String getId() { return id; }

    @Override
    public void update(String message) {
        System.out.println("Teacher " + id + " Notification: " + message);
    }
}
