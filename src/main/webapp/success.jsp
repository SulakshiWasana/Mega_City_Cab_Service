<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 3/13/2025
  Time: 11:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Success</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: rgba(0, 0, 0, 0.5); /* Semi-transparent background */
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .popup {
            background: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            text-align: center;
        }
    </style>
</head>
<body>
<div class="popup">
    <h3>Success!</h3>
    <p>Car added successfully.</p>
    <button onclick="redirectToDashboard()" class="btn btn-primary">Close</button>
</div>

<script>
    // Function to redirect to admin-dashboard.jsp
    function redirectToDashboard() {
        window.location.href = "admin-dashboard.jsp"; // Redirect to admin dashboard
    }
</script>
</body>
</html>