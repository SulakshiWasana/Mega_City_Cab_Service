package com.megacitycab.mega_city_cab.dao;

import com.megacitycab.mega_city_cab.database.dbConnection;
import com.megacitycab.mega_city_cab.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    String USER_INSERT_SQL = "INSERT INTO users (username, password, role) VALUES (?, ?, ?)";
    String USER_FETCH_SQL = "SELECT * FROM users WHERE username = ?";



    public boolean registerUser(User user) {
        try (Connection conn = dbConnection.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(USER_INSERT_SQL)) {

            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getRole());

            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public User getUserByUsername(String username,String password) {
        try (Connection conn = dbConnection.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(USER_FETCH_SQL)) {

            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new User(
                        rs.getInt("userID"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("role")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
