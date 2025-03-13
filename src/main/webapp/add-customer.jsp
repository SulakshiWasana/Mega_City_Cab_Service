<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 3/9/2025
  Time: 12:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Customer</title>
    <style>
        .btn-submit {
            background-color: #4CAF50; /* Green */
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .btn-submit:hover {
            background-color: #45a049; /* Darker green on hover */
        }
    </style>
</head>
<body>
<div class="add-car">
    <h2 class="text-center">Add Customer</h2>
    <form action="add-customer" method="post" onsubmit="return validateForm()">
        <!-- Customer Name Field -->
        <div class="mb-3">
            <input type="text" id="customerName" name="customerName" class="form-control" placeholder="Customer Name" required>
        </div>
        <!-- Address Field -->
        <div class="mb-3">
            <input type="text" id="address" name="address" class="form-control" placeholder="Address" required>
        </div>
        <!-- NIC Field -->
        <div class="mb-3">
            <input type="text" id="nic" name="nic" class="form-control" placeholder="NIC" required>
        </div>
        <!-- Buttons -->
        <div class="mb-3">
            <button type="submit" class="btn btn-submit">Add Customer</button>
        </div>
    </form>
</div>

<script>
    function validateForm() {
        const customerName = document.getElementById("customerName").value.trim();
        const address = document.getElementById("address").value.trim();
        const nic = document.getElementById("nic").value.trim();

        // Check if any field is empty
        if (customerName === "" || address === "" || nic === "") {
            alert("Please fill in all fields.");
            return false; // Prevent form submission
        }

        // Additional validation logic can be added here (e.g., NIC format validation)
        return true; // Allow form submission
    }
</script>
</body>
</html>