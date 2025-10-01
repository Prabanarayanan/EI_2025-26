package factory;

import java.util.Collections;
import java.util.List;
import java.util.Arrays;

public class MultipleChoiceQuiz extends Quiz {

    public MultipleChoiceQuiz(int variantId) {
        super(variantId);
    }

    @Override
    public void generate(String studentName) {
        List<String> questions = Arrays.asList(
            "What is 2+2?",
            "Capital of France?",
            "Color of the sky?"
        );

        LoggerUtil.logInfo("Generating Multiple Choice Quiz Variant #" + variantId + " for " + studentName);
        for (String q : questions) {
            List<String> options = Arrays.asList("A)Option1", "B)Option2", "C)Option3", "D)Option4");
            Collections.shuffle(options); // randomize options
            LoggerUtil.logInfo(q + " Options: " + String.join(" ", options));
        }
    }
}
