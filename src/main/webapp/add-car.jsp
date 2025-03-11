<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 3/9/2025
  Time: 12:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<div class="add-car">
    <h2 class="text-center">Add Car</h2>
    <form action="add-car" method="post" onsubmit="return validateForm()">
        <div class="mb-3">
            <input type="text" id="carModel" name="carModel" class="form-control" placeholder="Car Model" required>
        </div>
        <div class="mb-3">
            <input type="text" id="carNumber" name="carNumber" class="form-control" placeholder="Car Number" required>
        </div>
        <div class="mb-3">
            <input type="text" id="driverId" name="driverId" class="form-control" placeholder="Driver ID" required>
        </div>
        <div class="mb-3">
            <input type="text" id="carStatus" name="carStatus" class="form-control" placeholder="Car Status" required>
        </div>
        <button type="submit" class="btn btn-submit">Add Car</button>
    </form>
</div>

<script>
    function validateForm() {
        const carModel = document.getElementById("carModel").value;
        const carNumber = document.getElementById("carNumber").value;
        const driverId = document.getElementById("driverId").value;
        const carStatus = document.getElementById("carStatus").value;
        if (carModel === "" || carNumber === "" || driverId === "" || carStatus === "") {
            alert("Please fill in all fields.");
            return false;
        }
        return true;
    }
</script>
</html>
