package factory;

import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class TrueFalseQuiz extends Quiz {

    public TrueFalseQuiz(int variantId) {
        super(variantId);
    }

    @Override
    public void generate(String studentName) {
        List<String> questions = Arrays.asList(
            "The earth is flat.",
            "Java is a programming language.",
            "Water boils at 100°C."
        );

        LoggerUtil.logInfo("Generating True/False Quiz Variant #" + variantId + " for " + studentName);
        for (String q : questions) {
            List<String> options = Arrays.asList("True", "False");
            Collections.shuffle(options);
            LoggerUtil.logInfo(q + " Options: " + String.join("/", options));
        }
    }
}
