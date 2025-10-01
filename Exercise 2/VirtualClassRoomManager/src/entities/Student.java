package entities;

import observers.Observer;

public class Student implements Observer {
    private String id;

    public Student(String id) { this.id = id; }

    public String getId() { return id; }

    @Override
    public void update(String message) {
        System.out.println("Student " + id + " Notification: " + message);
    }

    public void submitAssignment(Classroom classroom, String assignmentTitle) {
        classroom.getTeacher().update("Student " + id + " submitted '" + assignmentTitle + "'");
    }
}
