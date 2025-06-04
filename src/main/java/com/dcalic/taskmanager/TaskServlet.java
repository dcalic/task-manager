package com.dcalic.taskmanager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/tasks")
public class TaskServlet extends HttpServlet {
    private final TaskRepository repository = new TaskRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Task> tasks = repository.getAllTasks();
        req.setAttribute("tasks", tasks);
        req.getRequestDispatcher("/tasks.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8"); // Handle special characters properly

        String method = req.getParameter("_method");

        if ("DELETE".equalsIgnoreCase(method)) {
            // Delete task
            String idStr = req.getParameter("taskId");
            if (idStr != null && !idStr.isEmpty()) {
                try {
                    int id = Integer.parseInt(idStr);
                    boolean deleted = repository.deleteTask(id);
                    if (!deleted) {
                        System.out.println("Task with ID " + id + " not found.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid task ID: " + idStr);
                }
            }

        } else {
            // Add new task
            String title = req.getParameter("title");
            if (title != null && !title.trim().isEmpty()) {
                int id = (int) (Math.random() * 100_000); // Simple random ID
                Task task = new Task(id, title, false);
                repository.addTask(task);
            }
        }

        resp.sendRedirect(req.getContextPath() + "/tasks");
    }
}
