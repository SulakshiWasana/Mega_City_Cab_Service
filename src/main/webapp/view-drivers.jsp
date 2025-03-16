<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 3/9/2025
  Time: 12:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>View Drivers</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-4">
    <h1 class="text-center">View Driver</h1>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Driver ID</th>
            <th>Driver Name</th>
            <th>License Number</th>
            <th>Contact Number</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="driver" items="${drivers}">
            <tr>
                <td>${driver.driverID}</td>
                <td>
                    <form action="driver" method="post">
                        <input type="hidden" name="action" value="update" />
                        <input type="hidden" name="driverID" value="${driver.driverID}" />
                        <input type="text" name="name" value="${driver.name}" required class="form-control" />
                </td>
                <td>
                    <input type="text" name="licenseNumber" value="${driver.licenseNumber}" required class="form-control" />
                </td>
                <td>
                    <input type="text" name="contactNumber" value="${driver.contactNumber}" required class="form-control" />
                </td>
                <td>
                    <button type="submit" class="btn btn-primary btn-sm">Update</button>
                    </form>
                </td>
                <td>
                    <form action="driver" method="post" onsubmit="return confirm('Are you sure you want to delete this driver?');">
                        <input type="hidden" name="action" value="delete" />
                        <input type="hidden" name="driverID" value="${driver.driverID}" />
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

