package factories;
import strategy.GradingStrategy;
import entities.Assignment;
import java.util.Date;

public class AssignmentFactory {
    public static Assignment createAssignment(String type, String title, Date deadline, int maxMarks, GradingStrategy strategy) {
        switch(type.toLowerCase()) {
            case "mcq":
            case "essay":
            case "coding":
                return new Assignment(title, deadline, maxMarks, strategy);
            default:
                throw new IllegalArgumentException("Unknown assignment type: " + type);
        }
    }
}
