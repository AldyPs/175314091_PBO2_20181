/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelUniversitas;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Aldy
 */
public class ProgramStudi {
    private String kode;
    private String nama;
    private ArrayList<CalonMahasiswa>daftarCalonMahasiswa= new ArrayList<CalonMahasiswa>();

    public ProgramStudi(String kode, String nama) {
        this.kode = kode;
        this.nama = nama;
    }

    public ProgramStudi() {
    }
    

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
    
    public int cariCalonMahasiswa(String nomorNIK){
        for (int i = 0; i < daftarCalonMahasiswa.size(); i++) {
            if (nomorNIK.equalsIgnoreCase(daftarCalonMahasiswa.get(i).getNomorNIK())) {
                return i;
            }
        }
        return -1;
    }
    
    public void mendaftar(CalonMahasiswa calon){
        if (cariCalonMahasiswa(calon.getNomorNIK()) == -1) {
            daftarCalonMahasiswa.add(calon);
        }else{
            JOptionPane.showMessageDialog(null, "Calon Mahasiswa sudah ada");
        }
    }
}
