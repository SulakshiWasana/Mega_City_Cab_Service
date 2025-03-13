package com.megacitycab.mega_city_cab.controller;

import com.megacitycab.mega_city_cab.model.Car;
import com.megacitycab.mega_city_cab.service.CarService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/add-car")
public class CarServlet extends HttpServlet {
    private final CarService carService;

    public CarServlet() {
        this.carService = new CarService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String model = req.getParameter("model");
        String licensePlate = req.getParameter("licensePlate");
        String availability = req.getParameter("availability");

        Car car = new Car();
        car.setModel(model);
        car.setLicensePlate(licensePlate);
        car.setAvailability(availability);

        boolean isAdded = carService.addCar(car);
        if (isAdded) {
            resp.sendRedirect("success.jsp");
        } else {
            resp.sendRedirect("add-car.jsp");
        }
    }
}
