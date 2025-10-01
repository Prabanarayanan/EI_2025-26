package strategy;

public class AdaptiveStrategy implements Strategy {
    @Override
    public void recommendLesson(String studentName) {
        LoggerUtil.logInfo("Adaptive strategy: Recommend personalized lessons for " + studentName);
    }
}
