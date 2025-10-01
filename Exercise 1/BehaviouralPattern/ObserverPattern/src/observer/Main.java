package observer;

public class Main {
    public static void main(String[] args) {
        Student alice = new Student("Alice");

        Teacher t1 = new Teacher("Mr. Sharma");
        Teacher t2 = new Teacher("Ms. Gupta");

        // Register observers
        alice.addObserver(t1);
        alice.addObserver(t2);

        // Normal case
        alice.completeQuiz("Math Quiz 1", 85);

        // Low score case
        alice.completeQuiz("Science Quiz 2", 32);
    }
}
