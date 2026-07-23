import java.util.Scanner;

public class TaskManager {

    private static final TaskRepository repository = new TaskRepository();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        System.out.println("Welcome to the Task Manager!");

        do {
            showMenu();
            choice = readNumber();

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    completeTask();
                    break;
                case 4:
                    removeTask();
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Please choose a valid option.");
            }

        } while (choice != 5);

        scanner.close();
    }

    private static void showMenu() {
        System.out.println();
        System.out.println("1. Add a task");
        System.out.println("2. View tasks");
        System.out.println("3. Complete a task");
        System.out.println("4. Remove a task");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
    }

    private static void addTask() {
        System.out.print("Enter the task title: ");
        String title = scanner.nextLine();

        System.out.print("Enter the task description: ");
        String description = scanner.nextLine();

        System.out.print("Enter the priority (High, Medium, or Low): ");
        String priority = scanner.nextLine();

        Task task = new Task(title, description, priority);
        repository.addTask(task);

        System.out.println("Task added successfully.");
    }

    private static void viewTasks() {
        if (repository.getTasks().isEmpty()) {
            System.out.println("There are no tasks.");
            return;
        }

        System.out.println();
        System.out.println("Your Tasks:");

        for (int i = 0; i < repository.getTasks().size(); i++) {
            System.out.println((i + 1) + ". " + repository.getTasks().get(i));
        }
    }

    private static void completeTask() {
        viewTasks();

        if (repository.getTasks().isEmpty()) {
            return;
        }

        System.out.print("Enter the task number to complete: ");
        int taskNumber = readNumber();

        if (taskNumber >= 1 && taskNumber <= repository.getTasks().size()) {
            repository.completeTask(taskNumber - 1);
            System.out.println("Task marked as completed.");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    private static void removeTask() {
        viewTasks();

        if (repository.getTasks().isEmpty()) {
            return;
        }

        System.out.print("Enter the task number to remove: ");
        int taskNumber = readNumber();

        if (taskNumber >= 1 && taskNumber <= repository.getTasks().size()) {
            repository.removeTask(taskNumber - 1);
            System.out.println("Task removed successfully.");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    private static int readNumber() {
        String input = scanner.nextLine();

        while (!input.matches("\\d+")) {
            System.out.print("Please enter a number: ");
            input = scanner.nextLine();
        }

        return Integer.parseInt(input);
    }
}