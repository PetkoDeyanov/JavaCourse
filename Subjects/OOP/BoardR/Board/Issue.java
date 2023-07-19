package BoardR.Board;

import BoardR.Board.Enum.Status;
import BoardR.Loggers.EventLog;

import java.time.LocalDateTime;

public class Issue extends BoardItem {
    private String description;

    public Issue(String title, String description, LocalDateTime date) {
        super(title, date);
        setDescription(description);
        // history.add(new EventLog(this.viewInfo()));
    }

    private void setDescription(String description) {
        if (description.isEmpty()) this.description = "No Description";
        this.description = description;
    }

    @Override
    public String viewInfo() {
        String baseInfo = super.viewInfo();
        String result = (this.description == null) ?
                baseInfo
                : String.format("Issue: %s, Description: %s", baseInfo, this.description);;
        return result;
    }

    @Override
    public void revertStatus() {
        if(this.status == Status.OPEN){
            history.add(new EventLog("Issue Status is already Open"));
            return;
        }
        this.status = Status.OPEN;

        history.add(new EventLog(String.format("Issue status set to %s", this.status.toString())));
    }

    @Override
    public void advanceStatus() {
        if(this.status == Status.VERIFIED){
            history.add(new EventLog("Issue status already Verified"));
            return;
        }
        status = Status.VERIFIED;
        history.add(new EventLog(String.format("Issue status set to %s", this.status.toString())));
    }
}
