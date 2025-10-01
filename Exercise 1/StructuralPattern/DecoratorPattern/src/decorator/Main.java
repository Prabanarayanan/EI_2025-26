package decorator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student alice = new Student("Alice");

        while (true) {
            LoggerUtil.logInfo("\nSelect quiz enhancements for " + alice.getName() + ":");
            LoggerUtil.logInfo("1. Base Quiz only");
            LoggerUtil.logInfo("2. Timer");
            LoggerUtil.logInfo("3. Hints");
            LoggerUtil.logInfo("4. Bonus Points");
            LoggerUtil.logInfo("5. Timer + Hints");
            LoggerUtil.logInfo("6. Timer + Hints + Bonus Points");
            LoggerUtil.logInfo("7. Exit");

            String choice = scanner.nextLine().trim();
            Quiz quiz;

            switch (choice) {
                case "1":
                    quiz = new BaseQuiz(alice.getName());
                    break;
                case "2":
                    quiz = new TimerDecorator(new BaseQuiz(alice.getName()));
                    break;
                case "3":
                    quiz = new HintDecorator(new BaseQuiz(alice.getName()));
                    break;
                case "4":
                    quiz = new BonusPointsDecorator(new BaseQuiz(alice.getName()));
                    break;
                case "5":
                    quiz = new HintDecorator(new TimerDecorator(new BaseQuiz(alice.getName())));
                    break;
                case "6":
                    quiz = new BonusPointsDecorator(new HintDecorator(new TimerDecorator(new BaseQuiz(alice.getName()))));
                    break;
                case "7":
                    LoggerUtil.logInfo("Exiting program.");
                    scanner.close();
                    return;
                default:
                    LoggerUtil.logInfo("Invalid input, try again.");
                    continue;
            }

            try {
                quiz.start();
            } catch (Exception e) {
                LoggerUtil.logError("Error starting quiz", e);
            }
        }
    }
}
