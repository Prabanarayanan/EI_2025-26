package strategy;
import entities.Submission;
import entities.Assignment;

public class AdaptiveGradingStrategy implements GradingStrategy {
    @Override
    public int grade(Submission s, Assignment a) {
        // Dummy "AI" logic: award marks based on content length
        int score = Math.min(a.getMaxMarks(), s.getContent().length());
        return score;
    }
}
