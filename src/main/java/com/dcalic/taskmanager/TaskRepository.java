package com.dcalic.taskmanager;

import java.util.ArrayList;
import java.util.List;

public class TaskRepository {

    private final List<Task> tasks = new ArrayList<>();

    void addTask(Task task) {
        tasks.add(task);
    }

    List<Task> getAllTasks() {
        return new ArrayList<>(tasks); // Return a copy to prevent external modification
    }

    public boolean deleteTask(int id) {
        return tasks.removeIf(task -> task.getId() == id);
    }

    public boolean updateTask(int id, String newTitle) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setTitle(newTitle);
                moveToTop(task); // Move updated task to top
                return true;
            }
        }
        return false;
    }

    private void moveToTop(Task task) {
        tasks.remove(task);
        tasks.add(0, task);
    }

    public Task getTaskById(int taskId) {
        for (Task task : tasks) {
            if (task.getId() == taskId) {
                return task;
            }
        }
        return null;
    }
}
