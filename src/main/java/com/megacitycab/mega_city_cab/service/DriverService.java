package com.megacitycab.mega_city_cab.service;

import com.megacitycab.mega_city_cab.dao.DriverDAO;
import com.megacitycab.mega_city_cab.model.Driver;

public class DriverService {
    private final DriverDAO driverDAO;

    public DriverService() {
        this.driverDAO = new DriverDAO();
    }

    public boolean addDriver(Driver driver) {
        return driverDAO.insertDriver(driver);
    }
}
