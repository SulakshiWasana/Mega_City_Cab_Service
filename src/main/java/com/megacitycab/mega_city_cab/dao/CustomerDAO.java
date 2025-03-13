package com.megacitycab.mega_city_cab.dao;

import com.megacitycab.mega_city_cab.database.dbConnection;
import com.megacitycab.mega_city_cab.model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {

    // SQL Queries
    private static final String INSERT_CUSTOMER_SQL = "INSERT INTO customers (name, address, nic, phoneNumber) VALUES (?, ?, ?, ?)";
    private static final String SELECT_ALL_CUSTOMERS_SQL = "SELECT * FROM customers ORDER BY CustomerID ASC";

    /**
     * Inserts a new customer into the database.
     *
     * @param customer The customer to insert.
     * @return True if the insertion was successful, false otherwise.
     */
    public boolean insertCustomer(Customer customer) {
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER_SQL)) {

            setCustomerPreparedStatement(preparedStatement, customer);
            return preparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            handleSQLException(e);
            return false;
        }
    }

    /**
     * Retrieves all customers from the database, sorted by CustomerID in ascending order.
     *
     * @return A list of customers.
     */
    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMERS_SQL);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Customer customer = mapResultSetToCustomer(resultSet);
                customers.add(customer);
            }

        } catch (SQLException e) {
            handleSQLException(e);
        }

        return customers;
    }

    /**
     * Maps a ResultSet row to a Customer object.
     *
     * @param resultSet The ResultSet containing customer data.
     * @return A Customer object.
     * @throws SQLException If a database access error occurs.
     */
    private Customer mapResultSetToCustomer(ResultSet resultSet) throws SQLException {
        Customer customer = new Customer();
        customer.setCustomerID(resultSet.getInt("CustomerID"));
        customer.setName(resultSet.getString("name"));
        customer.setAddress(resultSet.getString("address"));
        customer.setNic(resultSet.getString("nic"));
        customer.setPhoneNumber(resultSet.getString("phoneNumber"));
        return customer;
    }

    /**
     * Sets the values of a PreparedStatement for inserting a customer.
     *
     * @param preparedStatement The PreparedStatement to set values for.
     * @param customer The customer object containing the values.
     * @throws SQLException If a database access error occurs.
     */
    private void setCustomerPreparedStatement(PreparedStatement preparedStatement, Customer customer) throws SQLException {
        preparedStatement.setString(1, customer.getName());
        preparedStatement.setString(2, customer.getAddress());
        preparedStatement.setString(3, customer.getNic());
        preparedStatement.setString(4, customer.getPhoneNumber());
    }

    /**
     * Handles SQL exceptions by logging the error.
     *
     * @param e The SQLException to handle.
     */
    private void handleSQLException(SQLException e) {
        e.printStackTrace(); // Replace with a proper logging mechanism (e.g., Log4j, SLF4J)
    }
}
