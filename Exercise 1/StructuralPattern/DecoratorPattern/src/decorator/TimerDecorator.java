package decorator;

public class TimerDecorator extends QuizDecorator {

    public TimerDecorator(Quiz decoratedQuiz) {
        super(decoratedQuiz);
    }

    @Override
    public void start() {
        super.start();
        LoggerUtil.logInfo("Timer started: 10 minutes countdown");
    }
}
