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

@WebServlet("/customer")
public class CustomerServlet extends HttpServlet {
    private final CustomerService customerService;

    public CustomerServlet() {
        this.customerService = new CustomerService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action != null && action.equals("view")) {
            List<Customer> customers = customerService.getAllCustomers();
            req.setAttribute("customers", customers);
            req.getRequestDispatcher("admin-dashboard.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("add-customer.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String customerIDStr = req.getParameter("customerID");
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String nic = req.getParameter("nic");
        String phoneNumber = req.getParameter("phoneNumber");

        if (action != null) {
            int customerID = customerIDStr != null && !customerIDStr.isEmpty() ? Integer.parseInt(customerIDStr) : 0;
            Customer customer = new Customer();
            customer.setCustomerID(customerID);
            customer.setName(name);
            customer.setAddress(address);
            customer.setNic(nic);
            customer.setPhoneNumber(phoneNumber);

            boolean success;
            switch (action) {
                case "add":
                    success = customerService.addCustomer(customer);
                    break;
                case "update":
                    success = customerService.updateCustomer(customer);
                    break;
                case "delete":
                    success = customerService.deleteCustomer(customerID);
                    break;
                default:
                    success = false;
            }

            if (success) {
                resp.sendRedirect("customer?action=view");
            } else {
                resp.sendRedirect("admin-dashboard.jsp?error=Operation failed");
            }
        } else {
            resp.sendRedirect("admin-dashboard.jsp?error=Invalid action");
        }
    }
}