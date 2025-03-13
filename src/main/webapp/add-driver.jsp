<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 3/9/2025
  Time: 12:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
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
<h2 class="text-center">Add Driver</h2>
<form action="add-driver" method="post" onsubmit="return validateForm()">
    <div class="mb-3">
        <input type="text" id="name" name="name" class="form-control" placeholder="Driver Name" required>
    </div>
    <div class="mb-3">
        <input type="text" id="licenseNumber" name="licenseNumber" class="form-control" placeholder="License Number" required>
    </div>
    <div class="mb-3">
        <input type="text" id="contactNumber" name="contactNumber" class="form-control" placeholder="Contact Number" required>
    </div>
    <button type="submit" class="btn btn-submit">Add Driver</button>
</form>
<script>
    function validateForm() {
        const driverName = document.getElementById("driverName").value;
        const licenseNumber = document.getElementById("licenseNumber").value;
        const contactNumber = document.getElementById("contactNumber").value;
        if (driverName === "" || licenseNumber === "" || contactNumber === "") {
            alert("Please fill in all fields.");
            return false;
        }
        return true;
    }
</script>
</html>
