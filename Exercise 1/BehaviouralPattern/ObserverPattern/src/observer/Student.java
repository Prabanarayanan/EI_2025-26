package observer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.*;

public class Student {
    private String name;
    private List<Observer> observers = new ArrayList<>();
    private static final Logger LOGGER = Logger.getLogger(Student.class.getName());

    static {
        try {
            // FileHandler saves logs into observer.log (append = true)
            FileHandler fileHandler = new FileHandler("observer.log", true);
            fileHandler.setFormatter(new SimpleFormatter());

            // ConsoleHandler prints logs in terminal
            ConsoleHandler consoleHandler = new ConsoleHandler();

            // Reset default handlers
            Logger rootLogger = Logger.getLogger("");
            for (Handler h : rootLogger.getHandlers()) {
                rootLogger.removeHandler(h);
            }
            rootLogger.addHandler(fileHandler);
            rootLogger.addHandler(consoleHandler);
            rootLogger.setLevel(Level.ALL);

        } catch (IOException e) {
            System.err.println("Failed to set up logger: " + e.getMessage());
        }
    }

    public Student(String name) {
    if (name == null || name.trim().isEmpty()) {
        throw new IllegalArgumentException("Student name cannot be null or blank");
    }
    this.name = name;
}


    public void addObserver(Observer observer) {
        if (observer == null) {
            LOGGER.warning("Tried to add null observer, ignored.");
            return;
        }
        observers.add(observer);
        LOGGER.info("Observer added for student: " + name);
    }

    public void removeObserver(Observer observer) {
        if (!observers.remove(observer)) {
            LOGGER.warning("Tried to remove observer that was not registered.");
        } else {
            LOGGER.info("Observer removed for student: " + name);
        }
    }

    public void completeQuiz(String quizName, int score) {
        try {
            if (quizName == null || quizName.trim().isEmpty()) {
    throw new IllegalArgumentException("Quiz name cannot be null or blank");
}

            if (score < 0 || score > 100) {
                throw new IllegalArgumentException("Score must be between 0 and 100");
            }

            String message = "Student " + name + " completed quiz '" + quizName + "' with score " + score;
            notifyObservers(message);
            LOGGER.info(message);

            if (score < 40) {
                String alert = "Alert: " + name + " scored low (" + score + ") in quiz " + quizName;
                notifyObservers(alert);
                LOGGER.warning(alert);
            }
        } catch (IllegalArgumentException e) {
            LOGGER.log(Level.SEVERE, "Invalid quiz attempt for student " + name + ": " + e.getMessage(), e);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Unexpected error in completeQuiz: " + e.getMessage(), e);
        }
    }

    private void notifyObservers(String message) {
        for (Observer obs : observers) {
            try {
                obs.update(message);
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, "Failed to notify an observer: " + e.getMessage(), e);
            }
        }
    }
}
