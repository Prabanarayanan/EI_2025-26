package entities;

import observers.Observer;
import observers.Observable;
import strategy.GradingStrategy;
import entities.Submission;
import entities.Assignment;

import java.util.*;
import java.util.logging.Logger;

public class Classroom implements Observable {
    private String code;
    private Teacher teacher;
    private List<Student> students = new ArrayList<>();
    private List<Assignment> assignments = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();
    private static Logger logger = Logger.getLogger(Classroom.class.getName());

    public Classroom(String code, Teacher teacher) {
        this.code = code;
        this.teacher = teacher;
        addObserver(teacher);
    }

    public void addStudent(Student s) {
        for (Student st : students) {
            if (st.getId().equals(s.getId())) {
                logger.warning("Duplicate student addition attempt: " + s.getId());
                throw new IllegalArgumentException("Duplicate student");
            }
        }
        students.add(s);
        addObserver(s);
        notifyObservers("New student " + s.getId() + " joined classroom " + code);
        logger.info("Student added: " + s.getId() + " to classroom " + code);
    }

    public void addAssignment(Assignment a) {
        if (a.getDeadline().before(new Date())) {
            logger.warning("Assignment deadline not in future: " + a.getTitle());
            throw new IllegalArgumentException("Deadline must be future");
        }
        assignments.add(a);
        notifyObservers("New assignment '" + a.getTitle() + "' posted in " + code);
        logger.info("Assignment added: " + a.getTitle() + " to classroom " + code);
    }

    public void submitAssignment(String studentId, String assignmentTitle, String content) {
        Assignment found = assignments.stream()
                .filter(a -> a.getTitle().equals(assignmentTitle))
                .findFirst()
                .orElse(null);
        if (found == null) {
            logger.warning("Assignment not found at submission: " + assignmentTitle);
            throw new IllegalArgumentException("Assignment not found");
        }
        Student student = students.stream()
                .filter(st -> st.getId().equals(studentId))
                .findFirst()
                .orElse(null);
        if (student == null) {
            logger.warning("Student not enrolled at submission: " + studentId);
            throw new IllegalArgumentException("Student not enrolled in this classroom");
        }
        Submission submission = new Submission(studentId, content);
        int marks = found.getGradingStrategy().grade(submission, found);
        System.out.println("Student " + studentId + " scored " + marks + " on '" + assignmentTitle + "'");
        notifyObservers("Student " + studentId + " submitted '" + assignmentTitle + "' and scored " + marks);
        logger.info("Student " + studentId + " submitted '" + assignmentTitle + "' and scored " + marks);
    }

    @Override
    public void addObserver(Observer o) { observers.add(o); }

    @Override
    public void removeObserver(Observer o) { observers.remove(o); }

    @Override
    public void notifyObservers(String message) {
        for (Observer o : observers) o.update(message);
    }

    public String getCode() { return code; }
    public Teacher getTeacher() { return teacher; }
}
