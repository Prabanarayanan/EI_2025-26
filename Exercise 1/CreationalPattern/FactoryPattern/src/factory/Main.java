package factory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Student alice = new Student("Alice");
        Student bob = new Student("Bob");

        QuizAttemptTracker tracker = QuizAttemptTracker.getInstance();

        while (true) {
            LoggerUtil.logInfo("\nSelect student:");
            LoggerUtil.logInfo("1. Alice");
            LoggerUtil.logInfo("2. Bob");
            LoggerUtil.logInfo("3. Show Summary");
            LoggerUtil.logInfo("4. Exit");

            String studentChoice = scanner.nextLine().trim();
            Student selectedStudent;

            switch (studentChoice) {
                case "1": selectedStudent = alice; break;
                case "2": selectedStudent = bob; break;
                case "3": tracker.printSummary(); continue;
                case "4": tracker.printSummary(); LoggerUtil.logInfo("Exiting program."); scanner.close(); return;
                default: LoggerUtil.logInfo("Invalid input, try again."); continue;
            }

            LoggerUtil.logInfo("Select quiz type for " + selectedStudent.getName() + ":");
            LoggerUtil.logInfo("1. Multiple Choice (MCQ)");
            LoggerUtil.logInfo("2. True/False (TF)");
            LoggerUtil.logInfo("3. Coding Challenge (Coding)");

            String quizChoice = scanner.nextLine().trim();
            String type = "";

            switch (quizChoice) {
                case "1": type = "mcq"; break;
                case "2": type = "tf"; break;
                case "3": type = "coding"; break;
                default: LoggerUtil.logInfo("Invalid quiz type."); continue;
            }

            try {
                selectedStudent.attemptQuiz(type);
            } catch (Exception e) {
                LoggerUtil.logError("Error generating quiz", e);
            }
        }
    }
}
