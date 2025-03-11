<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 3/9/2025
  Time: 12:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<div class="view-cars">
    <h1 class="text-center">View Cars</h1>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Car ID</th>
            <th>Car Model</th>
            <th>Car Number</th>
            <th>Driver ID</th>
            <th>Status</th>
        </tr>
        </thead>
        <tbody id="cars-body">
        <!-- Data will be populated dynamically using JavaScript -->
        </tbody>
    </table>
</div>

<script>
    const cars = [
        { id: 1, model: "Toyota Camry", number: "ABC-1234", driverId: 101, status: "Available" },
        { id: 2, model: "Honda Accord", number: "XYZ-5678", driverId: 102, status: "On Trip" }
    ];

    function loadCars() {
        const tbody = document.getElementById("cars-body");
        tbody.innerHTML = cars.map(car => `
            <tr>
                <td>${car.id}</td>
                <td>${car.model}</td>
                <td>${car.number}</td>
                <td>${car.driverId}</td>
                <td>${car.status}</td>
            </tr>
        `).join("");
    }

    window.onload = loadCars;
</script>
</html>
