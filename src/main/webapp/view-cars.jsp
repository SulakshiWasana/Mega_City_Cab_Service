<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 3/9/2025
  Time: 12:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>View Cars</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-4">
    <h1 class="text-center">View Customer</h1>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Car ID</th>
            <th>Car Model</th>
            <th>License Plate</th>
            <th>Status</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="car" items="${cars}">
            <tr>
                <td>${car.carID}</td>
                <td>
                    <form action="car" method="post">
                        <input type="hidden" name="action" value="update" />
                        <input type="hidden" name="carID" value="${car.carID}" />
                        <input type="text" name="model" value="${car.model}" required class="form-control" />
                </td>
                <td>
                    <input type="text" name="licensePlate" value="${car.licensePlate}" required class="form-control" />
                </td>
                <td>
                    <input type="text" name="availability" value="${car.availability}" required class="form-control" />
                </td>
                <td>
                    <button type="submit" class="btn btn-primary btn-sm">Update</button>
                    </form>
                </td>
                <td>
                    <form action="car" method="post" onsubmit="return confirm('Are you sure you want to delete this car?');">
                        <input type="hidden" name="action" value="delete" />
                        <input type="hidden" name="carID" value="${car.carID}" />
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
