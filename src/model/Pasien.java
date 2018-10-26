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
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aldy
 */
public class Pasien implements Serializable {

    private String nama;
    private String alamat;
    private String tempatLahir;
    private String nik;
    private String noRM;
    private int tanggalLahir;
    private int bulanLahir;
    private int tahunLahir;
    public static ArrayList<Pasien> daftarPasien = new ArrayList<Pasien>();

    public Pasien() {
    }

    public Pasien(String nama, String alamat, String tempatLahir, int tanggalLahir, int bulanLahir, int tahunLahir, String nik) {
        this.nama = nama;
        this.alamat = alamat;
        this.tempatLahir = tempatLahir;
        this.tanggalLahir = tanggalLahir;
        this.tanggalLahir = tanggalLahir;
        this.bulanLahir = bulanLahir;
        this.tahunLahir = tahunLahir;
        this.nik = nik;
    }

    public Pasien(String nama) {
        this.nama = nama;

    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }

    public int getTanggalLahir() {
        return tanggalLahir;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNoRM() {
        return noRM;
    }

    public void setNoRM(String noRM) {
        this.noRM = noRM;
    }

    public static ArrayList<Pasien> getDaftarPasien() {
        return daftarPasien;
    }

    public static void setDaftarPasien(ArrayList<Pasien> daftarPasien) {
        Pasien.daftarPasien = daftarPasien;
    }

    /**
     * fungsi ini bertujuan untuk mengatur tanggal lahir, dimana jika tanggal
     * lahir benar yaitu tanggal 1 sampai tanggal 31 maka outputan akan sesuai
     * tanggal lahir yang di inpiutkan. Akan tetapi jika salah yaitu tanggal
     * lahir melebihi tanggal 31 maka akan menampilkan outputan Tanggal Lahir
     * Salah.
     *
     * @param tanggalLahir
     * @throws Exception
     */
    public void setTanggalLahir(int tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public int getBulanLahir() {
        return bulanLahir;
    }

    /**
     * fungsi ini bertujuan untuk mengatur bulan lahir, dimana jika bulan lahir
     * benar yaitu 1 sampai bulan 12 maka outputan akan sesuai bulan yang di
     * inputkan. Akan tetapi jika salah yaitu bulan kurang dari 0 dan melebihi
     * dari bulan 12 maka akan menampikan outputan Bulan Lahir Salah.
     *
     * @param bulanLahir
     * @throws Exception
     */
    public void setBulanLahir(int bulanLahir) {

        this.bulanLahir = bulanLahir;

    }

    public int getTahunLahir() {
        return tahunLahir;
    }

    /**
     * fungsi ini bertujuan untuk mengatur tahun lahir, dimana jika tahun lahir
     * benar yaitu diatas 0 maka akan menampilkan sesuai tahun itu, tetapi jika
     * salah maka akan keluar outputan Tahun Lahir Salah.
     *
     * @param tahunLahir
     * @throws Exception
     */
    public void setTahunLahir(int tahunLahir) {

        this.tahunLahir = tahunLahir;

    }

    /**
     * fungsi ini digunakan untuk menyimpan data nomor rekam medis yang berarti
     * tanggal hari dan bulan adalah hari terakhir dimana seorang pasien akan
     * melakukan rekam medis ditambah nama depan pasien sebagai inisial pasien.
     *
     * @return
     */
    public String nomorRekamMedis() {
        String nomorRekamMedis;
        Date today = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyyMMdd");
        nomorRekamMedis = ft.format(today) + nama.substring(0, 3);
        return nomorRekamMedis;
    }

    public static void tambahPasienBaru(Pasien pasien) {
        daftarPasien.add(pasien);

    }

    public static Pasien cariPasien(String rekamMedis) {

        for (int i = 0; i < daftarPasien.size(); i++) {
            if (daftarPasien.get(i).getNoRM() == null ? rekamMedis == null : daftarPasien.get(i).getNoRM().equals(rekamMedis)) {
                return daftarPasien.get(i);
            }
        }

        return null;
    }

    public static void simpanDaftarPasien(File file) {
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

    public static void bacaDaftarPasien(File file) {
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

    public String toString() {
        return noRM + "\t" + nama + "\t" + alamat + "\n";
    }

}
