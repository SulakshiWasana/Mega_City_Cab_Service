package com.megacitycab.mega_city_cab.service;

import com.megacitycab.mega_city_cab.dao.DriverDAO;
import com.megacitycab.mega_city_cab.model.Car;
import com.megacitycab.mega_city_cab.model.Customer;
import com.megacitycab.mega_city_cab.model.Driver;

import java.util.List;

public class DriverService {
    private final DriverDAO driverDAO;

    public DriverService() {
        this.driverDAO = new DriverDAO();
    }

    public boolean addDriver(Driver driver) {
        return driverDAO.addDriver(driver);
    }

    public boolean updateDriver(Driver driver) {
        return driverDAO.updateDriver(driver);
    }

    public boolean deleteDriver(int driverID) {
        return driverDAO.deleteDriver(driverID);
    }

    public List<Driver> getAllDrivers() {
        return driverDAO.getAllDrivers();
    }

}
