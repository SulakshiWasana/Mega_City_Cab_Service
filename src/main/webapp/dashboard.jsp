<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 3/8/2025
  Time: 8:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: 'Poppins', sans-serif;
            background-color: #f8f9fa;
            display: flex;
            min-height: 100vh;
        }

        .sidebar {
            width: 250px;
            background: linear-gradient(135deg, #6a11cb, #2575fc);
            color: #fff;
            padding: 20px;
            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);
            display: flex;
            flex-direction: column;
            justify-content: space-between;
        }

        .sidebar h1 {
            font-size: 24px;
            font-weight: 700;
            margin-bottom: 30px;
            text-align: center;
        }

        .sidebar ul {
            list-style: none;
            padding: 0;
            margin: 0;
        }

        .sidebar ul li {
            margin-bottom: 15px;
        }

        .sidebar ul li a {
            display: flex;
            align-items: center;
            padding: 12px;
            color: #fff;
            text-decoration: none;
            border-radius: 8px;
            transition: all 0.3s ease;
        }

        .sidebar ul li a:hover {
            background-color: rgba(255, 255, 255, 0.1);
            transform: translateX(5px);
        }

        .sidebar ul li a i {
            margin-right: 10px;
            font-size: 18px;
        }

        .sidebar .logout {
            margin-top: auto;
        }

        .sidebar .logout a {
            background-color: #ff7675;
        }

        .sidebar .logout a:hover {
            background-color: #e74c3c;
        }

        .main-content {
            flex: 1;
            padding: 40px;
            background-color: #fff;
            border-radius: 20px;
            margin: 20px;
            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);
        }

        .main-content h1 {
            color: #333;
            font-weight: 700;
            margin-bottom: 30px;
        }

        .welcome-content {
            margin-bottom: 30px;
        }

        .page-container {
            padding: 20px;
            background-color: #f9f9f9;
            border-radius: 10px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }
    </style>
    <script>
        // Function to load content dynamically using AJAX
        function loadContent(page) {
            const pageContainer = document.getElementById("page-container");
            fetch(page)
                .then(response => response.text())
                .then(data => {
                    pageContainer.innerHTML = data;
                })
                .catch(error => console.error("Error loading content:", error));
        }

        // Load default content on page load
        window.onload = () => loadContent("welcome-content.jsp");
    </script>
</head>
<body>
<!-- Sidebar Navigation -->
<div class="sidebar">
    <h1>Mega City Cab</h1>
    <ul>
        <li><a href="#" onclick="loadContent('welcome-content.jsp')"><i class="fas fa-home"></i>Home</a></li>
        <li><a href="#" onclick="loadContent('add-booking.jsp')"><i class="fas fa-plus"></i>Add Booking</a></li>
        <li><a href="#" onclick="loadContent('view-bookings.jsp')"><i class="fas fa-list"></i>View Bookings</a></li>
        <li><a href="#" onclick="loadContent('calculate-bill.jsp')"><i class="fas fa-calculator"></i>Calculate Bill</a></li>
        <li><a href="register.jsp"><i class="fas fa-user-plus"></i>Register New User</a></li>
    </ul>
    <div class="logout">
        <ul>
            <li><a href="logout"><i class="fas fa-sign-out-alt"></i>Logout</a></li>
        </ul>
    </div>
</div>

<!-- Main Content -->
<div class="main-content">
    <!-- Fixed Welcome Content -->
    <div class="welcome-content">
        <h1>Take Control of Your Ride</h1>
        <p>Enjoy seamless travel experiences with Mega City Cab Service. Book, manage, and track your rides effortlessly.</p>
    </div>

    <!-- Nested Container for Pages -->
    <div id="page-container" class="page-container">
        <!-- Content will be loaded here dynamically -->
    </div>
</div>
</body>
</html>