package BoardR.Loggers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EventLog {
    private final String argument;
    private final LocalDateTime timestamp;
    private final DateTimeFormatter formatter= DateTimeFormatter.ofPattern("dd-MMMM-yyyy HH:mm:ss");
    public EventLog(String description){
        argument = description;
        timestamp = LocalDateTime.now();
    }

    protected String getDescription(){
        return argument;
    }

    public String viewInfo(){
        String dateFormat = timestamp.format(formatter);
        return String.format("[%s] %s", dateFormat, argument);
    }

}
