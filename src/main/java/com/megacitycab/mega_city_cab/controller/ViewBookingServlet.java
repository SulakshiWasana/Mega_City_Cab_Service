package com.megacitycab.mega_city_cab.controller;

import com.megacitycab.mega_city_cab.model.Booking;
import com.megacitycab.mega_city_cab.model.Driver;
import com.megacitycab.mega_city_cab.service.BookingService;
import com.megacitycab.mega_city_cab.service.DriverService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/view-booking")
public class ViewBookingServlet extends HttpServlet {
    private final BookingService bookingService;

    public ViewBookingServlet() {
        this.bookingService = new BookingService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Booking> bookings = bookingService.getAllBooking() ;
        req.setAttribute("bookings", bookings);
        req.getRequestDispatcher("view-bookings.jsp").forward(req, resp);
    }
}
