package strategy;

import java.util.Objects;
import java.util.HashMap;
import java.util.Map;

public class Student {
    private String name;
    private Strategy strategy;
    private Map<String, Integer> strategyCount;

    public Student(String name) {
        this.name = Objects.requireNonNull(name, "Student name cannot be null");
        strategyCount = new HashMap<>();
        strategyCount.put("Adaptive", 0);
        strategyCount.put("Gamified", 0);
        strategyCount.put("Time-Based", 0);
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = Objects.requireNonNull(strategy, "Strategy cannot be null");
    }

    public void executeStrategy() {
        if (strategy == null) {
            LoggerUtil.logInfo("No strategy assigned for " + name);
            return;
        }
        strategy.recommendLesson(name);

        // Increment counter based on strategy type
        String key = strategy.getClass().getSimpleName();
        switch (key) {
            case "AdaptiveStrategy":
                strategyCount.put("Adaptive", strategyCount.get("Adaptive") + 1);
                break;
            case "GamifiedStrategy":
                strategyCount.put("Gamified", strategyCount.get("Gamified") + 1);
                break;
            case "TimeBasedStrategy":
                strategyCount.put("Time-Based", strategyCount.get("Time-Based") + 1);
                break;
        }
    }

    public void printStrategyUsage() {
        LoggerUtil.logInfo("Strategy usage summary for " + name + ":");
        strategyCount.forEach((strategy, count) -> 
            LoggerUtil.logInfo(strategy + " executed " + count + " time(s)")
        );
    }

    public String getName() {
        return name;
    }
}
