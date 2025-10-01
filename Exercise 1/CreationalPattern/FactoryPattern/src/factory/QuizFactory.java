package factory;

import java.util.Random;

public class QuizFactory {

    private static Random random = new Random();

    public static Quiz createQuiz(String type) {
        int variantId = random.nextInt(100) + 1; // Random variant ID
        switch (type.toLowerCase()) {
            case "mcq":
                return new MultipleChoiceQuiz(variantId);
            case "tf":
                return new TrueFalseQuiz(variantId);
            case "coding":
                return new CodingChallengeQuiz(variantId);
            default:
                throw new IllegalArgumentException("Invalid quiz type: " + type);
        }
    }
}
