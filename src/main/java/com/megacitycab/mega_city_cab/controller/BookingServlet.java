package com.megacitycab.mega_city_cab.controller;

import com.megacitycab.mega_city_cab.model.Booking;
import com.megacitycab.mega_city_cab.service.BookingService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/booking")
public class BookingServlet extends HttpServlet {
    private final BookingService bookingService;

    public BookingServlet() {

        this.bookingService = new BookingService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action != null && action.equals("view")) {
            List<Booking> bookings = bookingService.getAllBooking();
            req.setAttribute("bookings", bookings);
            req.getRequestDispatcher("admin-dashboard.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("add-booking.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String bookingIDStr = req.getParameter("bookingID");
        String pickupLocation = req.getParameter("pickupLocation");
        String destination = req.getParameter("destination");
        String bookingDate = req.getParameter("bookingDate");
        String fare = req.getParameter("fare");
        String carID = req.getParameter("carID");
        String customerID = req.getParameter("customerID");
        String driverID = req.getParameter("driverID");

        if (action != null) {
            int bookingID = bookingIDStr != null && !bookingIDStr.isEmpty() ? Integer.parseInt(bookingIDStr) : 0;
            double fareValue = (fare != null && !fare.isEmpty()) ? Double.parseDouble(fare) : 0.0;
            int carIdValue = (carID != null && !carID.isEmpty()) ? Integer.parseInt(carID) : 0;
            int customerIdValue = (customerID != null && !customerID.isEmpty()) ? Integer.parseInt(customerID) : 0;
            int driverIdValue = (driverID != null && !driverID.isEmpty()) ? Integer.parseInt(driverID) : 0;

            Booking booking = new Booking();
            booking.setBookingID(bookingID);
            booking.setPickupLocation(pickupLocation);
            booking.setDestination(destination);
            booking.setBookingDate(bookingDate);
            booking.setFare(String.valueOf(fareValue));
            booking.setCarID(String.valueOf(Integer.valueOf(String.valueOf(carIdValue))));
            booking.setCustomerID(String.valueOf(Integer.valueOf(String.valueOf(customerIdValue))));
            booking.setDriverID(String.valueOf(Integer.valueOf(String.valueOf(driverIdValue))));

            boolean success;
            switch (action) {
                case "add":
                    success = bookingService.addBooking(booking);
                    break;
                case "update":
                    success = bookingService.updateBooking(booking);
                    break;
                case "delete":
                    success = bookingService.deleteBooking(bookingID);
                    break;
                default:
                    success = false;
            }

            if (success) {
                req.setAttribute("message", "Booking added successfully.");
                req.getRequestDispatcher("success.jsp").forward(req, resp);
            } else {
                resp.sendRedirect("admin-dashboard.jsp?error=Operation failed");
            }
        } else {
            resp.sendRedirect("admin-dashboard.jsp?error=Invalid action");
        }
    }

}
