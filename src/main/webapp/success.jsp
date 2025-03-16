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
    </style>
</head>
<body>
<!-- Bootstrap Modal -->
<div class="modal fade" id="successModal" tabindex="-1" aria-labelledby="successModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="successModalLabel">Success!</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <p>${message}</p> <!-- Display dynamic success message -->
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" onclick="redirectToDashboard()">Close</button>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap JS (for modal functionality) -->
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>

<script>
    // Show the modal when the page loads
    window.onload = function() {
        var myModal = new bootstrap.Modal(document.getElementById('successModal'));
        myModal.show();
    };

    // Function to redirect to admin-dashboard.jsp
    function redirectToDashboard() {
        window.location.href = "admin-dashboard.jsp"; // Redirect to admin dashboard
    }
</script>
</body>
</html>