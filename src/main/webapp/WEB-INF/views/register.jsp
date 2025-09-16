<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" 
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"/>
</head>
<body>
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card shadow-lg p-4 rounded-3">
                <h2 class="text-center mb-4">Register</h2>

                <form action="${pageContext.request.contextPath}/register" method="post">
                    <div class="mb-3">
                        <input type="text" name="name" class="form-control" 
                               placeholder="Full Name" required/>
                    </div>
                    <div class="mb-3">
                        <input type="email" name="email" class="form-control" 
                               placeholder="Email" required/>
                    </div>
                    <div class="mb-3">
                        <input type="password" name="password" class="form-control" 
                               placeholder="Password" required/>
                    </div>
                    <button type="submit" class="btn btn-success w-100">Register</button>
                </form>

                <div class="mt-3 text-center">
                    <a href="${pageContext.request.contextPath}/login">Already have an account? Login</a>
                </div>

                <c:if test="${not empty error}">
                    <div class="alert alert-danger mt-3">${error}</div>
                </c:if>
                <c:if test="${not empty msg}">
                    <div class="alert alert-success mt-3">${msg}</div>
                </c:if>
            </div>
        </div>
    </div>
</div>
</body>
</html>
