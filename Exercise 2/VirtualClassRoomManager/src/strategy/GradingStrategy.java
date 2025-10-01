package strategy;
import entities.Submission;
import entities.Assignment;

public interface GradingStrategy {
    int grade(Submission s, Assignment a);
}
