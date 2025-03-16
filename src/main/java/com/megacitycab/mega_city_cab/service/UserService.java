package com.megacitycab.mega_city_cab.service;

import com.megacitycab.mega_city_cab.dao.DriverDAO;
import com.megacitycab.mega_city_cab.dao.UserDAO;
import com.megacitycab.mega_city_cab.model.User;
import com.megacitycab.mega_city_cab.repository.UserRepository;

import java.sql.SQLException;

public class UserService {
    private final UserDAO userDAO;

    public UserService() {
        this.userDAO = new UserDAO();
    }

    public boolean registerUser(String username, String password, String role) {
        User user = new User(0, username, password, role);
        return userDAO.registerUser(user);
    }

    public User authenticateUser(String username, String password) {
        return userDAO.getUserByUsername(username, password);
    }
}
