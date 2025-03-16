package com.megacitycab.mega_city_cab.model;

import java.util.Date;

public class Booking {
    private int bookingID;
    private String pickupLocation;
    private String destination;
    private String bookingDate;
    private String fare;
    private String carID;
    private String customerID;
    private String driverID;

    public Booking() {
    }

    public Booking(int bookingID, String pickupLocation, String destination, String bookingDate, String fare, String carID, String customerID, String driverID) {
        this.bookingID = bookingID;
        this.pickupLocation = pickupLocation;
        this.destination = destination;
        this.bookingDate = bookingDate;
        this.fare = fare;
        this.carID = carID;
        this.customerID = customerID;
        this.driverID = driverID;
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getFare() {
        return fare;
    }

    public void setFare(String fare) {
        this.fare = fare;
    }

    public String getCarID() {
        return carID;
    }

    public void setCarID(String carID) {
        this.carID = carID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getDriverID() {
        return driverID;
    }

    public void setDriverID(String driverID) {
        this.driverID = driverID;
    }
}
