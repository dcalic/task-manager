package com.dcalic.taskmanager;

import java.util.ArrayList;
import java.util.List;

public class TaskRepository {

    private List<Task> tasks = new ArrayList<>();

    void addTask(Task task){
        tasks.add(task);
    }

    List<Task> getAllTasks(){
        return new ArrayList<>(tasks); // Return a copy for safetyurn tasks;
    }

    public boolean deleteTask(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                return tasks.remove(task);
            }
        }
        return false; // not found
    }

    public boolean updateTask(int id, String newTitle) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setTitle(newTitle);
                return true;
            }
        }
        return false;
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
