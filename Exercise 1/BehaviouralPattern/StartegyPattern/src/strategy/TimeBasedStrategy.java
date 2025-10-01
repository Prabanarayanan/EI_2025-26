package strategy;

public class TimeBasedStrategy implements Strategy {
    @Override
    public void recommendLesson(String studentName) {
        LoggerUtil.logInfo("Time-based strategy: Recommend lessons based on schedule for " + studentName);
    }
}
