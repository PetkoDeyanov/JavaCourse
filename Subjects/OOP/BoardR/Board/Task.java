package BoardR.Board;

import BoardR.Loggers.EventLog;

import java.time.LocalDateTime;

import BoardR.Board.Enum.Status;

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


    @Override
    public void revertStatus() {
        if (this.status == Status.TODO) {
            history.add(new EventLog("Can't revert, already at To Do"));
            return;
        }
        String oldStat = this.status.toString();

        for (int i = 0; i < 1; i++) {
            if (this.status == Status.TODO) {
                status = Status.OPEN;
                break;
            }
            if (this.status == Status.IN_PROGRESS) {
                status = Status.TODO;
                break;
            }
            if (this.status == Status.DONE) {
                status = Status.IN_PROGRESS;
                break;
            }
            if (this.status == Status.VERIFIED) {
                status = Status.DONE;
                break;
            }
        }
        history.add(new EventLog(String.format("Task status changed from %s to %s", oldStat, this.status.toString())));
    }

    @Override
    public void advanceStatus() {
        if (this.status == Status.VERIFIED) {
            history.add(new EventLog("Can't advance, already at Verified"));
            return;
        }
        String oldStat = this.status.toString();
        for (int i = 0; i < 1; i++) {

            if (this.status == Status.TODO) {
                status = Status.IN_PROGRESS;
                break;
            }
            if (this.status == Status.IN_PROGRESS) {
                status = Status.DONE;
                break;
            }
            if (this.status == Status.DONE) {
                status = Status.VERIFIED;
                break;
            }
        }

        history.add(new EventLog(String.format("Status changed from %s to %s", oldStat, this.status.toString())));
    }

    @Override
    public String viewInfo() {
        String baseInfo = super.viewInfo();
        String result = (this.assignee == null) ?
                baseInfo :
                String.format("Task: %s, Assignee: %s", baseInfo, this.getAssignee()) ;
        return result;
    }
}
