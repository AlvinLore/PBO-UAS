/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public class DatabaseDeleter {
    public void deleteDataPermintaan(int id) {
        String sql = "DELETE FROM permintaan WHERE id = ?";

        try (Connection conn = DatabaseLogin.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            int rowsAffected = pstmt.executeUpdate();
            
            if (rowsAffected > 0) {
                System.out.println("Permintaan dengan ID " + id + " berhasil dihapus.");
            } else {
                System.out.println("Permintaan dengan ID " + id + "tidak ditemukan.");
            }

        } catch (SQLException e) {
            System.out.println("Error deleting data: " + e.getMessage());
        }
    }
}
