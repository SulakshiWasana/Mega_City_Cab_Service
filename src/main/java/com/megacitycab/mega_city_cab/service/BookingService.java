package com.megacitycab.mega_city_cab.service;

import com.megacitycab.mega_city_cab.dao.BookingDAO;
import com.megacitycab.mega_city_cab.dao.CustomerDAO;
import com.megacitycab.mega_city_cab.model.Booking;
import com.megacitycab.mega_city_cab.model.Customer;

import java.util.List;

public class BookingService {
    private final BookingDAO bookingDAO;

    public BookingService() {
        this.bookingDAO = new BookingDAO();
    }

    public boolean addBooking(Booking booking) {
        return bookingDAO.addBooking(booking);
    }

    public boolean updateBooking(Booking booking) {
        return bookingDAO.updateBooking(booking);
    }

    public boolean deleteBooking(int bookingID) {
        return bookingDAO.deleteBooking(bookingID);
    }

    public List<Booking> getAllBooking() {
        return bookingDAO.getAllBookings();
    }

    public Booking getBookingByID(int bookingID) {
        return bookingDAO.getBookingByID(bookingID);
    }
}
