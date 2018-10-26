/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test24oktober2018;

import java.io.File;
import java.util.ArrayList;
import model.Pasien;
import model.RumahSakit;

/**
 *
 * @author admin
 */
public class TestRumahSakit2 {
    public static void main(String[] args) {
        RumahSakit rs = new RumahSakit();
        
        rs.BacaObjekRumahSakit(new File("rsku.dat"));
        System.out.println("Nama RS = "+rs.getNama());
        ArrayList<Pasien> daftar = rs.getDaftarPasien();
        for (int i = 0; i < daftar.size(); i++) {
            System.out.println("Pasien = "+daftar.get(i).toString());
        }
                     
    }
}
