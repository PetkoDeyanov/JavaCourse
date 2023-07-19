package BoardR;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class main {
    public static void main(String[] args) {
        Task task = new Task("Test the application flow", "Pesho", LocalDateTime.now().plusDays(1));

        System.out.println(task.getTitle());    // Test the application flow
        System.out.println(task.getDueDate());  // 2020-09-16
        System.out.println(task.getStatus());   // To Do
        System.out.println(task.getAssignee()); // Pesho
    }

}

