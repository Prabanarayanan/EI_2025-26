package entities;

public class Submission {
    private String studentId;
    private String content;

    public Submission(String studentId, String content) {
        this.studentId = studentId;
        this.content = content;
    }
    public String getStudentId() { return studentId; }
    public String getContent() { return content; }
}
