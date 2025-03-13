package com.megacitycab.mega_city_cab.controller;

import com.megacitycab.mega_city_cab.HelloServlet;
import com.megacitycab.mega_city_cab.model.Customer;
import com.megacitycab.mega_city_cab.service.CustomerService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private final CustomerService customerService;

    public RegisterServlet() {
        this.customerService = new CustomerService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String nic = req.getParameter("nic");
        String phone = req.getParameter("phoneNumber");

        Customer customer = new Customer();
        customer.setName(name);
        customer.setAddress(address);
        customer.setNic(nic);
        customer.setPhoneNumber(phone);

        boolean isRegistered = customerService.registerCustomer(customer);
        if (isRegistered) {
            resp.sendRedirect("index.jsp"); // Redirect to login page after successful registration
        } else {
            resp.sendRedirect("register.jsp"); // Redirect back to registration page if registration fails
        }
    }

}
