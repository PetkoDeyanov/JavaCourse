package BoardR.Board;

import BoardR.Loggers.EventLog;
import BoardR.Board.Enum.Status;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public abstract class BoardItem {
    protected String title;
    protected LocalDateTime dueDate;
    protected Status status;
    protected final ArrayList<EventLog> history = new ArrayList<>();

    public BoardItem(String title, LocalDateTime date) {
        setDate(date);
        setTitle(title);
        this.status = Status.OPEN;
        history.add(new EventLog("Item created: " + viewInfo()));
    }

    public BoardItem(String title, LocalDateTime date, Status status) {
        setDate(date);
        setTitle(title);
        this.status = status;
        history.add(new EventLog("Item created: " + viewInfo()));
    }

    public void setDate(LocalDateTime newDate) {
        if (newDate.isBefore(LocalDateTime.now()))
            throw new IllegalArgumentException(" Please enter a valid date in future");
        this.dueDate = newDate;
    }

    public void setDueDate(LocalDateTime newDate) {
        if (newDate.isBefore(LocalDateTime.now()))
            throw new IllegalArgumentException(" Please enter a valid date in future");
        this.dueDate = newDate;
        history.add(new EventLog("Item's due date set to " + newDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))));
    }

    public String getTitle() {
        return title;
    }

    public String getDueDate() {
        return dueDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public void setTitle(String title) {
        if (title.length() < 5 || title.length() > 30) {
            throw new IllegalArgumentException("Please provide a title between 5 and 30 chars");
        }
        this.title = title;
        //history.add(new EventLog("Item's title changed to " + title));
    }

    public Status getStatus() {
        return status;
    }


    public abstract void revertStatus();

    public abstract void advanceStatus();
    public String viewInfo() {
        String format = String.format("'%s', [%s | %s]", this.title, this.status.toString(), (dueDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))));
        return format;
    }

    public void displayHistory() {
        for (EventLog el : history) {
            System.out.println(el.viewInfo());
        }
    }

    public String getHistory() {
        StringBuilder builder = new StringBuilder();

        for (EventLog event : history) {
            builder.append(event.viewInfo()).append(System.lineSeparator());
        }

        return builder.toString();
    }
}
