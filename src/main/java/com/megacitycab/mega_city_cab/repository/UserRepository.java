package com.megacitycab.mega_city_cab.repository;

import com.megacitycab.mega_city_cab.model.User;

import java.sql.SQLException;

public interface UserRepository {
    User findByUsername(String username);

}
