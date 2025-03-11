<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 3/9/2025
  Time: 12:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
    <style>
        /* Global Styles */
        body {
            margin: 0;
            padding: 0;
            font-family: 'Poppins', sans-serif;
            background-color: #f8f9fa;
            display: flex;
            min-height: 100vh;
        }

        /* Sidebar Navigation */
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

        /* Main Content */
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

        /* Dashboard Buttons */
        .btn-dashboard {
            background-color: #6c5ce7;
            color: #fff;
            border: none;
            border-radius: 10px;
            padding: 12px;
            font-size: 16px;
            font-weight: 500;
            transition: all 0.3s ease;
            margin-bottom: 15px;
            width: 100%;
            text-align: left;
            display: flex;
            align-items: center;
        }

        .btn-dashboard i {
            margin-right: 10px;
        }

        .btn-dashboard:hover {
            background-color: #5a4bcf;
            transform: translateY(-2px);
            box-shadow: 0 4px 12px rgba(108, 92, 231, 0.2);
        }

        .btn-logout {
            background-color: #ff7675;
            color: #fff;
            border: none;
            border-radius: 10px;
            padding: 12px;
            font-size: 16px;
            font-weight: 500;
            transition: all 0.3s ease;
            width: 100%;
            text-align: left;
            display: flex;
            align-items: center;
        }

        .btn-logout i {
            margin-right: 10px;
        }

        .btn-logout:hover {
            background-color: #e74c3c;
            transform: translateY(-2px);
            box-shadow: 0 4px 12px rgba(231, 76, 60, 0.2);
        }
    </style>
</head>
<body>
<!-- Sidebar Navigation -->
<div class="sidebar">
    <h1>Admin Panel</h1>
    <ul>
        <li><a href="#" onclick="loadContent('add-driver.jsp')"><i class="fas fa-user-plus"></i>Add Driver</a></li>
        <li><a href="#" onclick="loadContent('add-car.jsp')"><i class="fas fa-car"></i>Add Car</a></li>
        <li><a href="#" onclick="loadContent('view-drivers.jsp')"><i class="fas fa-users"></i>View Drivers</a></li>
        <li><a href="#" onclick="loadContent('view-cars.jsp')"><i class="fas fa-car-side"></i>View Cars</a></li>
    </ul>
    <div class="logout">
        <ul>
            <li><a href="logout"><i class="fas fa-sign-out-alt"></i>Logout</a></li>
        </ul>
    </div>
</div>

<!-- Main Content -->
<div class="main-content">
    <h1>Welcome to Admin Dashboard</h1>
    <p>Manage drivers, cars, and bookings with ease.</p>

    <!-- Nested Container for Pages -->
    <div id="page-container" class="page-container">
        <!-- Content will be loaded here dynamically -->
    </div>
</div>

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
</body>
</html>
