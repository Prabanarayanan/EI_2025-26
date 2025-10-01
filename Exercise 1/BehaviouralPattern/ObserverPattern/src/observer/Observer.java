package observer;

/**
 * Observer interface for any entity that wants to get updates from Student.
 */
public interface Observer {
    void update(String message);
}
