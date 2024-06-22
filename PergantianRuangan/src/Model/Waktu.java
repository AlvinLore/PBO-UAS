/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ASUS
 */
public class Waktu {
    private int jam;
    private int menit;
    
    public Waktu() {
        
    }
    
    public Waktu(int jam, int menit) {
        this.jam = jam;
        this.menit = menit;
    }
    
    public int getJam() {
        return jam;
    }
    
    public void setJam(int jam) {
        this.jam = jam;
    }
    
    public int getMenit() {
        return menit;
    }
    
    public void setMenit(int menit) {
        this.menit = menit;
    }
}
