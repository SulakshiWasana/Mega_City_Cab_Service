package com.megacitycab.mega_city_cab.service;

import com.megacitycab.mega_city_cab.dao.CustomerDAO;
import com.megacitycab.mega_city_cab.model.Customer;

import java.util.List;

public class CustomerService {
    private CustomerDAO customerDAO;

    public CustomerService() {
        this.customerDAO = new CustomerDAO();
    }

    public boolean registerCustomer(Customer customer) {
        return customerDAO.insertCustomer(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerDAO.getAllCustomers();
    }
}
