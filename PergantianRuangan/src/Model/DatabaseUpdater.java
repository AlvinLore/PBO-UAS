/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author ASUS
 */
public class DatabaseUpdater {
    public void updatePermintaan(Pertemuan pertemuan) {
        String sql = "UPDATE pertemuan SET ruang = ?, tanggal = ?, sesi = ?, jam_mulai = ?, menit_mulai = ?, pengganti = ? WHERE id = ?";
        try (Connection conn = DatabaseLogin.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, pertemuan.getRuang());
            pstmt.setString(2, formatDate(pertemuan.getTanggal()));
            pstmt.setInt(3, pertemuan.getSesi());
            pstmt.setInt(4, pertemuan.getWaktuMulai().getJam());
            pstmt.setInt(5, pertemuan.getWaktuMulai().getMenit());
            pstmt.setString(6, pertemuan.getPengganti());
            pstmt.setInt(7, pertemuan.getId());
            pstmt.executeUpdate();
            System.out.println("Data berhasil diperbarui di database.");
        } catch (SQLException e) {
            System.out.println("Error updating data: " + e.getMessage());
        }
    }
    
    public static String formatDate(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return date.format(formatter);
    }
}
