package com.megacitycab.mega_city_cab.dao;

import com.megacitycab.mega_city_cab.database.dbConnection;
import com.megacitycab.mega_city_cab.model.Car;
import com.megacitycab.mega_city_cab.model.Customer;
import com.megacitycab.mega_city_cab.model.Driver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDAO {
    private static final String INSERT_CAR_SQL = "INSERT INTO cars (model, licensePlate, availability) VALUES (?, ?, ?)";
    private static final String UPDATE_CAR_SQL = "UPDATE cars SET model = ?, licensePlate = ?, availability = ? WHERE carID = ?";
    private static final String DELETE_CAR_SQL = "DELETE FROM cars WHERE carID = ?";
    private static final String SELECT_ALL_CARS_SQL = "SELECT * FROM cars";

    public boolean addCar(Car car) {
        try (Connection connection = dbConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CAR_SQL)) {
            preparedStatement.setString(1, car.getModel());
            preparedStatement.setString(2, car.getLicensePlate());
            preparedStatement.setString(3, car.getAvailability());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateCar(Car car) {
        try (Connection connection = dbConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CAR_SQL)) {
            preparedStatement.setString(1, car.getModel());
            preparedStatement.setString(2, car.getLicensePlate());
            preparedStatement.setString(3, car.getAvailability());
            preparedStatement.setInt(4, car.getCarID());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteCar(int carID) {
        try (Connection connection = dbConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CAR_SQL)) {
            preparedStatement.setInt(1, carID);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static List<Car> getAllCars() {
        List<Car> cars = new ArrayList<>();
        try (Connection connection = dbConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CARS_SQL);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Car car = new Car();
                car.setCarID(resultSet.getInt("carID"));
                car.setModel(resultSet.getString("model"));
                car.setLicensePlate(resultSet.getString("licensePlate"));
                car.setAvailability(resultSet.getString("availability"));
                cars.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }
}
