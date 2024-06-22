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
public class Permintaan {
    private int id;
    private LocalDate tanggalSebelum;
    private LocalDate tanggalSesudah;
    private int sesiSebelum;
    private int sesiSesudah;
    private Waktu waktuMulai;
    
    public Permintaan() {
        
    }
    
    public Permintaan(int id, LocalDate tanggalSebelum, LocalDate tanggalSesudah, int sesiSebelum, int sesiSesudah, Waktu waktuMulai) {
        this.id = id;
        this.tanggalSebelum = tanggalSebelum;
        this.tanggalSesudah = tanggalSesudah;
        this.sesiSebelum= sesiSebelum;
        this.sesiSesudah = sesiSesudah;
        this.waktuMulai = waktuMulai;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public LocalDate getTanggalSebelum() {
        return tanggalSebelum;
    }
    
    public void setTanggalSebelum(LocalDate tanggalSebelum) {
        this.tanggalSebelum = tanggalSebelum;
    }
    
    public LocalDate getTanggalSesudah() {
        return tanggalSesudah;
    }
    
    public void setTanggalSesudah(LocalDate tanggalSesudah) {
        this.tanggalSesudah = tanggalSesudah;
    }
    
    public int getSesiSebelum() {
        return sesiSebelum;
    }
    
    public void setSesiSebelum(int sesiSebelum) {
        this.sesiSebelum = sesiSebelum;
    }
    
    public int getSesiSesudah() {
        return sesiSesudah;
    }
    
    public void setSesiSesudah(int sesiSesudah) {
        this.sesiSesudah = sesiSesudah;
    }
    
    public Waktu getWaktuMulai() {
        return waktuMulai;
    }
    
    public void setWaktuMulai(Waktu waktuMulai) {
        this.waktuMulai = waktuMulai;
    }
}
