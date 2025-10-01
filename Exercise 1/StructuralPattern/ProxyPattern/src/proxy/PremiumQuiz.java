package proxy;

public class PremiumQuiz implements Quiz {
    @Override
    public void start(String studentName) {
        LoggerUtil.logInfo("Premium quiz started for " + studentName);
        LoggerUtil.logInfo("Displaying advanced questions...");
    }
}
