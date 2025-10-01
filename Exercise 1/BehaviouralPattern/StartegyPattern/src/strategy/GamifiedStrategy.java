package strategy;

public class GamifiedStrategy implements Strategy {
    @Override
    public void recommendLesson(String studentName) {
        LoggerUtil.logInfo("Gamified strategy: Recommend gamified lessons for " + studentName);
    }
}
