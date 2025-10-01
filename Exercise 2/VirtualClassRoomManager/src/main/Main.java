package main;

import manager.ClassroomManager;
import entities.*;
import factories.AssignmentFactory;
import strategy.GradingStrategy;
import strategy.AbsoluteGradingStrategy;
import strategy.RelativeGradingStrategy;
import strategy.AdaptiveGradingStrategy;

import java.util.*;
import java.text.SimpleDateFormat;
import java.util.logging.Logger;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static ClassroomManager manager = ClassroomManager.getInstance();
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        System.out.println("Welcome to Virtual Classroom Manager. Type 'help' for commands.");

        boolean running = true;
        while (running) {
            System.out.print("> ");
            String input = scanner.nextLine();
            if (input.trim().equals("")) continue;
            String[] parts = input.trim().split("\\s+", 2);
            String command = parts[0].toLowerCase();

            try {
                switch (command) {
                    case "help":
                        printHelp();
                        break;

                    case "createclassroom": {
                        String[] paramsCc = parts[1].split("\\s+");
                        if (paramsCc.length != 2) { System.out.println("Usage: createclassroom <code> <teacherId>"); break; }
                        Teacher teacher = new Teacher(paramsCc[1]);
                        manager.createClassroom(paramsCc[0], teacher);
                        System.out.println("Classroom " + paramsCc[0] + " created with teacher " + paramsCc[1]);
                        logger.info("Created classroom: " + paramsCc[0]);
                        break;
                    }

                    case "addstudent": {
                        String[] paramsAs = parts[1].split("\\s+");
                        if (paramsAs.length != 2) { System.out.println("Usage: addstudent <studentId> <classroomCode>"); break; }
                        Student student = new Student(paramsAs[0]);
                        manager.addStudentToClassroom(paramsAs[1], student);
                        System.out.println("Student " + paramsAs[0] + " added to classroom " + paramsAs[1]);
                        logger.info("Added student " + paramsAs[0] + " to classroom " + paramsAs[1]);
                        break;
                    }

                    case "createassignment": {
                        String[] paramsCa = parts[1].split("\\s+", 5);
                        if (paramsCa.length != 5) { 
                            System.out.println("Usage: createassignment <classroomCode> <type> <title> <deadline yyyy-MM-dd> <maxMarks>"); 
                            break; 
                        }
                        String classroomCode = paramsCa[0];
                        String type = paramsCa[1];
                        String title = paramsCa[2];
                        Date deadlineDate = sdf.parse(paramsCa[3]);
                        int maxMarks = Integer.parseInt(paramsCa[4]);
                        System.out.println("Choose grading strategy (absolute/relative/adaptive):");
                        String stratType = scanner.nextLine().trim().toLowerCase();
                        GradingStrategy strategy;
                        switch (stratType) {
                            case "relative": strategy = new RelativeGradingStrategy(); break;
                            case "adaptive": strategy = new AdaptiveGradingStrategy(); break;
                            case "absolute":
                            default: strategy = new AbsoluteGradingStrategy();
                        }
                        Assignment assignment = AssignmentFactory.createAssignment(type, title, deadlineDate, maxMarks, strategy);
                        manager.createAssignment(classroomCode, assignment);
                        System.out.println("Assignment '" + title + "' created for classroom " + classroomCode);
                        logger.info("Created assignment '" + title + "' in classroom " + classroomCode + " with grading strategy: " + stratType);
                        break;
                    }

                    case "submitassignment": {
                        String[] paramsSa = parts[1].split("\\s+", 3);
                        if (paramsSa.length != 3) { System.out.println("Usage: submitassignment <studentId> <classroomCode> <assignmentTitle>"); break; }
                        String studentId = paramsSa[0];
                        String classroomCode = paramsSa[1];
                        String assignmentTitle = paramsSa[2];
                        Classroom cl = manager.getClassroom(classroomCode);
                        if (cl == null) {
                            System.out.println("Invalid classroom code");
                            logger.warning("Invalid classroom code on submission: " + classroomCode);
                            break;
                        }
                        System.out.println("Enter submission content:");
                        String content = scanner.nextLine();
                        cl.submitAssignment(studentId, assignmentTitle, content);
                        logger.info("Student " + studentId + " submitted assignment '" + assignmentTitle + "' in classroom " + classroomCode);
                        break;
                    }

                    case "exit":
                        System.out.println("Exiting. Goodbye!");
                        logger.info("Program exited by user");
                        running = false;
                        break;

                    default:
                        System.out.println("Unknown command. Type 'help' for a list of commands.");
                        logger.warning("Unknown command entered: " + command);
                }
            } catch (Exception e) {
                logger.severe("Exception caught: " + e.getMessage());
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void printHelp() {
        System.out.println("Commands:");
        System.out.println("  createclassroom <code> <teacherId>");
        System.out.println("  addstudent <studentId> <classroomCode>");
        System.out.println("  createassignment <classroomCode> <type> <title> <deadline yyyy-MM-dd> <maxMarks>");
        System.out.println("      (Prompts grading strategy: absolute/relative/adaptive)");
        System.out.println("  submitassignment <studentId> <classroomCode> <assignmentTitle>");
        System.out.println("      (Prompts for submission content)");
        System.out.println("  exit");
    }
}
