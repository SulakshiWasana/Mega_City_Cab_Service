<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 3/8/2025
  Time: 8:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.megacitycab.mega_city_cab.model.Car, com.megacitycab.mega_city_cab.model.Customer, com.megacitycab.mega_city_cab.model.Driver" %>
<%@ page import="com.megacitycab.mega_city_cab.dao.CarDAO, com.megacitycab.mega_city_cab.dao.CustomerDAO, com.megacitycab.mega_city_cab.dao.DriverDAO" %>

<%
    List<Car> carList = CarDAO.getAllCars();
    List<Customer> customerList = CustomerDAO.getAllCustomers();
    List<Driver> driverList = DriverDAO.getAllDrivers();
%>

<html>
<head>
    <title>Add Booking</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h2 class="text-center mt-4">Add Booking</h2>
    <form action="booking" method="post" onsubmit="return validateForm()">
        <input type="hidden" name="action" value="add" />

        <!-- Pickup Location -->
        <div class="mb-3">
            <input type="text" id="pickupLocation" name="pickupLocation" class="form-control" placeholder="Pickup Location" required>
        </div>

        <!-- Destination -->
        <div class="mb-3">
            <input type="text" id="destination" name="destination" class="form-control" placeholder="Destination" required>
        </div>

        <!-- Booking Date -->
        <div class="mb-3">
            <input type="date" id="bookingDate" name="bookingDate" class="form-control" required>
        </div>

        <!-- Fare -->
        <div class="mb-3">
            <input type="text" id="fare" name="fare" class="form-control" placeholder="Fare" required>
        </div>

        <!-- Car ID Dropdown -->
        <div class="mb-3">
            <select id="carID" name="carID" class="form-control" required>
                <option value="">Select Car</option>
                <% for(Car car : carList) { %>
                <option value="<%= car.getCarID() %>"><%= car.getModel() %></option>
                <% } %>
            </select>
        </div>

        <!-- Customer ID Dropdown -->
        <div class="mb-3">
            <select id="customerID" name="customerID" class="form-control" required>
                <option value="">Select Customer</option>
                <% for(Customer customer : customerList) { %>
                <option value="<%= customer.getCustomerID() %>"><%= customer.getName()%></option>
                <% } %>
            </select>
        </div>

        <!-- Driver ID Dropdown -->
        <div class="mb-3">
            <select id="driverID" name="driverID" class="form-control" required>
                <option value="">Select Driver</option>
                <% for(Driver driver : driverList) { %>
                <option value="<%= driver.getDriverID() %>"><%= driver.getName() %></option>
                <% } %>
            </select>
        </div>

        <!-- Submit Button -->
        <button type="submit" class="btn btn-primary w-100">Submit</button>
    </form>
</div>

<!-- JavaScript Validation -->
<script>
    function validateForm() {
        const pickupLocation = document.getElementById("pickupLocation").value;
        const destination = document.getElementById("destination").value;
        const bookingDate = document.getElementById("bookingDate").value;
        const carId = document.getElementById("carId").value;
        const customerId = document.getElementById("customerId").value;
        const driverId = document.getElementById("driverId").value;

        if (!pickupLocation || !destination || !bookingDate || !carId || !customerId || !driverId) {
            alert("Please fill in all fields.");
            return false;
        }
        return true;
    }
</script>

</body>
</html>