package com.megacitycab.mega_city_cab.controller;

import com.megacitycab.mega_city_cab.model.Car;
import com.megacitycab.mega_city_cab.service.CarService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/car")
public class CarServlet extends HttpServlet {
    private final CarService carService;

    public CarServlet() {
        this.carService = new CarService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action != null && action.equals("view")) {
            List<Car> cars = carService.getAllCars();
            req.setAttribute("cars", cars);
            req.getRequestDispatcher("admin-dashboard.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("add-car.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String carIDStr = req.getParameter("carID");
        String model = req.getParameter("model");
        String licensePlate = req.getParameter("licensePlate");
        String availability = req.getParameter("availability");

        if (action != null) {
            int carID = carIDStr != null && !carIDStr.isEmpty() ? Integer.parseInt(carIDStr) : 0;
            Car car = new Car();
            car.setCarID(carID);
            car.setModel(model);
            car.setLicensePlate(licensePlate);
            car.setAvailability(availability);

            boolean success;
            switch (action) {
                case "add":
                    success = carService.addCar(car);
                    break;
                case "update":
                    success = carService.updateCar(car);
                    break;
                case "delete":
                    success = carService.deleteCar(carID);
                    break;
                default:
                    success = false;
            }

            if (success) {
                req.setAttribute("message", "Car added successfully.");
                req.getRequestDispatcher("success.jsp").forward(req, resp);
            } else {
                resp.sendRedirect("admin-dashboard.jsp?error=Operation failed");
            }
        } else {
            resp.sendRedirect("admin-dashboard.jsp?error=Invalid action");
        }
    }
}
