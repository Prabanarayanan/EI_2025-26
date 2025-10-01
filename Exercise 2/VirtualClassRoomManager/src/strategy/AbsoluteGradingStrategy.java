package strategy;
import entities.Submission;
import entities.Assignment;

public class AbsoluteGradingStrategy implements GradingStrategy {
    @Override
    public int grade(Submission s, Assignment a) {
        // Simple: Award max marks if answer is "correct"
        return s.getContent().equalsIgnoreCase("correct") ? a.getMaxMarks() : 0;
    }
}
