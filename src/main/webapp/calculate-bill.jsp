<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 3/8/2025
  Time: 8:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<h2 class="text-center">Calculate Bill</h2>
<form onsubmit="calculateBill(); return false;">
    <div class="mb-3">
        <input type="text" id="bookingId" class="form-control" placeholder="Enter Booking ID" required>
    </div>
    <button type="submit" class="btn btn-calculate">Calculate</button>
</form>
<div class="bill-details" id="billDetails">
    <p>Total Amount: <span id="totalAmount">-</span></p>
    <p>Tax: <span id="tax">-</span></p>
    <p>Discount: <span id="discount">-</span></p>
    <p>Final Amount: <span id="finalAmount">-</span></p>
</div>
<script>
    function calculateBill() {
        const bookingId = document.getElementById("bookingId").value;
        if (bookingId === "") {
            alert("Please enter a Booking ID.");
            return false;
        }

        // Simulate server-side calculation (replace with actual logic)
        const billDetails = {
            totalAmount: "$100",
            tax: "$10",
            discount: "$5",
            finalAmount: "$105"
        };

        document.getElementById("totalAmount").innerText = billDetails.totalAmount;
        document.getElementById("tax").innerText = billDetails.tax;
        document.getElementById("discount").innerText = billDetails.discount;
        document.getElementById("finalAmount").innerText = billDetails.finalAmount;
    }
</script>
</html>
