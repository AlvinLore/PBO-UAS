/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.LocalDate;



/**
 *
 * @author ASUS
 */
public class Pertemuan {
    private int id;
    private String mataKuliah;
    private String kelas;
    private LocalDate tanggal;
    private int sesi;
    private Waktu waktuMulai;
    private String ruang;
    private String pengganti;
    
    public Pertemuan() {
        
    }
    
    public Pertemuan(int id, String mataKuliah,String kelas, LocalDate tanggal, int sesi, Waktu waktuMulai, String ruang, String pengganti) {
        this.id = id;
        this.mataKuliah = mataKuliah;
        this.kelas = kelas;
        this.tanggal = tanggal;
        this.sesi = sesi;
        this.waktuMulai = waktuMulai;
        this.ruang = ruang;
        this.pengganti = pengganti;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getMataKuliah() {
        return mataKuliah;
    }
    
    public void setMataKuliah(String mataKuliah) {
        this.mataKuliah = mataKuliah;
    }
    
    public String getKelas() {
        return kelas;
    }
    
    public void setKelas(String kelas) {
        this.kelas = kelas;
    }
    
    public LocalDate getTanggal() {
        return tanggal;
    }
    
    public void setTanggal(LocalDate tanggal) {
        this.tanggal = tanggal;
    }
    
    public int getSesi() {
        return sesi;
    }
    
    public void setSesi(int sesi) {
        this.sesi = sesi;
    }
    
    public Waktu getWaktuMulai() {
        return waktuMulai;
    }
    
    public void setWaktuMulai(Waktu waktuMulai) {
        this.waktuMulai = waktuMulai;
    }
    
    public String getRuang() {
        return ruang;
    }
    
    public void setRuang(String ruang) {
        this.ruang = ruang;
    }
    
    public String getPengganti() {
        return pengganti;
    }
    
    public void setPengganti(String pengganti) {
        this.pengganti = pengganti;
    }
}
