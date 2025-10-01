package proxy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Student alice = new Student("Alice");
        Student bob = new Student("Bob");

        QuizAccessProxy proxy = new QuizAccessProxy();
        QuizAttemptTracker tracker = QuizAttemptTracker.getInstance();

        while (true) {
            LoggerUtil.logInfo("\nSelect student:");
            LoggerUtil.logInfo("1. Alice");
            LoggerUtil.logInfo("2. Bob");
            LoggerUtil.logInfo("3. Show Quiz Attempts Summary");
            LoggerUtil.logInfo("4. Exit");

            String choice = scanner.nextLine().trim();
            Student selected;

            switch (choice) {
                case "1": selected = alice; break;
                case "2": selected = bob; break;
                case "3": tracker.printSummary(); continue;
                case "4": LoggerUtil.logInfo("Exiting program."); tracker.printSummary(); scanner.close(); return;
                default: LoggerUtil.logInfo("Invalid input."); continue;
            }

            proxy.start(selected.getName());
        }
    }
}
