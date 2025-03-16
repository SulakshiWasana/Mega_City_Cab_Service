package com.megacitycab.mega_city_cab.controller;

import com.megacitycab.mega_city_cab.HelloServlet;
import com.megacitycab.mega_city_cab.model.Customer;
import com.megacitycab.mega_city_cab.service.CustomerService;
import com.megacitycab.mega_city_cab.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private UserService userService;

    public void init() {
        userService = new UserService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        boolean isRegistered = userService.registerUser(username, password, role);

        if (isRegistered) {
            response.sendRedirect("index.jsp?success=true");
        } else {
            response.sendRedirect("register.jsp?error=true");
        }
    }
}
