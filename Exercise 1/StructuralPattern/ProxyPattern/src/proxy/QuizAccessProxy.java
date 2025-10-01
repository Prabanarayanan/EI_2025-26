package proxy;

import java.util.HashSet;
import java.util.Set;

public class QuizAccessProxy implements Quiz {

    private PremiumQuiz premiumQuiz;
    private Set<String> premiumStudents;

    public QuizAccessProxy() {
        this.premiumQuiz = new PremiumQuiz();
        this.premiumStudents = new HashSet<>();
        // Add premium students
        premiumStudents.add("Bob"); // Only Bob has access
    }

    @Override
    public void start(String studentName) {
        if (premiumStudents.contains(studentName)) {
            LoggerUtil.logInfo(studentName + " has access. Launching quiz...");
            premiumQuiz.start(studentName);
            QuizAttemptTracker.getInstance().recordAttempt(studentName);
        } else {
            LoggerUtil.logInfo(studentName + " does NOT have access to this premium quiz.");
        }
    }
}
