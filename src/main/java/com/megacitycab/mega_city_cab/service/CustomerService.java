package com.megacitycab.mega_city_cab.service;

import com.megacitycab.mega_city_cab.dao.CustomerDAO;
import com.megacitycab.mega_city_cab.model.Customer;

import java.sql.SQLException;
import java.util.List;

public class CustomerService {
    private final CustomerDAO customerDAO;

    public CustomerService() {
        this.customerDAO = new CustomerDAO();
    }

    public boolean addCustomer(Customer customer) {
        return customerDAO.addCustomer(customer);
    }

    public boolean updateCustomer(Customer customer) {
        return customerDAO.updateCustomer(customer);
    }

    public boolean deleteCustomer(int customerID) {
        return customerDAO.deleteCustomer(customerID);
    }

    public List<Customer> getAllCustomers() {
        return customerDAO.getAllCustomers();
    }
}
