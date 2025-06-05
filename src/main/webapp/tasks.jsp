<%@ page import="com.dcalic.taskmanager.Task" %>
<%@ page import="java.util.List" %>

<html>
<head>
    <title>Task Manager</title>
     <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
     <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="new_task_created_form-container">
        <h2 class="header_title">Task Manager</h2>
        <div class="add-btn">
            <div class="mb-3">
                <a href="<%= request.getContextPath() %>/addTask.jsp">
                  <button type="button" class="create_task_button btn">
                    Add New Task
                  </button>
                </a>
              </div>
        </div>
        <h3>Pending tasks: </h3>
        <div class="task_list-container">
            <ul class="task_list list-group mb-4">
                <%
                    List<Task> tasks = (List<Task>) request.getAttribute("tasks");
                    for (Task task : tasks) {
                %>
                <li class="task_standalone list-group-item d-flex justify-content-between align-items-center">
                    <%= task.getTitle() %>
                    <form method="post">
                        <input type="hidden" name="_method" value="DELETE">
                        <input type="hidden" name="taskId" value="<%= task.getId() %>">
                        <button type="submit" class="complete_task_button btn btn-sm">Complete</button>
                    </form>
                </li>
                <%
                    }
                %>
            </ul>
        </div>
    </div>
</body>
</html>
