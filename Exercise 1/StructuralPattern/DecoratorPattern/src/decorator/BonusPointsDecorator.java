package decorator;

public class BonusPointsDecorator extends QuizDecorator {

    public BonusPointsDecorator(Quiz decoratedQuiz) {
        super(decoratedQuiz);
    }

    @Override
    public void start() {
        super.start();
        LoggerUtil.logInfo("Extra points will be awarded for correct answers");
    }
}
