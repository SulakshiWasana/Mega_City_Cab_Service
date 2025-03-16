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

public class DriverDAO {
    private static final String INSERT_DRIVER_SQL = "INSERT INTO drivers (name, licenseNumber, contactNumber) VALUES (?, ?, ?)";
    private static final String UPDATE_DRIVER_SQL = "UPDATE drivers SET name = ?, licenseNumber = ?, contactNumber = ? WHERE driverID = ?";
    private static final String DELETE_DRIVER_SQL = "DELETE FROM drivers WHERE driverID = ?";
    private static final String SELECT_ALL_DRIVERS_SQL = "SELECT * FROM drivers";

    public boolean addDriver(Driver driver) {
        try (Connection connection = dbConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_DRIVER_SQL)) {
            preparedStatement.setString(1, driver.getName());
            preparedStatement.setString(2, driver.getLicenseNumber());
            preparedStatement.setString(3, driver.getContactNumber());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateDriver(Driver driver) {
        try (Connection connection = dbConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_DRIVER_SQL)) {
            preparedStatement.setString(1, driver.getName());
            preparedStatement.setString(2, driver.getLicenseNumber());
            preparedStatement.setString(3, driver.getContactNumber());
            preparedStatement.setInt(4, driver.getDriverID());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteDriver(int driverID) {
        try (Connection connection = dbConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_DRIVER_SQL)) {
            preparedStatement.setInt(1, driverID);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static List<Driver> getAllDrivers() {
        List<Driver> drivers = new ArrayList<>();
        try (Connection connection = dbConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DRIVERS_SQL);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Driver driver = new Driver();
                driver.setDriverID(resultSet.getInt("driverID"));
                driver.setName(resultSet.getString("name"));
                driver.setLicenseNumber(resultSet.getString("licenseNumber"));
                driver.setContactNumber(resultSet.getString("contactNumber"));
                drivers.add(driver);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return drivers;
    }
}
