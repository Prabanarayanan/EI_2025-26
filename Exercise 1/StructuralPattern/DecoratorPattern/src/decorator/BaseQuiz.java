package decorator;

public class BaseQuiz implements Quiz {
    private String studentName;

    public BaseQuiz(String studentName) {
        this.studentName = studentName;
    }

    @Override
    public void start() {
        LoggerUtil.logInfo("Quiz started for " + studentName);
        LoggerUtil.logInfo("Base quiz: standard questions displayed");
    }
}
