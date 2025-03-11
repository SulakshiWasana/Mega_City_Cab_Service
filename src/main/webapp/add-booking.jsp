<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 3/8/2025
  Time: 8:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<h2 class="text-center">Add Booking</h2>
<form action="add-booking" method="post" onsubmit="return validateForm()">
    <div class="mb-3">
        <input type="text" id="pickupLocation" name="pickupLocation" class="form-control" placeholder="Pickup Location" required>
    </div>
    <div class="mb-3">
        <input type="text" id="destination" name="destination" class="form-control" placeholder="Destination" required>
    </div>
    <div class="mb-3">
        <input type="date" id="bookingDate" name="bookingDate" class="form-control" required>
    </div>
    <button type="submit" class="btn btn-submit">Submit</button>
</form>
<script>
    function validateForm() {
        const pickupLocation = document.getElementById("pickupLocation").value;
        const destination = document.getElementById("destination").value;
        const bookingDate = document.getElementById("bookingDate").value;
        if (pickupLocation === "" || destination === "" || bookingDate === "") {
            alert("Please fill in all fields.");
            return false;
        }
        return true;
    }
</script>
</html>
