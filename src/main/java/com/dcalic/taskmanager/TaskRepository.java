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

    public boolean deleteTask(int d){
        return tasks.remove(d).isCompleted();
    }

}
