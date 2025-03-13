package com.megacitycab.mega_city_cab.model;

public class Customer {
    private int CustomerID;
    private String name;
    private String address;
    private String nic;
    private String phoneNumber;

    public Customer() {
    }

    public Customer(int customerID, String name, String address, String nic, String phoneNumber) {
        CustomerID = customerID;
        this.name = name;
        this.address = address;
        this.nic = nic;
        this.phoneNumber = phoneNumber;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int customerID) {
        CustomerID = customerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
