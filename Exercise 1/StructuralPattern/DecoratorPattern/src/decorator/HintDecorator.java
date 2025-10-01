package decorator;

public class HintDecorator extends QuizDecorator {

    public HintDecorator(Quiz decoratedQuiz) {
        super(decoratedQuiz);
    }

    @Override
    public void start() {
        super.start();
        LoggerUtil.logInfo("Hints enabled for difficult questions");
    }
}
