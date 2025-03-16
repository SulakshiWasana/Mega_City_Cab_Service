<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 3/16/2025
  Time: 1:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.megacitycab.mega_city_cab.dao.BookingDAO" %>
<%@ page import="com.megacitycab.mega_city_cab.model.Booking" %>

<%
    String bookingIDStr = request.getParameter("bookingID");
    int bookingID = (bookingIDStr != null && !bookingIDStr.isEmpty()) ? Integer.parseInt(bookingIDStr) : 0;
    Booking booking = null;

    if (bookingID > 0) {
        booking = BookingDAO.getBookingByID(bookingID);
    }
%>

<html>
<head>
    <title>Search Booking</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h2 class="text-center mt-4">Enter Booking ID</h2>

    <!-- Form to submit Booking ID -->
    <form method="get" action="booking.jsp" class="d-flex justify-content-center mb-4">
        <input type="text" name="bookingID" class="form-control w-25 me-2" placeholder="Enter Booking ID" required>
        <button type="submit" class="btn btn-success">Get Details</button>
    </form>

    <% if (booking != null) { %>
    <h2 class="text-center mt-4">Booking Details</h2>
    <div class="mb-3">
        <p><strong>Booking ID:</strong> <%= booking.getBookingID() %></p>
        <p><strong>Pickup Location:</strong> <%= booking.getPickupLocation() %></p>
        <p><strong>Destination:</strong> <%= booking.getDestination() %></p>
        <p><strong>Booking Date:</strong> <%= booking.getBookingDate() %></p>
        <p><strong>Fare:</strong> <%= booking.getFare() %></p>
        <p><strong>Car ID:</strong> <%= booking.getCarID() %></p>
        <p><strong>Customer ID:</strong> <%= booking.getCustomerID() %></p>
        <p><strong>Driver ID:</strong> <%= booking.getDriverID() %></p>
    </div>

    <!-- Button to Generate PDF (Redirects to a New Page) -->
    <a href="generate-pdf.jsp?bookingID=<%= booking.getBookingID() %>" target="_blank" class="btn btn-primary">
        Download PDF
    </a>

    <% } else if (bookingID > 0) { %>
    <p class="text-danger text-center">Booking details not found for ID <%= bookingID %>.</p>
    <% } %>
</div>
</body>
</html>
