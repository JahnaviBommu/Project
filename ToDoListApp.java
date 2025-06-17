import java.util.ArrayList;
import java.util.Scanner;
public class ToDoListApp{
    static ArrayList<String> toDoList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== TO-DO LIST MENU =====");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Remove Task");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    removeTask();
                    break;
                case 4:
                    System.out.println("Exiting... Have a productive day!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

    static void addTask() {
        System.out.print("Enter the task: ");
        String task = sc.nextLine();
        toDoList.add(task);
        System.out.println("Task added successfully!");
    }

    static void viewTasks() {
        if (toDoList.isEmpty()) {
            System.out.println("Your to-do list is empty.");
        } else {
            System.out.println("\nYour Tasks:");
            for (int i = 0; i < toDoList.size(); i++) {
                System.out.println((i + 1) + ". " + toDoList.get(i));
            }
        }
    }

    static void removeTask() {
        viewTasks();
        if (!toDoList.isEmpty()) {
            System.out.print("Enter the task number to remove: ");
            int taskNo = sc.nextInt();
            sc.nextLine(); // Consume newline
            if (taskNo >= 1 && taskNo <= toDoList.size()) {
                toDoList.remove(taskNo - 1);
                System.out.println("Task removed successfully!");
            } else {
                System.out.println("Invalid task number.");
            }
        }
    }
}