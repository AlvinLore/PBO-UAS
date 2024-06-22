/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.DatabaseRetriever;
import Model.Permintaan;
import Model.Pertemuan;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author ASUS
 */
public class FormController extends Form{
    private Pertemuan pertemuan;
    private Permintaan permintaan;
    
    public FormController() {
        
    }
    
    public FormController(Pertemuan pertemuan, Permintaan permintaan) {
        this.pertemuan = pertemuan;
        this.permintaan = permintaan;
    }
    
    public FormController(Permintaan permintaan) {
        this.permintaan = permintaan;
    }
    
    public Permintaan getPermintaan() {
        return permintaan;
    }
    
    public void setPermintaan(Permintaan permintaan) {
        this.permintaan = permintaan;
    }
    
    public FormController(Pertemuan pertemuan) {
        this.pertemuan = pertemuan;
    }
    
    public Pertemuan getPertemuan() {
        return pertemuan;
    }
    
    public void setPertemuan(Pertemuan pertemuan) {
        this.pertemuan = pertemuan;
    }
    
    @Override
    public boolean validatePermintaan() {
        if (permintaan == null) {
            super.addErrorMessages("Permintaan tidak ditemukan.");
            return false;
        }
        switch (permintaan.getSesiSesudah()) {
            case 1:
                if (permintaan.getWaktuMulai().getJam() < 7 || (permintaan.getWaktuMulai().getJam() == 10 && permintaan.getWaktuMulai().getMenit() > 0) || permintaan.getWaktuMulai().getJam() > 10) {
                    super.addErrorMessages("Sesi 1 hanya berlangsung dari pukul 7 sampai 10 WIB.");
                }
                break;
            case 2:
                if (permintaan.getWaktuMulai().getJam() < 10 || (permintaan.getWaktuMulai().getJam() == 13 && permintaan.getWaktuMulai().getMenit() > 0) || permintaan.getWaktuMulai().getJam() > 13) {
                    super.addErrorMessages("Sesi 2 hanya berlangsung dari pukul 10 sampai 13 WIB.");
                }
                break;
            case 3:
                if (permintaan.getWaktuMulai().getJam() < 13 || (permintaan.getWaktuMulai().getJam() == 16 && permintaan.getWaktuMulai().getMenit() > 0) || permintaan.getWaktuMulai().getJam() > 16) {
                    super.addErrorMessages("Sesi 3 hanya berlangsung dari pukul 13 sampai 16 WIB.");
                }
                break;
            case 4:
                if (permintaan.getWaktuMulai().getJam() < 16 || (permintaan.getWaktuMulai().getJam() == 18 && permintaan.getWaktuMulai().getMenit() > 0) || permintaan.getWaktuMulai().getJam() > 18) {
                    super.addErrorMessages("Sesi 4 hanya berlangsung dari pukul 16 sampai 18 WIB.");
                }
                break;
            default:
                super.addErrorMessages("Hanya terdapat sesi 1,2,3, dan 4.");
                break;
        }
        if (LocalDate.now().isAfter(permintaan.getTanggalSesudah())) {
            super.addErrorMessages("Tanggal pergantian pertemuan harus lebih dari tanggal hari ini");
        }
        return super.getErrorMessages().isEmpty();
    }
    
    @Override
    public boolean validateUpdatePertemuan() {
        if (pertemuan == null) {
            super.addErrorMessages("Pertemuan tidak ditemukan.");
            return false;
        }
        
        DatabaseRetriever databaseRetriever = new DatabaseRetriever();
        Pertemuan existingPertemuan = databaseRetriever.retrievePertemuanByTanggalSesiRuang(pertemuan.getTanggal(), pertemuan.getSesi(), pertemuan.getRuang());

        if (existingPertemuan != null && existingPertemuan.getId() != pertemuan.getId()) {
            super.addErrorMessages("Ruangan ini sudah digunakan untuk pertemuan lain pada tanggal dan sesi yang sama.");
        }
        Set<String> validRuang = new HashSet<>(Arrays.asList("221", "222", "241", "242", "243", "244", "245", "246", "247", 
                                                         "251", "252", "253", "254", "255", "256", "257", 
                                                         "261", "262", "263", "264", "265", "266", "267", 
                                                         "321", "322", "323", "324", "325", "326", "327", "328", 
                                                         "331", "332", "333", "334", "335", "336", "337", "338", 
                                                         "341", "342", "343", "344", "345", "346", "347", "348"));
        if (!validRuang.contains(pertemuan.getRuang())) {
            super.addErrorMessages("Tolong input nomor ruangan yang valid yaitu 241-247, 251-257, 261-267, 321-328, 331-338, 341-348");
        }
        return super.getErrorMessages().isEmpty();
    }
}
