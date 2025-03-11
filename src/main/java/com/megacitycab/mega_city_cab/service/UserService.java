package com.megacitycab.mega_city_cab.service;

import com.megacitycab.mega_city_cab.model.User;
import com.megacitycab.mega_city_cab.repository.UserRepository;

public class UserService {
    private UserRepository userRepository = new UserRepository();

    public User authenticate(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }
}
