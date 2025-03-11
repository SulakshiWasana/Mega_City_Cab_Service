<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 3/8/2025
  Time: 7:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
    <style>
        /* Global Styles */
        body {
            margin: 0;
            padding: 0;
            font-family: 'Poppins', sans-serif;
            background: linear-gradient(135deg, #6a11cb, #2575fc); /* Gradient background */
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            overflow: hidden;
        }

        /* Split-Screen Layout */
        .split-container {
            display: flex;
            width: 900px;
            background: #fff;
            border-radius: 20px;
            overflow: hidden;
            box-shadow: 0 8px 32px rgba(0, 0, 0, 0.2);
        }

        /* Left Side - Illustration */
        .left-side {
            flex: 1;
            background: linear-gradient(135deg, rgba(106, 17, 203, 0.9), rgba(37, 117, 252, 0.9));
            display: flex;
            justify-content: center;
            align-items: center;
            padding: 40px;
            color: #fff;
            text-align: center;
        }

        .left-side h2 {
            font-size: 28px;
            font-weight: 700;
            margin-bottom: 20px;
        }

        .left-side p {
            font-size: 16px;
            color: rgba(255, 255, 255, 0.9);
        }

        /* Right Side - Registration Form */
        .right-side {
            flex: 1;
            padding: 40px;
            background: #fff;
        }

        .right-side h2 {
            color: #333;
            font-weight: 700;
            margin-bottom: 30px;
            text-align: center;
            font-size: 24px;
        }

        /* Form Styles */
        .form-group {
            margin-bottom: 20px;
            position: relative;
        }

        .form-group label {
            color: #555;
            font-weight: 500;
            margin-bottom: 8px;
            display: block;
            font-size: 14px;
        }

        .form-control {
            width: 100%;
            padding: 12px 12px 12px 40px; /* Padding for icon */
            border: 1px solid #e0e0e0;
            border-radius: 8px;
            font-size: 16px;
            color: #333;
            background-color: #f9f9f9;
            transition: all 0.3s ease;
        }

        .form-control::placeholder {
            color: #999;
        }

        .form-control:focus {
            border-color: #6c5ce7;
            background-color: #fff;
            box-shadow: 0 0 8px rgba(108, 92, 231, 0.1);
        }

        /* Icons */
        .form-group i {
            position: absolute;
            left: 12px;
            top: 40px;
            color: #6c5ce7;
            font-size: 18px;
        }

        /* Button Styles */
        .btn-register {
            width: 100%;
            padding: 14px;
            background-color: #6c5ce7;
            border: none;
            border-radius: 8px;
            color: #fff;
            font-size: 16px;
            font-weight: 600;
            cursor: pointer;
            transition: all 0.3s ease;
        }

        .btn-register:hover {
            background-color: #5a4bcf;
            transform: translateY(-2px);
            box-shadow: 0 4px 12px rgba(108, 92, 231, 0.2);
        }

        /* Login Link */
        .login-link {
            text-align: center;
            margin-top: 20px;
            color: #666;
            font-size: 14px;
        }

        .login-link a {
            color: #6c5ce7;
            text-decoration: none;
            font-weight: 500;
            transition: all 0.3s ease;
        }

        .login-link a:hover {
            text-decoration: underline;
        }
    </style>
    <script>
        function validateForm() {
            const name = document.getElementById("name").value;
            const address = document.getElementById("address").value;
            const nic = document.getElementById("nic").value;
            const phone = document.getElementById("phone").value;
            const username = document.getElementById("username").value;
            const password = document.getElementById("password").value;
            if (name === "" || address === "" || nic === "" || phone === "" || username === "" || password === "") {
                alert("Please fill in all fields.");
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
<div class="split-container">
    <!-- Left Side - Illustration -->
    <div class="left-side">
        <div>
            <h2>Welcome to Mega City Cab Service</h2>
            <p>Join us today and enjoy seamless travel experiences across the city.</p>
        </div>
    </div>

    <!-- Right Side - Registration Form -->
    <div class="right-side">
        <h2>Create Your Account</h2>
        <form action="register" method="post" onsubmit="return validateForm()">
            <div class="form-group">
                <label for="name">Name</label>
                <i class="fas fa-user"></i>
                <input type="text" id="name" name="name" class="form-control" placeholder="Enter your name" required>
            </div>
            <div class="form-group">
                <label for="address">Address</label>
                <i class="fas fa-map-marker-alt"></i>
                <input type="text" id="address" name="address" class="form-control" placeholder="Enter your address" required>
            </div>
            <div class="form-group">
                <label for="nic">NIC</label>
                <i class="fas fa-id-card"></i>
                <input type="text" id="nic" name="nic" class="form-control" placeholder="Enter your NIC" required>
            </div>
            <div class="form-group">
                <label for="phone">Phone Number</label>
                <i class="fas fa-phone"></i>
                <input type="text" id="phone" name="phone" class="form-control" placeholder="Enter your phone number" required>
            </div>
            <div class="form-group">
                <label for="username">Username</label>
                <i class="fas fa-at"></i>
                <input type="text" id="username" name="username" class="form-control" placeholder="Choose a username" required>
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <i class="fas fa-lock"></i>
                <input type="password" id="password" name="password" class="form-control" placeholder="Choose a password" required>
            </div>
            <button type="submit" class="btn-register">Register</button>
        </form>
        <div class="login-link">
            Already have an account? <a href="login.jsp">Login here</a>
        </div>
    </div>
</div>
</body>
</html>