package strategy;

import java.io.IOException;
import java.util.logging.*;

public class LoggerUtil {
    private static final Logger logger = Logger.getLogger("StrategyLogger");

    static {
        try {
            // Remove default handlers
            logger.setUseParentHandlers(false);

            // Console handler
            ConsoleHandler consoleHandler = new ConsoleHandler();
            consoleHandler.setLevel(Level.INFO);
            consoleHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(consoleHandler);

            // File handler
            FileHandler fileHandler = new FileHandler("strategy.log", true); // append mode
            fileHandler.setLevel(Level.INFO);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void logInfo(String message) {
        logger.log(Level.INFO, message);
    }

    public static void logError(String message, Exception e) {
        logger.log(Level.SEVERE, message, e);
    }
}
