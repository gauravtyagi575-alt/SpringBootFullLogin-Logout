<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<html>
<head>
    <title>Change Password</title>
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"/>
</head>
<body>
<div class="container mt-5">
    <h2>Change Password</h2>

    <form action="${pageContext.request.contextPath}/change-password" method="post">
        <div class="mb-3">
            <input type="password" name="currentPassword"
                   class="form-control" placeholder="Current Password" required/>
        </div>
        <div class="mb-3">
            <input type="password" name="newPassword"
                   class="form-control" placeholder="New Password" required/>
        </div>
        <button type="submit" class="btn btn-success">Update</button>
    </form>

    <c:if test="${not empty error}">
        <div class="alert alert-danger mt-2">${error}</div>
    </c:if>
    <c:if test="${not empty msg}">
        <div class="alert alert-success mt-2">${msg}</div>
    </c:if>

    <a href="${pageContext.request.contextPath}/home" class="btn btn-secondary mt-3">Back to Home</a>
</div>
</body>
</html>
