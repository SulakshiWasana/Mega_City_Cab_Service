<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 3/8/2025
  Time: 8:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<h1 class="text-center">View Bookings</h1>
<table class="table table-striped">
    <thead>
    <tr>
        <th>Booking ID</th>
        <th>Destination</th>
        <th>Fare</th>
        <th>Status</th>
    </tr>
    </thead>
    <tbody id="bookings-body">
    <!-- Data will be populated dynamically using JavaScript -->
    </tbody>
</table>
<script>
    const bookings = [
        { id: 1, destination: "New York", fare: "$100", status: "Completed" },
        { id: 2, destination: "Los Angeles", fare: "$150", status: "Pending" }
    ];

    function loadBookings() {
        const tbody = document.getElementById("bookings-body");
        tbody.innerHTML = bookings.map(booking => `
            <tr>
                <td>${booking.id}</td>
                <td>${booking.destination}</td>
                <td>${booking.fare}</td>
                <td>${booking.status}</td>
            </tr>
        `).join("");
    }

    window.onload = loadBookings;
</script>
</html>
