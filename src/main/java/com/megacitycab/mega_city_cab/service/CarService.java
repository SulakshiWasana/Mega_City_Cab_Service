package com.megacitycab.mega_city_cab.service;

import com.megacitycab.mega_city_cab.dao.CarDAO;
import com.megacitycab.mega_city_cab.model.Car;

public class CarService {
    private CarDAO carDAO;

    public CarService() {
        this.carDAO = new CarDAO();
    }

    public boolean addCar(Car car) {
        return carDAO.insertCar(car);
    }
}
