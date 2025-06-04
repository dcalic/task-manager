package com.dcalic.taskmanager;

import java.util.ArrayList;
import java.util.List;

public class TaskRepository {

    private List<Task> tasks = new ArrayList<>();

    void addTask(Task task){
        tasks.add(task);
    }

    List<Task> getAllTasks(){
        return tasks;
    }

    boolean deteleTask(int d){
        return tasks.remove(d).isCompleted();
    }

}
