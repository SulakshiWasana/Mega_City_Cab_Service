package com.megacitycab.mega_city_cab.controller;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.megacitycab.mega_city_cab.model.Booking;
import com.megacitycab.mega_city_cab.service.BookingService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.OutputStream;

@WebServlet("/BookingPDFServlet")
public class BookingPdfServlet extends HttpServlet {

    private final BookingService bookingService;

    public BookingPdfServlet() {

        this.bookingService = new BookingService();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookingIDStr = request.getParameter("bookingID");

        if (bookingIDStr == null || bookingIDStr.isEmpty()) {
            response.getWriter().write("Invalid booking ID.");
            return;
        }

        int bookingID = Integer.parseInt(bookingIDStr);
        Booking booking = bookingService.getBookingByID(bookingID);

        if (booking == null) {
            response.getWriter().write("No booking found for ID: " + bookingID);
            return;
        }

        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=booking_" + bookingID + ".pdf");

        try (OutputStream out = response.getOutputStream()) {
            PdfWriter writer = new PdfWriter(out);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            // Add Booking details to the PDF
            document.add(new Paragraph("Booking Details").setBold().setFontSize(20));
            document.add(new Paragraph("Booking ID: " + booking.getBookingID()));
            document.add(new Paragraph("Pickup Location: " + booking.getPickupLocation()));
            document.add(new Paragraph("Destination: " + booking.getDestination()));
            document.add(new Paragraph("Booking Date: " + booking.getBookingDate()));
            document.add(new Paragraph("Fare: " + booking.getFare()));
            document.add(new Paragraph("Car ID: " + booking.getCarID()));
            document.add(new Paragraph("Customer ID: " + booking.getCustomerID()));
            document.add(new Paragraph("Driver ID: " + booking.getDriverID()));

            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
