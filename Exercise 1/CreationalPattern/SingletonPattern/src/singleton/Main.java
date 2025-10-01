package singleton;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Student alice = new Student("Alice");
        Student bob = new Student("Bob");

        QuizAttemptTracker tracker = QuizAttemptTracker.getInstance();
        LoggerUtil.logInfo("Quiz Attempt Tracker Instance HashCode: " + tracker.hashCode());

        while (true) {
            LoggerUtil.logInfo("\nSelect student to attempt quiz:");
            LoggerUtil.logInfo("1. Alice");
            LoggerUtil.logInfo("2. Bob");
            LoggerUtil.logInfo("3. Show Summary");
            LoggerUtil.logInfo("4. Exit");

            String input = scanner.nextLine().trim();

            switch (input) {
                case "1":
                    alice.attemptQuiz();
                    break;
                case "2":
                    bob.attemptQuiz();
                    break;
                case "3":
                    tracker.printSummary();
                    break;
                case "4":
                    LoggerUtil.logInfo("Exiting program.");
                    tracker.printSummary();
                    scanner.close();
                    return;
                default:
                    LoggerUtil.logInfo("Invalid input, try again.");
                    break;
            }
        }
    }
}
