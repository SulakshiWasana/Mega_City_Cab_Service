package com.megacitycab.mega_city_cab.dao;

import com.megacitycab.mega_city_cab.database.dbConnection;
import com.megacitycab.mega_city_cab.model.Car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CarDAO {
    private static final String INSERT_CAR_SQL = "INSERT INTO cars (model, licensePlate, availability) VALUES (?, ?, ?)";

    public boolean insertCar(Car car) {
        boolean rowInserted = false;
        try (Connection connection = dbConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CAR_SQL)) {
            preparedStatement.setString(1, car.getModel());
            preparedStatement.setString(2, car.getLicensePlate());
            preparedStatement.setString(3, car.getAvailability());

            rowInserted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowInserted;
    }
}
