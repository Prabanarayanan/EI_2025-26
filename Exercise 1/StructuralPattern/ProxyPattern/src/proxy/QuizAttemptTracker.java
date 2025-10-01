package proxy;

import java.util.HashMap;
import java.util.Map;

public class QuizAttemptTracker {
    private static QuizAttemptTracker instance;
    private Map<String, Integer> attempts;

    private QuizAttemptTracker() {
        attempts = new HashMap<>();
    }

    public static QuizAttemptTracker getInstance() {
        if (instance == null) {
            instance = new QuizAttemptTracker();
        }
        return instance;
    }

    public void recordAttempt(String studentName) {
        attempts.put(studentName, attempts.getOrDefault(studentName, 0) + 1);
        LoggerUtil.logInfo(studentName + " attempted a quiz. Total attempts: " + attempts.get(studentName));
    }

    public void printSummary() {
        LoggerUtil.logInfo("=== Quiz Attempts Summary ===");
        attempts.forEach((name, count) -> LoggerUtil.logInfo(name + " -> " + count + " attempt(s)"));
    }
}
