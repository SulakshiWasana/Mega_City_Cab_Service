<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 3/9/2025
  Time: 12:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<h1 class="text-center">View Drivers</h1>
<table class="table table-striped">
    <thead>
    <tr>
        <th>Driver ID</th>
        <th>Name</th>
        <th>License Number</th>
        <th>Contact Number</th>
    </tr>
    </thead>
    <tbody id="drivers-body">
    <!-- Data will be populated dynamically using JavaScript -->
    </tbody>
</table>
<script>
    const drivers = [
        { id: 1, name: "John Doe", licenseNumber: "ABC123", contactNumber: "123-456-7890" },
        { id: 2, name: "Jane Smith", licenseNumber: "XYZ456", contactNumber: "987-654-3210" }
    ];

    function loadDrivers() {
        const tbody = document.getElementById("drivers-body");
        tbody.innerHTML = drivers.map(driver => `
            <tr>
                <td>${driver.id}</td>
                <td>${driver.name}</td>
                <td>${driver.licenseNumber}</td>
                <td>${driver.contactNumber}</td>
            </tr>
        `).join("");
    }

    window.onload = loadDrivers;
</script>
</html>
