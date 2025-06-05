<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head>
  <title>Add New Task</title>
  <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css" />
  <link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
    rel="stylesheet"
  >
</head>
<body class="container py-4">
  <div class="new_task_submit_form-container">
    <h3>Add New Task</h3>
    <div class="task_submit_form-container">
      <form method="post" action="<%= request.getContextPath() %>/tasks" class="task_submit_form d-flex gap-2">
        <input
          type="text"
          name="title"
          class="form-control"
          placeholder="Enter task title..."
          required
        />
        <button type="submit" class="create_task_button btn">
          Create
        </button>
      </form>
    </div>
    <div class="mt-3">
      <a href="<%= request.getContextPath() %>/tasks.jsp" class="btn btn-secondary">
        Cancel
      </a>
    </div>
  </div>

</body>
</html>
