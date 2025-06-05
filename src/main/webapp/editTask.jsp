<%@ page import="com.dcalic.taskmanager.Task" %>
<%
    Task task = (Task) request.getAttribute("task");
%>
<html>
<head>
    <title>Edit Task</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-4">
        <h2>Edit Task</h2>
        <form method="post" action="<%= request.getContextPath() %>/tasks">
            <input type="hidden" name="edit" value="true" />
            <input type="hidden" name="taskId" value="<%= task.getId() %>" />
            <div class="mb-3">
                 <label for="newTitle" class="form-label">Edit Task Title</label>
                 <input type="text" id="newTitle" name="newTitle" class="form-control" value="<%= task.getTitle() %>" required />
            </div>
            <button type="submit" class="btn btn-primary">Save</button>
            <a href="<%= request.getContextPath() %>/tasks" class="btn btn-secondary">Cancel</a>
        </form>
    </div>
</body>
</html>
