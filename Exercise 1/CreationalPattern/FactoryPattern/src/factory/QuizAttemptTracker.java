package factory;

import java.util.HashMap;
import java.util.Map;

public class QuizAttemptTracker {
    private static QuizAttemptTracker instance;
    private Map<String, Integer> studentAttempts;

    private QuizAttemptTracker() {
        studentAttempts = new HashMap<>();
    }

    public static QuizAttemptTracker getInstance() {
        if (instance == null) {
            instance = new QuizAttemptTracker();
        }
        return instance;
    }

    public void recordAttempt(String studentName) {
        studentAttempts.put(studentName, studentAttempts.getOrDefault(studentName, 0) + 1);
        LoggerUtil.logInfo(studentName + " attempted a quiz. Total attempts: " + studentAttempts.get(studentName));
    }

    public int getAttempts(String studentName) {
        return studentAttempts.getOrDefault(studentName, 0);
    }

    public void printSummary() {
        LoggerUtil.logInfo("=== Quiz Attempts Summary ===");
        studentAttempts.forEach((name, attempts) ->
            LoggerUtil.logInfo(name + " -> " + attempts + " attempt(s)")
        );
    }
}
