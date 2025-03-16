package com.megacitycab.mega_city_cab.dao;

import com.megacitycab.mega_city_cab.database.dbConnection;
import com.megacitycab.mega_city_cab.model.Customer;
import com.megacitycab.mega_city_cab.model.Driver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
    private static final String INSERT_CUSTOMER_SQL = "INSERT INTO customers (name, address, nic, phoneNumber) VALUES (?, ?, ?, ?)";
    private static final String UPDATE_CUSTOMER_SQL = "UPDATE customers SET name = ?, address = ?, nic = ?, phoneNumber = ? WHERE customerID = ?";
    private static final String DELETE_CUSTOMER_SQL = "DELETE FROM customers WHERE customerID = ?";
    private static final String SELECT_ALL_CUSTOMERS_SQL = "SELECT * FROM customers";

    public boolean addCustomer(Customer customer) {
        try (Connection connection = dbConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER_SQL)) {
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getAddress());
            preparedStatement.setString(3, customer.getNic());
            preparedStatement.setString(4, customer.getPhoneNumber());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateCustomer(Customer customer) {
        try (Connection connection = dbConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER_SQL)) {
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getAddress());
            preparedStatement.setString(3, customer.getNic());
            preparedStatement.setString(4, customer.getPhoneNumber());
            preparedStatement.setInt(5, customer.getCustomerID());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteCustomer(int customerID) {
        try (Connection connection = dbConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CUSTOMER_SQL)) {
            preparedStatement.setInt(1, customerID);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        try (Connection connection = dbConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMERS_SQL);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setCustomerID(resultSet.getInt("customerID"));
                customer.setName(resultSet.getString("name"));
                customer.setAddress(resultSet.getString("address"));
                customer.setNic(resultSet.getString("nic"));
                customer.setPhoneNumber(resultSet.getString("phoneNumber"));
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }
}
