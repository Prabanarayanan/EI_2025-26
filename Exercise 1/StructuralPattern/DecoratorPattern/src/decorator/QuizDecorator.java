package decorator;

public abstract class QuizDecorator implements Quiz {
    protected Quiz decoratedQuiz;

    public QuizDecorator(Quiz decoratedQuiz) {
        this.decoratedQuiz = decoratedQuiz;
    }

    @Override
    public void start() {
        decoratedQuiz.start();
    }
}
