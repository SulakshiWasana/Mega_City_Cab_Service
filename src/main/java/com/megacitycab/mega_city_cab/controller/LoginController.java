package com.megacitycab.mega_city_cab.controller;

import com.megacitycab.mega_city_cab.model.User;
import com.megacitycab.mega_city_cab.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = userService.authenticate(username, password);

        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("username", user.getUsername());
            session.setAttribute("role", user.getRole());

            switch (user.getRole()) {
                case "Admin":
                    response.sendRedirect("admin-dashboard.jsb");
                    break;
                case "Customer":
                    response.sendRedirect("dashboard.jsp");
                    break;
                default:
                    response.sendRedirect("login.jsp");
            }
        } else {
            response.sendRedirect("login.jsp?error=1");
        }
    }
}
