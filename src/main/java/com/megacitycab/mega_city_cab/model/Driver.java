package com.megacitycab.mega_city_cab.model;

public class Driver {
    private int driverID;
    private String name;
    private String licenseNumber;
    private String contactNumber;

    public Driver() {
    }

    public Driver(int driverID, String name, String licenseNumber, String contactNumber) {
        this.driverID = driverID;
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.contactNumber = contactNumber;
    }

    public int getDriverID() {
        return driverID;
    }

    public void setDriverID(int driverID) {
        this.driverID = driverID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
