package com.megacitycab.mega_city_cab.controller;

import com.megacitycab.mega_city_cab.model.Customer;
import com.megacitycab.mega_city_cab.service.CustomerService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/view-customer")
public class ViewCustomerServlet extends HttpServlet {
    private final CustomerService customerService;

    public ViewCustomerServlet() {
        this.customerService = new CustomerService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Customer> customers = customerService.getAllCustomers();
        req.setAttribute("customers", customers);
        req.getRequestDispatcher("view-customer.jsp").forward(req, resp);
    }
}
