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

    // SQL Queries
    private static final String INSERT_CUSTOMER_SQL = "INSERT INTO customers (name, address, nic, phoneNumber) VALUES (?, ?, ?, ?)";
    private static final String SELECT_ALL_CUSTOMERS_SQL = "SELECT * FROM customers";

    public boolean insertCustomer(Customer customer) {
        boolean rowInserted = false;
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER_SQL)) {
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getAddress());
            preparedStatement.setString(3, customer.getNic());
            preparedStatement.setString(4, customer.getPhoneNumber());

            rowInserted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowInserted;
    }

    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        System.out.println("Executing: SELECT * FROM customers");

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMERS_SQL);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setCustomerID(resultSet.getInt("customerID"));
                customer.setName(resultSet.getString("name"));
                customer.setAddress(resultSet.getString("address"));
                customer.setNic(resultSet.getString("NIC"));
                customer.setPhoneNumber(resultSet.getString("phoneNumber"));
                customers.add(customer);
            }

            System.out.println("Total customers retrieved: " + customers.size());

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }
}
