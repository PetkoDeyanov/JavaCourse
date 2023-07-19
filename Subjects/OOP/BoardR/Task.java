package BoardR;

import java.time.LocalDateTime;

public class Task extends BoardItem {

    private String assignee;

    public Task(String title, String assignee, LocalDateTime date) {

        super(title, date, Status.TODO);
        setAssignee(assignee);

    }

    public void setAssignee(String assignee) {
        if (assignee.length() < 5 || assignee.length() > 30)
            throw new IllegalArgumentException("Assignee should be between 5 and 30 chars.");
        String prevAssignee = this.assignee;
        if (prevAssignee == null) {
            this.assignee = assignee;
            return;
        }
        this.assignee = assignee;
        history.add(new EventLog(String.format("Assignee changed from %s to %s", prevAssignee, assignee)));

    }

    public String getAssignee() {
        return assignee;

    }
}
