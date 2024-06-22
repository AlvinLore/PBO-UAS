/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author ASUS
 */
public class DatabaseLogin {
    private static final String URL = "jdbc:sqlite:D:/PBO/PBO UAS/Database/db_pergantian_ruangan";
    
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL);
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database", e);
        }
    }
    public boolean verifyIdentity(String username, char[] password) {
        String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
        try (Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, username);
            statement.setString(2, new String(password));
            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next(); // Returns true if a matching record is found
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean verifyRole(String username, char[] password, String role) {
        String sql = "SELECT * FROM user WHERE username = ? AND password = ? AND role = ?";
        try (Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, username);
            statement.setString(2, new String(password));
            statement.setString(3, role);
            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next(); // Returns true if a matching record is found
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
