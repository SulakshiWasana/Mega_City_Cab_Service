package com.megacitycab.mega_city_cab.service;

import com.megacitycab.mega_city_cab.dao.CarDAO;
import com.megacitycab.mega_city_cab.model.Car;
import com.megacitycab.mega_city_cab.model.Customer;
import com.megacitycab.mega_city_cab.model.Driver;

import java.util.List;

public class CarService {
    private final CarDAO carDAO;

    public CarService() {
        this.carDAO = new CarDAO();
    }

    public boolean addCar(Car car) {
        return carDAO.addCar(car);
    }

    public boolean updateCar(Car car) {
        return carDAO.updateCar(car);
    }

    public boolean deleteCar(int carID) {
        return carDAO.deleteCar(carID);
    }

    public List<Car> getAllCars() {
        return carDAO.getAllCars();
    }

}
