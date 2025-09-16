<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<html>
<head>
    <title>Forgot Password</title>
    <link rel="stylesheet" 
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"/>
</head>
<body>
<div class="container mt-5">
    <h2>Forgot Password</h2>
    <form action="${pageContext.request.contextPath}/forgot" method="post">
        <div class="mb-3">
            <input type="email" name="email" 
                   class="form-control" placeholder="Enter your Email" required/>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>

    <c:if test="${not empty error}">
        <div class="alert alert-danger mt-2">${error}</div>
    </c:if>
    <c:if test="${not empty msg}">
        <div class="alert alert-success mt-2">${msg}</div>
    </c:if>

    <a href="${pageContext.request.contextPath}/login" 
       class="btn btn-secondary mt-3">Back to Login</a>
</div>
</body>
</html>
