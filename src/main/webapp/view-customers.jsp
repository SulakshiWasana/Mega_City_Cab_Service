<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 3/13/2025
  Time: 10:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>View Customer</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
<div class="view-customer">
    <h1 class="text-center">View Customer</h1>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Customer ID</th>
            <th>Name</th>
            <th>Address</th>
            <th>NIC</th>
            <th>Phone Number</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="customer" items="${customers}">
            <tr>
                <td>${customer.customerID}</td>
                <td>${customer.name}</td>
                <td>${customer.address}</td>
                <td>${customer.NIC}</td>
                <td>${customer.phoneNumber}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>