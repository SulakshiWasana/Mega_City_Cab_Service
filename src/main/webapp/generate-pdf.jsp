<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 3/16/2025
  Time: 8:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="application/pdf" %>
<%@ page import="com.megacitycab.mega_city_cab.dao.BookingDAO" %>
<%@ page import="com.megacitycab.mega_city_cab.model.Booking" %>
<%@ page import="com.itextpdf.kernel.pdf.PdfWriter" %>
<%@ page import="com.itextpdf.kernel.pdf.PdfDocument" %>
<%@ page import="com.itextpdf.layout.Document" %>
<%@ page import="com.itextpdf.layout.element.Paragraph" %>
<%@ page import="java.io.OutputStream" %>

<%
    String bookingIDStr = request.getParameter("bookingID");
    int bookingID = (bookingIDStr != null && !bookingIDStr.isEmpty()) ? Integer.parseInt(bookingIDStr) : 0;
    Booking booking = null;

    if (bookingID > 0) {
        booking = BookingDAO.getBookingByID(bookingID);
    }

    if (booking != null) {
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "inline; filename=booking_" + bookingID + ".pdf");

        OutputStream outputStream = response.getOutputStream();
        PdfWriter writer = new PdfWriter(outputStream);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);

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
        outputStream.flush();
        outputStream.close();
    }
%>
