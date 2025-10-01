package strategy;
import entities.Submission;
import entities.Assignment;

public class RelativeGradingStrategy implements GradingStrategy {
    @Override
    public int grade(Submission s, Assignment a) {
        // Dummy: Award half marks for demo
        return a.getMaxMarks() / 2;
    }
}
