/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class DatabaseRetriever {
    public Pertemuan retrieveDataPertemuan(int id) {
        Pertemuan pertemuan = new Pertemuan();

        String sql = "SELECT * FROM pertemuan WHERE id = ?";

        try (Connection conn = DatabaseLogin.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                pertemuan.setId(rs.getInt("id"));
                pertemuan.setMataKuliah(rs.getString("mata_kuliah"));
                pertemuan.setKelas(rs.getString("kelas"));
                LocalDate tanggal = rs.getObject("tanggal", LocalDate.class);
                pertemuan.setTanggal(tanggal);
                pertemuan.setSesi(rs.getInt("sesi"));
                pertemuan.setWaktuMulai(new Waktu(rs.getInt("jam_mulai"), rs.getInt("menit_mulai")));
                pertemuan.setRuang(rs.getString("ruang"));
                pertemuan.setPengganti(rs.getString("pengganti"));
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving data: " + e.getMessage());
        }
        return pertemuan;
    }
    public List<Pertemuan> retrieveAllDataPertemuan() {
        List<Pertemuan> listPertemuan = new ArrayList<>();

        String sql = "SELECT * FROM pertemuan";

        try (Connection conn = DatabaseLogin.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Pertemuan pertemuan = new Pertemuan();
                pertemuan.setId(rs.getInt("id"));
                pertemuan.setMataKuliah(rs.getString("mata_kuliah"));
                pertemuan.setKelas(rs.getString("kelas"));
                LocalDate tanggal = rs.getObject("tanggal", LocalDate.class);
                pertemuan.setTanggal(tanggal);
                pertemuan.setSesi(rs.getInt("sesi"));
                pertemuan.setWaktuMulai(new Waktu(rs.getInt("jam_mulai"), rs.getInt("menit_mulai")));
                pertemuan.setRuang(rs.getString("ruang"));
                pertemuan.setPengganti(rs.getString("pengganti"));
                listPertemuan.add(pertemuan);
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving data: " + e.getMessage());
        }
        return listPertemuan;
    }
    
    public List<Pertemuan> retrieveFilteredPertemuan(LocalDate sqlTanggal, int sesi) {
        String sql = "SELECT * FROM pertemuan WHERE tanggal = ? AND sesi = ?";
        List<Pertemuan> listPertemuan = new ArrayList<>();

        try (Connection conn = DatabaseLogin.getConnection();
            PreparedStatement pstmt  = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, sqlTanggal.toString());
            pstmt.setInt(2, sesi);
            ResultSet rs  = pstmt.executeQuery();

            while (rs.next()) {
                Pertemuan pertemuan = new Pertemuan();
                pertemuan.setId(rs.getInt("id"));
                pertemuan.setMataKuliah(rs.getString("mata_kuliah"));
                pertemuan.setKelas(rs.getString("kelas"));
                LocalDate tanggal = rs.getObject("tanggal", LocalDate.class);
                pertemuan.setTanggal(tanggal);
                pertemuan.setSesi(rs.getInt("sesi"));
                pertemuan.setWaktuMulai(new Waktu(rs.getInt("jam_mulai"), rs.getInt("menit_mulai")));
                pertemuan.setRuang(rs.getString("ruang"));
                pertemuan.setPengganti(rs.getString("pengganti"));
                listPertemuan.add(pertemuan);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving filtered data: " + e.getMessage());
        }
        return listPertemuan;
    }
    
    public Permintaan retrieveDataPermintaan(int id) {
        Permintaan permintaan = new Permintaan();
        String sql = "SELECT * FROM permintaan WHERE id = ?";

        try (Connection conn = DatabaseLogin.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                permintaan.setId(rs.getInt("id"));
                LocalDate tanggalSebelum = rs.getObject("tanggal_sebelum", LocalDate.class);
                permintaan.setTanggalSebelum(tanggalSebelum);
                LocalDate tanggalSesudah = rs.getObject("tanggal_sesudah", LocalDate.class);
                permintaan.setTanggalSesudah(tanggalSesudah);
                permintaan.setSesiSebelum(rs.getInt("sesi_sebelum"));
                permintaan.setSesiSesudah(rs.getInt("sesi_sesudah"));
                permintaan.setWaktuMulai(new Waktu(rs.getInt("jam_mulai"), rs.getInt("menit_mulai")));
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving data: " + e.getMessage());
        }
        return permintaan;
    }
    
    public List<Permintaan> retrieveAllDataPermintaan() {
        List<Permintaan> listPermintaan = new ArrayList<>();

        String sql = "SELECT * FROM permintaan";

        try (Connection conn = DatabaseLogin.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Permintaan permintaan = new Permintaan();
                permintaan.setId(rs.getInt("id"));
                LocalDate tanggalSebelum = rs.getObject("tanggal_sebelum", LocalDate.class);
                permintaan.setTanggalSebelum(tanggalSebelum);
                LocalDate tanggalSesudah = rs.getObject("tanggal_sesudah", LocalDate.class);
                permintaan.setTanggalSesudah(tanggalSesudah);
                permintaan.setSesiSebelum(rs.getInt("sesi_sebelum"));
                permintaan.setSesiSesudah(rs.getInt("sesi_sesudah"));
                permintaan.setWaktuMulai(new Waktu(rs.getInt("jam_mulai"), rs.getInt("menit_mulai")));
                listPermintaan.add(permintaan);
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving data: " + e.getMessage());
        }
        return listPermintaan;
    }
    
    public boolean checkPermintaanExist(int id) {
        String sql = "SELECT 1 FROM permintaan WHERE id = ?";
        boolean exists = false;
        
        try (Connection conn = DatabaseLogin.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            ResultSet rs  = pstmt.executeQuery();
            
            if (rs.next()) {
                exists = true;
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving data for id " + id + ": " + e.getMessage());
        }
        return exists;
    }
    
    public boolean checkPertemuanExist(int id) {
        String sql = "SELECT 1 FROM pertemuan WHERE id = ?";
        boolean exists = false;
        
        try (Connection conn = DatabaseLogin.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            ResultSet rs  = pstmt.executeQuery();
            
            if (rs.next()) {
                exists = true;
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving data for id " + id + ": " + e.getMessage());
        }
        return exists;
    }
    
    public Pertemuan retrievePertemuanByTanggalSesiRuang(LocalDate sqlTanggal, int sesi, String ruang) {
        Pertemuan pertemuan = null;
        String sql = "SELECT * FROM pertemuan WHERE tanggal = ? AND sesi = ? AND ruang = ?";
        
        try (Connection conn = DatabaseLogin.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, sqlTanggal.toString());
            pstmt.setInt(2, sesi);
            pstmt.setString(3, ruang);
            ResultSet rs  = pstmt.executeQuery();
            
            if (rs.next()) {
                pertemuan = new Pertemuan();
                pertemuan.setId(rs.getInt("id"));
                pertemuan.setMataKuliah(rs.getString("mata_kuliah"));
                pertemuan.setKelas(rs.getString("kelas"));
                LocalDate tanggal = rs.getObject("tanggal", LocalDate.class);
                pertemuan.setTanggal(tanggal);
                pertemuan.setSesi(rs.getInt("sesi"));
                pertemuan.setWaktuMulai(new Waktu(rs.getInt("jam_mulai"), rs.getInt("menit_mulai")));
                pertemuan.setRuang(rs.getString("ruang"));
                pertemuan.setPengganti(rs.getString("pengganti"));
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving data: " + e.getMessage());
        }
        return pertemuan;
    }
}
