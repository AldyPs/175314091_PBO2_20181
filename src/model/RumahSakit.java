/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Test17okt2018.TestStreaming1;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static model.AntrianPasien.daftarAntrian;
import static model.Klinik.daftarKlinik;
import static model.Pasien.daftarPasien;

/**
 *
 * @author jarkom
 */
public class RumahSakit implements Serializable{
    private String alamat;
    private String nama;
    private ArrayList<Klinik> daftarKlinik= new ArrayList<Klinik>();
    private ArrayList<Pasien> daftarPasien = new ArrayList<Pasien>();
    
    
    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public RumahSakit() {
    }

    public RumahSakit(String nama,String alamat) {
        this.alamat = alamat;
        this.nama = nama;
    }
    
    public  void tambahPasienBaru(Pasien pasien) {
        daftarPasien.add(pasien);

    }
    
    public  ArrayList<Pasien> getDaftarPasien() {
        return daftarPasien;
    }

    public  void setDaftarPasien(ArrayList<Pasien> daftarPasien) {
        Pasien.daftarPasien = daftarPasien;
    }
    
    public  ArrayList<Klinik> getDaftarKlinik(){
        return daftarKlinik;
    }
    
    public  void setDaftarKLinik(ArrayList<Klinik> daftarKlinik) {
        Klinik.daftarKlinik = daftarKlinik;
    }

    public  Pasien cariPasien(String rekamMedis) {

        for (int i = 0; i < daftarPasien.size(); i++) {
            if (daftarPasien.get(i).getNoRM()== null ? rekamMedis == null : daftarPasien.get(i).getNoRM().equals(rekamMedis)) {
                return daftarPasien.get(i);
            }
        }

        return null;
    }
    
    public  void simpanDaftarPasien(File file) {
        try {
            FileOutputStream fos = new FileOutputStream(file);
            for (int i = 0; i < daftarPasien.size(); i++) {
                String data = daftarPasien.get(i).toString();
                fos.write(data.getBytes());
            }
            fos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Pasien.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Pasien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public  void bacaDaftarPasien(File file) {
        FileInputStream fis = null;
        boolean alamat = false;
        boolean nama = false;
        boolean noRM = false;
        try {
            fis = new FileInputStream(file);
            int dataInt;
            String hasilBaca = "";
            Pasien temp = new Pasien();
            while ((dataInt = fis.read()) != -1) {
                if ((char) dataInt != '\t') {
                    if ((char) dataInt != '\t') {
                        if ((char) dataInt != '\n') {
                            hasilBaca = hasilBaca + (char) dataInt;
                        } else if (alamat = false) {
                            temp.setAlamat(hasilBaca);
                            alamat = true;
                            hasilBaca = "";
                        }
                    } else if (nama = false) {
                        temp.setNama(hasilBaca);
                        nama = true;
                        hasilBaca = "";
                    }
                } else if (noRM = false) {
                    temp.setNoRM(hasilBaca);
                    noRM = true;
                    hasilBaca = "";
                }

            }
            System.out.println(hasilBaca);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TestStreaming1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TestStreaming1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public  void SimpanObjekRumahSakit(File file) {
        
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RumahSakit.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RumahSakit.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public  void BacaObjekRumahSakit(File file){
        try {
            FileInputStream fish = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fish);
            RumahSakit rs = (RumahSakit)ois.readObject();
            this.nama = rs.nama;
            this.alamat = rs.alamat;
            this.daftarKlinik = rs.daftarKlinik;
            this.daftarPasien = rs.daftarPasien;
//            this.setNama(rs.getNama());
//            this.setAlamat(rs.getAlamat());
//            this.setDaftarKLinik(rs.getDaftarKlinik());
//            this.setDaftarPasien(rs.getDaftarPasien());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RumahSakit.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RumahSakit.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RumahSakit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public  void tambahKlinik(Klinik klinik){
        daftarKlinik.add(klinik);
    }
    
    public  Klinik cariKlinik(String namaKlinik){
        for (int i = 0; i < daftarKlinik.size(); i++) {
            if(daftarKlinik.get(i).
                    getNama().equalsIgnoreCase(namaKlinik))
            {
                return daftarKlinik.get(i);
            }
        }
        return null;
    }
    
    /**method ini berfungsi untuk mencari antrian pasien yang sudah terdaftar
     * 
     * @param tanggal
     * @param bulan
     * @param tahun
     * @param klinik
     * @return 
     */
    public  int cariAntrian(int tanggal, int bulan, int tahun, Klinik klinik) {
        for (int i = 0; i < daftarAntrian.size(); i++) {
            if (daftarAntrian.get(i).tanggalAntrian == tanggal) {
                if (daftarAntrian.get(i).bulanAntrian == bulan) {
                    if (daftarAntrian.get(i).tahunAntrian == tahun) {
                        if (daftarAntrian.get(i).getKlinik().getIdKlinik().equalsIgnoreCase(klinik.getIdKlinik())) {
                            if (daftarAntrian.get(i).getKlinik().getNama().equalsIgnoreCase(klinik.getNama())) {
                                return i;
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }

    /**method ini berfungsi untuk membuat antrian pasien dari data daftarPasien
     * 
     * @param tanggal
     * @param bulan
     * @param tahun
     * @param klinik 
     */
    public  void buatAntrian(int tanggal,int bulan,int tahun,Klinik klinik) {
        AntrianPasien antrian = new AntrianPasien();
        antrian.setTanggalAntrian(tanggal);
        antrian.setBulanAntrian(bulan);
        antrian.setTahunAntrian(tahun);
        antrian.setKlinik(klinik);
        // cari antrian dalam list daftarAntri
        if (cariAntrian(tanggal, bulan, tahun, klinik) == -1) {
            // tambah dalam list antrian
            daftarAntrian.add(antrian);
        } else {
            JOptionPane.showMessageDialog(null, "Antrian telah terdaftar");
        }
    }
    /**method ini berfungsi untuk mendaftarkan pasien sehingga dapat masuk ke antrian
     * 
     * @param pasien
     * @param tanggal
     * @param bulan
     * @param tahun
     * @param klinik 
     */
    public  void daftarPasien(Pasien pasien, int tanggal, int bulan, int tahun, Klinik klinik) {
        if (cariAntrian(tanggal, bulan, tahun, klinik) >= 0) {
            daftarAntrian.get(cariAntrian(tanggal, bulan, tahun, klinik)).mendaftar(pasien);
        }else{
            buatAntrian(tanggal, bulan, tahun, klinik);
            daftarAntrian.get(cariAntrian(tanggal, bulan, tahun, klinik)).mendaftar(pasien);
        }
    }
}
