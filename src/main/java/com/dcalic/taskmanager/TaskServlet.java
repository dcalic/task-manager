package com.dcalic.taskmanager;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class TaskServlet extends HttpServlet {
    private final TaskRepository repository = new TaskRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String editParam = req.getParameter("edit");
        String taskIdParam = req.getParameter("taskId");

        if ("true".equals(editParam) && taskIdParam != null) {
            try {
                int taskId = Integer.parseInt(taskIdParam);
                Task taskToEdit = repository.getTaskById(taskId);
                if (taskToEdit != null) {
                    req.setAttribute("task", taskToEdit);
                    req.getRequestDispatcher("/editTask.jsp").forward(req, resp);
                    return;
                }
            } catch (NumberFormatException ignored) {
            }
        }

        showAllTasks(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String method = req.getParameter("_method");
        String edit = req.getParameter("edit");

        if ("DELETE".equalsIgnoreCase(method)) {
            handleDelete(req);
        } else if ("true".equalsIgnoreCase(edit)) {
            handleEdit(req);
        } else {
            handleAdd(req);
        }

        resp.sendRedirect(req.getContextPath() + "/tasks");
    }

    private void showAllTasks(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Task> tasks = repository.getAllTasks();
        req.setAttribute("tasks", tasks);
        req.getRequestDispatcher("/tasks.jsp").forward(req, resp);
    }

    private void handleDelete(HttpServletRequest req) {
        String idStr = req.getParameter("taskId");
        if (idStr != null && !idStr.isEmpty()) {
            try {
                int id = Integer.parseInt(idStr);
                repository.deleteTask(id);
            } catch (NumberFormatException ignored) {
            }
        }
    }

    private void handleAdd(HttpServletRequest req) {
        String title = req.getParameter("title");
        if (title != null && !title.trim().isEmpty()) {
            int id = (int) (Math.random() * 100_000);
            Task task = new Task(id, title.trim(), false);
            repository.addTask(task);
        }
    }

    private void handleEdit(HttpServletRequest req) {
        String idStr = req.getParameter("taskId");
        String newTitle = req.getParameter("newTitle");

        if (idStr != null && !idStr.isEmpty() && newTitle != null && !newTitle.trim().isEmpty()) {
            try {
                int id = Integer.parseInt(idStr);
                boolean updated = repository.updateTask(id, newTitle.trim());
                if (!updated) {
                    System.out.println("Failed to update task with ID " + id);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid task ID: " + idStr);
            }
        } else {
            System.out.println("Missing taskId or newTitle for edit");
        }
    }


}
