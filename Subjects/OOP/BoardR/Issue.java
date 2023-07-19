package BoardR;

import java.time.LocalDateTime;

public class Issue extends BoardItem{
    private String description;
    public Issue(String title,String description, LocalDateTime date) {
        super(title, date);
        setDescription(description);
       // history.add(new EventLog(this.viewInfo()));
    }
    private void setDescription(String description){
        if (description.isEmpty()) this.description = "No Description";
        this.description = description;
    }


}
