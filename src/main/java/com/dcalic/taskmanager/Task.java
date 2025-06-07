package com.dcalic.taskmanager;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class Task {

    private int id;
    private String title;
    private boolean completed;
    private LocalDate dueDate;

    public Task(int id, String title, boolean completed,LocalDate date) {
        this.id = id;
        this.title = title;
        this.completed = completed;
        this.dueDate=date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public String getPrettyDueDate() {
        if (dueDate == null) return "";

        String month = dueDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        int day = dueDate.getDayOfMonth();
        int year = dueDate.getYear();

        String suffix;
        if (day >= 11 && day <= 13) {
            suffix = "th";
        } else {
            switch (day % 10) {
                case 1: suffix = "st"; break;
                case 2: suffix = "nd"; break;
                case 3: suffix = "rd"; break;
                default: suffix = "th";
            }
        }

        return String.format("%s, %d%s %d.", month, day, suffix, year);
    }


    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                ", dueDate=" + dueDate +
                '}';
    }
}
