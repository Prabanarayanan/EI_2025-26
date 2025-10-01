package entities;

import java.util.Date;
import strategy.GradingStrategy;  


public class Assignment {
    private String title;
    private Date deadline;
    private int maxMarks;
	private GradingStrategy gradingStrategy;


    public Assignment(String title, Date deadline, int maxMarks, GradingStrategy strategy) {
        this.title = title;
        this.deadline = deadline;
        this.maxMarks = maxMarks;
		this.gradingStrategy = strategy;
    }

    public String getTitle() { return title; }
    public Date getDeadline() { return deadline; }
    public int getMaxMarks() { return maxMarks; }
    public GradingStrategy getGradingStrategy() { return gradingStrategy; }

}
