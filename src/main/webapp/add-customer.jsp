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
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .btn-submit:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<h2>Add Customer</h2>
<form action="customer" method="post" onsubmit="return validateForm()">
    <input type="hidden" name="action" value="add" />

    <div class="mb-3">
        <input type="text" id="name" name="name" class="form-control" placeholder="Customer Name" required />
    </div>
    <div class="mb-3">
        <input type="text" id="address" name="address" class="form-control" placeholder="Address" required />
    </div>
    <div class="mb-3">
        <input type="text" id="nic" name="nic" class="form-control" placeholder="NIC" required />
    </div>
    <div class="mb-3">
        <input type="text" id="phoneNumber" name="phoneNumber" class="form-control" placeholder="Phone Number" required />
    </div>
    <button type="submit" class="btn-submit">Add Customer</button>
</form>

<script>
    function validateForm() {
        const name = document.getElementById("name").value.trim();
        const address = document.getElementById("address").value.trim();
        const nic = document.getElementById("nic").value.trim();
        const phoneNumber = document.getElementById("phoneNumber").value.trim();

        if (name === "" || address === "" || nic === "" || phoneNumber === "") {
            alert("Please fill in all fields.");
            return false;
        }

        return true;
    }
</script>
</body>
</html>