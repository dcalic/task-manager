<%@ page import="com.dcalic.taskmanager.Task" %>
<%@ page import="java.util.List" %>

<html>
<head>
    <title>Task Manager</title>
</head>
<body>
    <h2>Tasks</h2>
    <ul>
        <%
            List<Task> tasks = (List<Task>) request.getAttribute("tasks");
            for (Task task : tasks) {
        %>
        <li>
            <%= task.getTitle() %>
            <form method="post" style="display:inline">
                <input type="hidden" name="_method" value="DELETE">
                <input type="hidden" name="taskId" value="<%= task.getId() %>">
                <button type="submit">Delete</button>
            </form>
        </li>
        <%
            }
        %>
    </ul>

    <h3>Add New Task</h3>
    <form method="post">
        Title: <input type="text" name="title">
        <button type="submit">Add</button>
    </form>
</body>
</html>
