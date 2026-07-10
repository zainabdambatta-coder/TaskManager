import java.util.ArrayList;
import java.util.Scanner;

public class TaskManager {

    private static final ArrayList<String> tasks = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("Welcome to the Task Manager!");

        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                addTask(scanner);
            } else if (choice == 2) {
                viewTasks();
            } else if (choice == 3) {
                System.out.println("Goodbye!");
            } else {
                System.out.println("Please choose a valid option.");
            }

        } while (choice != 3);

        scanner.close();
    }

    private static void showMenu() {
        System.out.println();
        System.out.println("1. Add a task");
        System.out.println("2. View tasks");
        System.out.println("3. Exit");
        System.out.print("Choose an option: ");
    }

    private static void addTask(Scanner scanner) {
        System.out.print("Enter a task: ");
        String task = scanner.nextLine();
        tasks.add(task);
        System.out.println("Task added.");
    }

    private static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks have been added.");
            return;
        }

        System.out.println("Your tasks:");

        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }
}
