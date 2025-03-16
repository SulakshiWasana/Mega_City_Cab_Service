<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 3/8/2025
  Time: 8:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>View Bookings</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-4">
    <h1 class="text-center">View Booking </h1>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Booking ID</th>
            <th>Pickup Location</th>
            <th>Destination</th>
            <th>Booking Date</th>
            <th>Fare</th>
            <th>Car ID</th>
            <th>Customer ID</th>
            <th>Driver ID</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="booking" items="${bookings}">
            <tr>
                <td>${booking.bookingID}</td>
                <td>
                    <form action="booking" method="post">
                        <input type="hidden" name="action" value="update" />
                        <input type="hidden" name="bookingID" value="${booking.bookingID}" />
                        <input type="text" name="pickupLocation" value="${booking.pickupLocation}" required class="form-control" />
                </td>
                <td>
                    <input type="text" name="destination" value="${booking.destination}" required class="form-control" />
                </td>
                <td>
                    <input type="text" name="bookingDate" value="${booking.bookingDate}" required class="form-control" />
                </td>
                <td>
                    <input type="text" name="fare" value="${booking.fare}" required class="form-control" />
                </td>
                <td>
                    <input type="text" name="carID" value="${booking.carID}" required class="form-control" />
                </td>
                <td>
                    <input type="text" name="customerID" value="${booking.customerID}" required class="form-control" />
                </td>
                <td>
                    <input type="text" name="driverID" value="${booking.driverID}" required class="form-control" />
                </td>
                <td>
                    <button type="submit" class="btn btn-primary btn-sm">Update</button>
                    </form>
                </td>
                <td>
                    <form action="booking" method="post" onsubmit="return confirm('Are you sure you want to delete this booking?');">
                        <input type="hidden" name="action" value="delete" />
                        <input type="hidden" name="bookingID" value="${booking.bookingID}" />
                        <button type="submit" class="btn btn-danger btn-sm">Delete</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
