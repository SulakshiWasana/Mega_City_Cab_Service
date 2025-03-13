<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 3/13/2025
  Time: 10:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<div class="view-customer">
    <h1 class="text-center">View Customer</h1>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Customer ID</th>
            <th>Name</th>
            <th>Address</th>
            <th>NIC</th>
            <th>phone Number</th>
        </tr>
        </thead>
        <tbody id="customer-body">
        </tbody>
    </table>
</div>

<script>
    const customer = [
        { id: 1, name: "Amal Jayasingha", address: "Kotikawatta", nic: "200011239878", phoneNumber: "0763989765"},
        { id: 2, name: "Amal Jayasingha", address: "Kotikawatta", nic: "200011239878", phoneNumber: "0765654324"},
    ];

    function loadCustomers() {
        const tbody = document.getElementById("customer-body");
        tbody.innerHTML = customer.map(customer => `
            <tr>
                <td>${customer.customerID}</td>
                <td>${customer.name}</td>
                <td>${customer.address}</td>
                <td>${customer.NIC}</td>
                <td>${customer.phoneNumber}</td>
            </tr>
        `).join("");
    }

    window.onload = loadCustomers;
</script>
</html>
