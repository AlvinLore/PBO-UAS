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
public class DatabaseInserter {
    public boolean insertPermintaan(Permintaan permintaan) {
        Connection connection = null;
        PreparedStatement psPermintaan = null;

        try {
            connection = DatabaseLogin.getConnection();
            connection.setAutoCommit(false);
            
            String query = "INSERT INTO permintaan (id, tanggal_sebelum, tanggal_sesudah, sesi_sebelum, sesi_sesudah, jam_mulai, menit_mulai) VALUES (?, ?, ?, ?, ?, ?, ?)";
            psPermintaan = connection.prepareStatement(query);
            psPermintaan.setInt(1, permintaan.getId()); //id pertemuan
            psPermintaan.setString(2, formatDate(permintaan.getTanggalSebelum()));
            psPermintaan.setString(3, formatDate(permintaan.getTanggalSesudah()));
            psPermintaan.setInt(4, permintaan.getSesiSebelum());
            psPermintaan.setInt(5, permintaan.getSesiSesudah());
            psPermintaan.setInt(6, permintaan.getWaktuMulai().getJam());
            psPermintaan.setInt(7, permintaan.getWaktuMulai().getMenit());
            psPermintaan.executeUpdate();

            connection.commit();
            System.out.println("Data berhasil disimpan ke dalam database.");
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            System.out.println("Terjadi kesalahan saat menyimpan data: " + e.getMessage());
            return false;
        } finally {
            closeResources(connection, psPermintaan);
        }
    }
    
    public static String formatDate(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return date.format(formatter);
    }
    
    private void closeResources(Connection connection, PreparedStatement... psArray) {
        for (PreparedStatement ps : psArray) {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
