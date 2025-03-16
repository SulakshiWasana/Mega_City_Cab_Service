package com.megacitycab.mega_city_cab.controller;

import com.megacitycab.mega_city_cab.model.Customer;
import com.megacitycab.mega_city_cab.model.Driver;
import com.megacitycab.mega_city_cab.service.DriverService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/driver")
public class DriverServlet extends HttpServlet {
    private final DriverService driverService;

    public DriverServlet() {
        this.driverService = new DriverService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action != null && action.equals("view")) {
            List<Driver> drivers = driverService.getAllDrivers();
            req.setAttribute("drivers", drivers);
            req.getRequestDispatcher("admin-dashboard.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("add-driver.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String driverIDStr = req.getParameter("driverID");
        String name = req.getParameter("name");
        String licenseNumber = req.getParameter("licenseNumber");
        String contactNumber = req.getParameter("contactNumber");

        if (action != null) {
            int driverID = driverIDStr != null && !driverIDStr.isEmpty() ? Integer.parseInt(driverIDStr) : 0;
            Driver driver = new Driver();
            driver.setDriverID(driverID);
            driver.setName(name);
            driver.setLicenseNumber(licenseNumber);
            driver.setContactNumber(contactNumber);

            boolean success;
            switch (action) {
                case "add":
                    success = driverService.addDriver(driver);
                    break;
                case "update":
                    success = driverService.updateDriver(driver);
                    break;
                case "delete":
                    success = driverService.deleteDriver(driverID);
                    break;
                default:
                    success = false;
            }

            if (success) {
                resp.sendRedirect("driver?action=view");
            } else {
                resp.sendRedirect("admin-dashboard.jsp?error=Operation failed");
            }
        } else {
            resp.sendRedirect("admin-dashboard.jsp?error=Invalid action");
        }
    }
}
