<%@ page import="com.dcalic.taskmanager.Task" %>
<%@ page import="java.util.List" %>

<html>
<head>
    <title>Task Manager</title>
     <link rel="stylesheet" type="text/css" href="css/style.css">
     <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <h2>Task Manager</h2>
    <h3>Pending tasks: </h3>
    <ul class="task_list list-group mb-4">
        <%
            List<Task> tasks = (List<Task>) request.getAttribute("tasks");
            for (Task task : tasks) {
        %>
        <li class="task_standalone list-group-item d-flex justify-content-between align-items-center">
            <%= task.getTitle() %>
            <form method="post" style="display:inline">
                <input type="hidden" name="_method" value="DELETE">
                <input type="hidden" name="taskId" value="<%= task.getId() %>">
                <button type="submit" class="btn btn-sm btn-success">Complete</button>
            </form>
        </li>
        <%
            }
        %>
    </ul>

    <h3>Add New Task</h3>
      <form method="post" class="d-flex gap-2">
            <input type="text" name="title" class="form-control" placeholder="Enter task title..." required>
            <button type="submit" class="btn btn-primary">Create</button>
        </form>
</body>
</html>
