package BoardR;

import BoardR.Board.BoardItem;
import BoardR.Board.Issue;
import BoardR.Board.Task;

import java.time.LocalDateTime;

public class main {
    public static void main(String[] args) {
        LocalDateTime tomorrow = LocalDateTime.now().plusDays(1);

        BoardItem task = new Task("Write unit tests", "Pesho", tomorrow);
        BoardItem issue = new Issue("Review tests", "Someone must review Pesho's tests.", tomorrow);

        System.out.println(task.viewInfo());
        System.out.println(issue.viewInfo());

    }

}

