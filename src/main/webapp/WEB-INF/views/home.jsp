<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" 
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"/>
</head>
<body>
<div class="container mt-5">
    <div class="card shadow-lg p-4 rounded-3">
        <h2 class="mb-3">Welcome, ${user.name}!</h2>
        <p><strong>Email:</strong> ${user.email}</p>

        <div class="mt-4">
            <a href="${pageContext.request.contextPath}/change-password" 
               class="btn btn-warning me-2">Change Password</a>
            <a href="${pageContext.request.contextPath}/logout" 
               class="btn btn-danger">Logout</a>
        </div>
    </div>
</div>
</body>
</html>
