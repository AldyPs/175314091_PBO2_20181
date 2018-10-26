/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author jarkom
 */
public class AntrianPasien {

     int tanggalAntrian;
     int bulanAntrian;
     int tahunAntrian;
    private Klinik klinik;
    private final int jumlah_maksimal_pasien = 50;
    private Pasien[] daftarPasien = new Pasien[jumlah_maksimal_pasien];
    private int nomorAntrian = 0;
    public static ArrayList<AntrianPasien> daftarAntrian = new ArrayList<AntrianPasien>();
    private static ArrayList<Pasien> daftarPasienAntri = new ArrayList<Pasien>();

    public AntrianPasien() {
    }

    public AntrianPasien(int tanggalAntrian, int bulanAntrian, int tahunAntrian, Klinik klinik, Pasien[] daftarPasien) {
        this.tanggalAntrian = tanggalAntrian;
        this.bulanAntrian = bulanAntrian;
        this.tahunAntrian = tahunAntrian;
        this.klinik = klinik;
        this.daftarPasien = daftarPasien;
    }

    public int getTanggalAntrian() {
        return tanggalAntrian;
    }

    public void setTanggalAntrian(int tanggalAntrian) {
        this.tanggalAntrian = tanggalAntrian;
    }

    public int getBulanAntrian() {
        return bulanAntrian;
    }

    public void setBulanAntrian(int bulanAntrian) {
        this.bulanAntrian = bulanAntrian;
    }

    public int getTahunAntrian() {
        return tahunAntrian;
    }

    public void setTahunAntrian(int tahunAntrian) {
        this.tahunAntrian = tahunAntrian;
    }

    public Klinik getKlinik() {
        return klinik;
    }

    public void setKlinik(Klinik klinik) {
        this.klinik = klinik;
    }

    public ArrayList<Pasien> getDaftarPasien() {
        return daftarPasienAntri;
    }

    public void setDaftarPasien(Pasien[] daftarPasien) {
        this.daftarPasien = daftarPasien;
    }

    /**
     * fungsi ini digunakan untuk pasien baru di nomor antrian
     *
     * @param pasien
     * @throws Exception
     */
//    public void mendaftar(Pasien pasien) throws Exception {
//
//        //nomor antrian dibandingkan dengan jumlah maksimal pasien yang dilayar
//        if (nomorAntrian < jumlah_maksimal_pasien) {
//            daftarPasien[nomorAntrian] = pasien;
//            nomorAntrian++;
//        } else {
//            //antrian sudah penuh
//            throw new Exception("antrian penuh coyy");
//        }
//    }
    public void mendaftar(Pasien pasien) {
        daftarPasienAntri.add(pasien);
    }

    /**
     * fungsi ini digunakan untuk memanggil antrian pasien yang dilakukan oleh
     * Dokter
     *
     * @param nomorAntrian
     * @return
     */
    public Pasien panggilPasien(int nomorAntrian) {
        return daftarPasien[nomorAntrian];
    }
    
    /**method ini berfungsi untuk mencari antrian pasien yang sudah terdaftar
     * 
     * @param tanggal
     * @param bulan
     * @param tahun
     * @param klinik
     * @return 
     */
    public static int cariAntrian(int tanggal, int bulan, int tahun, Klinik klinik) {
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
    public static void buatAntrian(int tanggal,int bulan,int tahun,Klinik klinik) {
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
    public static void daftarPasien(Pasien pasien, int tanggal, int bulan, int tahun, Klinik klinik) {
        if (cariAntrian(tanggal, bulan, tahun, klinik) >= 0) {
            daftarAntrian.get(cariAntrian(tanggal, bulan, tahun, klinik)).mendaftar(pasien);
        }else{
            buatAntrian(tanggal, bulan, tahun, klinik);
            daftarAntrian.get(cariAntrian(tanggal, bulan, tahun, klinik)).mendaftar(pasien);
        }
    }

    public String toString() {
        return String.valueOf(tahunAntrian)
                + String.valueOf(bulanAntrian)
                + String.valueOf(tanggalAntrian)
                + klinik.getIdKlinik()
                + klinik.getNama();
    }

}
