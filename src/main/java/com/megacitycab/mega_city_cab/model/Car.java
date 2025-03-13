package com.megacitycab.mega_city_cab.model;

public class Car {
    private int carID;
    private String model;
    private String licensePlate;
    private String availability;

    public Car() {
    }

    public Car(int carID, String model, String licensePlate, String availability) {
        this.carID = carID;
        this.model = model;
        this.licensePlate = licensePlate;
        this.availability = availability;
    }

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }
}
