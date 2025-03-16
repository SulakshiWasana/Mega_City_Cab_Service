package com.megacitycab.mega_city_cab.controller;

import com.megacitycab.mega_city_cab.model.Car;
import com.megacitycab.mega_city_cab.model.Driver;
import com.megacitycab.mega_city_cab.service.CarService;
import com.megacitycab.mega_city_cab.service.DriverService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/view-driver")
public class ViewDriverServlet extends HttpServlet {

    private final DriverService driverService;

    public ViewDriverServlet() {
        this.driverService = new DriverService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Driver> drivers = driverService.getAllDrivers() ;
        req.setAttribute("drivers", drivers);
        System.out.println("drivers"+ drivers.size());
        req.getRequestDispatcher("view-drivers.jsp").forward(req, resp);
    }
}
