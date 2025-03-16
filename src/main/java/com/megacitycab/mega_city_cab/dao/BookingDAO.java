package com.megacitycab.mega_city_cab.dao;

import com.megacitycab.mega_city_cab.database.dbConnection;
import com.megacitycab.mega_city_cab.model.Booking;
import com.megacitycab.mega_city_cab.model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookingDAO {
    private static final String INSERT_BOOKING_SQL = "INSERT INTO booking (pickupLocation, destination, bookingDate, fare, carID, customerID, driverID) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_BOOKING_SQL = "UPDATE booking SET pickupLocation = ?, destination = ?, bookingDate = ?, fare = ?, carID = ?, customerID = ?, driverID = ? WHERE bookingID = ?";
    private static final String DELETE_BOOKING_SQL = "DELETE FROM booking WHERE bookingID = ?";
    private static final String SELECT_ALL_BOOKINGS_SQL = "SELECT * FROM booking";
    private static final String SELECT_BOOKINGS_BY_ID_SQL = "SELECT * FROM booking WHERE bookingID = ?";

    public boolean addBooking(Booking booking) {
        try (Connection connection = dbConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BOOKING_SQL)) {
            preparedStatement.setString(1, booking.getPickupLocation());
            preparedStatement.setString(2, booking.getDestination());
            preparedStatement.setString(3, booking.getBookingDate());
            preparedStatement.setString(4, booking.getFare());
            preparedStatement.setString(5, booking.getCarID());
            preparedStatement.setString(6, booking.getCustomerID());
            preparedStatement.setString(7, booking.getDriverID());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateBooking(Booking booking) {
        try (Connection connection = dbConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BOOKING_SQL)) {

            // Print values before setting them
            System.out.println("Updating Booking:");
            System.out.println("Pickup Location: " + booking.getPickupLocation());
            System.out.println("Destination: " + booking.getDestination());
            System.out.println("Booking Date: " + booking.getBookingDate());
            System.out.println("Fare: " + booking.getFare());
            System.out.println("Car ID: " + booking.getCarID());
            System.out.println("Customer ID: " + booking.getCustomerID());
            System.out.println("Driver ID: " + booking.getDriverID());
            System.out.println("Booking ID: " + booking.getBookingID());

            preparedStatement.setString(1, booking.getPickupLocation());
            preparedStatement.setString(2, booking.getDestination());
            preparedStatement.setString(3, booking.getBookingDate());
            preparedStatement.setString(4, booking.getFare());
            preparedStatement.setString(5, booking.getCarID());
            preparedStatement.setString(6, booking.getCustomerID());
            preparedStatement.setString(7, booking.getDriverID());
            preparedStatement.setInt(8, booking.getBookingID());

            int rowsUpdated = preparedStatement.executeUpdate();

            // Check if update was successful
            if (rowsUpdated > 0) {
                System.out.println("Booking updated successfully.");
            } else {
                System.out.println("No booking updated. Check Booking ID.");
            }

            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public boolean deleteBooking(int bookingID) {
        try (Connection connection = dbConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BOOKING_SQL)) {
            preparedStatement.setInt(1, bookingID);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static List<Booking> getAllBookings() {
        List<Booking> bookings = new ArrayList<>();
        try (Connection connection = dbConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BOOKINGS_SQL);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Booking booking = new Booking();
                booking.setBookingID(resultSet.getInt("bookingID"));
                booking.setPickupLocation(resultSet.getString("pickupLocation"));
                booking.setDestination(resultSet.getString("destination"));
                booking.setBookingDate(resultSet.getString("bookingDate"));
                booking.setFare(String.valueOf(Double.parseDouble(resultSet.getString("fare"))));
                booking.setCarID(String.valueOf(Integer.parseInt(resultSet.getString("carID"))));
                booking.setCustomerID(String.valueOf(Integer.parseInt(resultSet.getString("customerID"))));
                booking.setDriverID(String.valueOf(Integer.parseInt(resultSet.getString("driverID"))));
                bookings.add(booking);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookings;
    }

    public static Booking getBookingByID(int bookingID) {
        Booking booking = null;

        try (Connection connection = dbConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOKINGS_BY_ID_SQL)) {

            preparedStatement.setInt(1, bookingID);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                booking = new Booking();
                booking.setBookingID(resultSet.getInt("bookingID"));
                booking.setPickupLocation(resultSet.getString("pickupLocation"));
                booking.setDestination(resultSet.getString("destination"));
                booking.setBookingDate(resultSet.getString("bookingDate"));
                booking.setFare(resultSet.getString("fare"));
                booking.setCarID(resultSet.getString("carID"));
                booking.setCustomerID(resultSet.getString("customerID"));
                booking.setDriverID(resultSet.getString("driverID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return booking;
    }
}
