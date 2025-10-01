package factory;

import java.util.Objects;

public class Student {
    private String name;

    public Student(String name) {
        this.name = Objects.requireNonNull(name, "Student name cannot be null");
    }

    public void attemptQuiz(String quizType) {
        Quiz quiz = QuizFactory.createQuiz(quizType);
        quiz.generate(name);
        QuizAttemptTracker.getInstance().recordAttempt(name);
    }

    public String getName() {
        return name;
    }
}
