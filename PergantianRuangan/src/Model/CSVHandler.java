/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class CSVHandler {
    public boolean WriteCSV(String path, List<Pertemuan> pertemuanList){
        String header = "id, mata_kuliah, kelas, tanggal, sesi, jam_mulai, menit_mulai, ruang, pengganti";
        
        try(FileWriter fileWriter = new FileWriter(path + "\\output.csv");
            PrintWriter printWriter = new PrintWriter(fileWriter)) {
            //Buat header
            printWriter.println(header);

            for (Pertemuan pertemuan : pertemuanList) {
                List<String> row = new ArrayList<>();
                row.add(String.valueOf(pertemuan.getId()));
                row.add(pertemuan.getMataKuliah());
                row.add(pertemuan.getKelas());
                row.add(pertemuan.getTanggal().toString());
                row.add(String.valueOf(pertemuan.getSesi()));
                row.add(String.valueOf(pertemuan.getWaktuMulai().getJam()));
                row.add(String.valueOf(pertemuan.getWaktuMulai().getMenit()));
                row.add(pertemuan.getRuang());
                row.add(pertemuan.getPengganti());
                
                //Tulis ke file csv
                printWriter.println(String.join(",", row));
            }
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }

        return true;
    }
}
