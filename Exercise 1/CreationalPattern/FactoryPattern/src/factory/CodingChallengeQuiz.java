package factory;

import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class CodingChallengeQuiz extends Quiz {

    public CodingChallengeQuiz(int variantId) {
        super(variantId);
    }

    @Override
    public void generate(String studentName) {
        List<String> challenges = Arrays.asList(
            "Write a function to reverse a string.",
            "Find the largest number in an array.",
            "Implement a simple calculator."
        );
        Collections.shuffle(challenges);

        LoggerUtil.logInfo("Generating Coding Challenge Quiz Variant #" + variantId + " for " + studentName);
        for (String c : challenges) {
            LoggerUtil.logInfo(c);
        }
    }
}
