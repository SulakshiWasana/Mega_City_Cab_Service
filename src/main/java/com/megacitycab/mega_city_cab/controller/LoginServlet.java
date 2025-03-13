package com.megacitycab.mega_city_cab.controller;

import com.megacitycab.mega_city_cab.dao.UserDAO;
import com.megacitycab.mega_city_cab.database.dbConnection;
import com.megacitycab.mega_city_cab.model.User;
import com.megacitycab.mega_city_cab.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        try {
            Connection connection = dbConnection.getConnection();

            userService = new UserService(new UserDAO(connection));
        } catch (SQLException e) {
            throw new ServletException("Failed to initialize database connection", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User authenticatedUser = userService.authenticate(username, password);

        if (authenticatedUser != null) {
            // Create session and store user details
            HttpSession session = request.getSession();
            session.setAttribute("userID", authenticatedUser.getUserID());
            session.setAttribute("username", authenticatedUser.getUsername());
            session.setAttribute("role", authenticatedUser.getRole());

            // Redirect based on role
            if ("Admin".equals(authenticatedUser.getRole())) {
                response.sendRedirect("admin-dashboard.jsp");
            } else if ("Customer".equals(authenticatedUser.getRole())) {
                response.sendRedirect("dashboard.jsp");
            } else {
                response.sendRedirect("index.jsp");
            }
        } else {
            // Redirect back to login page with error message
            request.setAttribute("error", "Invalid username or password");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}
