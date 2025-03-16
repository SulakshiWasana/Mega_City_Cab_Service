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
    <title>View Customers</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-4">
    <h1 class="text-center">View Customers</h1>
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
                <td>
                    <form action="customer" method="post">
                        <input type="hidden" name="action" value="update" />
                        <input type="hidden" name="customerID" value="${customer.customerID}" />
                        <input type="text" name="name" value="${customer.name}" required class="form-control" />
                </td>
                <td>
                    <input type="text" name="address" value="${customer.address}" required class="form-control" />
                </td>
                <td>
                    <input type="text" name="nic" value="${customer.nic}" required class="form-control" />
                </td>
                <td>
                    <input type="text" name="phoneNumber" value="${customer.phoneNumber}" required class="form-control" />
                </td>
                <td>
                    <button type="submit" class="btn btn-primary btn-sm">Update</button>
                    </form>
                </td>
                <td>
                    <form action="customer" method="post" onsubmit="return confirm('Are you sure you want to delete this customer?');">
                        <input type="hidden" name="action" value="delete" />
                        <input type="hidden" name="customerID" value="${customer.customerID}" />
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
