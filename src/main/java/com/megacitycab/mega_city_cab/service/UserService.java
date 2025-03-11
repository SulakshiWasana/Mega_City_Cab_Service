package com.megacitycab.mega_city_cab.service;

import com.megacitycab.mega_city_cab.model.User;
import com.megacitycab.mega_city_cab.repository.UserRepository;

import java.sql.SQLException;

public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User authenticate(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user; // Return the authenticated user
        }
        return null; // Authentication failed
    }
}
