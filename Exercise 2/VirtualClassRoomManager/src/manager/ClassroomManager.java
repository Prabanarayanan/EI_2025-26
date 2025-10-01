package manager;

import entities.Classroom;
import entities.Teacher;
import entities.Student;
import entities.Assignment;

import java.util.*;
import java.util.logging.*;

public class ClassroomManager {
    private static ClassroomManager instance = null;
    private Map<String, Classroom> classrooms = new HashMap<>();
    private static Logger logger = Logger.getLogger(ClassroomManager.class.getName());

    static {
        try {
            LogManager.getLogManager().reset();
            logger.setLevel(Level.ALL);

            FileHandler fh = new FileHandler("VirtualClassroomManager.log", true);
            fh.setLevel(Level.ALL);
            fh.setFormatter(new SimpleFormatter());

            ConsoleHandler ch = new ConsoleHandler();
            ch.setLevel(Level.SEVERE);

            logger.addHandler(fh);
            logger.addHandler(ch);
        } catch (Exception e) {
            System.err.println("Logger setup failed: " + e.getMessage());
        }
    }

    private ClassroomManager() {}

    public static ClassroomManager getInstance() {
        if (instance == null) {
            instance = new ClassroomManager();
            logger.info("ClassroomManager instance created");
        }
        return instance;
    }

    public void createClassroom(String code, Teacher teacher) {
        if (classrooms.containsKey(code)) {
            logger.warning("Attempt to create duplicate classroom: " + code);
            throw new IllegalArgumentException("Classroom code exists");
        }
        classrooms.put(code, new Classroom(code, teacher));
        logger.info("Classroom created: " + code);
    }

    public void addStudentToClassroom(String code, Student student) {
        Classroom cl = classrooms.get(code);
        if (cl == null) {
            logger.warning("Invalid classroom code on addStudent: " + code);
            throw new IllegalArgumentException("Invalid classroom code");
        }
        cl.addStudent(student);
        logger.info("Student "+ student.getId() +" added to "+ code);
    }

    public void createAssignment(String code, Assignment assignment) {
        Classroom cl = classrooms.get(code);
        if (cl == null) {
            logger.warning("Invalid classroom code on createAssignment: " + code);
            throw new IllegalArgumentException("Invalid classroom code");
        }
        cl.addAssignment(assignment);
        logger.info("Assignment "+ assignment.getTitle() +" created in "+ code);
    }

    public Classroom getClassroom(String code) {
        return classrooms.get(code);
    }
}
