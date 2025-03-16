<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 3/9/2025
  Time: 12:36 AM
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
<div class="add-car">
    <h2 class="text-center">Add Car</h2>
    <form action="car" method="post" onsubmit="return validateForm()">
        <input type="hidden" name="action" value="add" />

        <div class="mb-3">
            <input type="text" id="model" name="model" class="form-control" placeholder="Car Model" required>
        </div>
        <div class="mb-3">
            <input type="text" id="licensePlate" name="licensePlate" class="form-control" placeholder="License Plate No" required>
        </div>
        <div class="mb-3">
            <input type="text" id="availability" name="availability" class="form-control" placeholder="Availability" required>
        </div>
        <button type="submit" class="btn btn-submit">Add Car</button>
    </form>
</div>

<script>
    function validateForm() {
        const model = document.getElementById("model").value;
        const licensePlate = document.getElementById("licensePlate").value;
        const availability = document.getElementById("availability").value;
        if (model === "" || licensePlate === "" || availability === "") {
            alert("Please fill in all fields.");
            return false;
        }
        return true;
    }
</script>
</html>
