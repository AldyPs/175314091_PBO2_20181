/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelUniversitas;

import java.util.ArrayList;

/**
 *
 * @author Aldy
 */
public class Universitas {
 private String nama;
 public static ArrayList<ProgramStudi> daftarProdi = new ArrayList<ProgramStudi>();

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public ArrayList<ProgramStudi> getDaftarProdi() {
        return daftarProdi;
    }

    public void setDaftarProdi(ArrayList<ProgramStudi> daftarProdi) {
        this.daftarProdi = daftarProdi;
    }
    
    public static int cariProgramStudi(String nama){
        for (int i = 0; i < daftarProdi.size(); i++) {
            if (nama.equalsIgnoreCase(daftarProdi.get(i).getNama())) {
                return i;
            }
        }
        return -1;
    }
}
