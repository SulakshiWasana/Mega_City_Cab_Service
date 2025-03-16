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

@WebServlet("/view-car")
public class ViewCarServlet extends HttpServlet {
    private final CarService carService;

    public ViewCarServlet() {
        this.carService = new CarService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Car> cars = carService.getAllCars();
        req.setAttribute("cars", cars);
        System.out.println("cars"+ cars.size());
        req.getRequestDispatcher("view-cars.jsp").forward(req, resp);
    }
}
