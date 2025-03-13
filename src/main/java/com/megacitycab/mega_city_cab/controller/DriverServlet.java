package com.megacitycab.mega_city_cab.controller;

import com.megacitycab.mega_city_cab.model.Driver;
import com.megacitycab.mega_city_cab.service.DriverService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/add-driver")
public class DriverServlet extends HttpServlet {
    private final DriverService driverService;

    public DriverServlet() {
        this.driverService = new DriverService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String licenseNumber = req.getParameter("licenseNumber");
        String contactNumber = req.getParameter("contactNumber");

        Driver driver = new Driver();
        driver.setName(name);
        driver.setLicenseNumber(licenseNumber);
        driver.setContactNumber(contactNumber);

        boolean isAdded = driverService.addDriver(driver);
        if (isAdded) {
            resp.sendRedirect("success.jsp");
        } else {
            resp.sendRedirect("add-driver.jsp");
        }
    }
}
