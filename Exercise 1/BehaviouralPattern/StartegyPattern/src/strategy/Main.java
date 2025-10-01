package strategy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student student = new Student("Alice");

        while (true) {
            LoggerUtil.logInfo("\nSelect strategy for " + student.getName() + ":");
            LoggerUtil.logInfo("1. Adaptive");
            LoggerUtil.logInfo("2. Gamified");
            LoggerUtil.logInfo("3. Time-Based");
            LoggerUtil.logInfo("4. Exit");

            String input = scanner.nextLine().trim();

            try {
                switch (input) {
                    case "1":
                        student.setStrategy(new AdaptiveStrategy());
                        break;
                    case "2":
                        student.setStrategy(new GamifiedStrategy());
                        break;
                    case "3":
                        student.setStrategy(new TimeBasedStrategy());
                        break;
                    case "4":
                        LoggerUtil.logInfo("Exiting program.");
                        student.printStrategyUsage(); // Log usage summary
                        scanner.close();
                        return;
                    default:
                        LoggerUtil.logInfo("Invalid input, try again.");
                        continue;
                }
                student.executeStrategy();
            } catch (Exception e) {
                LoggerUtil.logError("An error occurred while executing strategy", e);
            }
        }
    }
}
