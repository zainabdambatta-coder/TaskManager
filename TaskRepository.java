
    import java.util.ArrayList;

public class TaskRepository {

    private final ArrayList<Task> tasks = new ArrayList<>();

    public void addTask(Task task) {
        tasks.add(task);
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        }
    }

    public void completeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            Task currentTask = tasks.get(index);

            Task completedTask = new Task(
                "[Completed] " + currentTask.getTitle(),
                currentTask.getDescription(),
                currentTask.getPriority()
            );

            tasks.set(index, completedTask);
        }
    }
}
    
