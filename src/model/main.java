/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Aldy
 */
public class main {

    public static void main(String[] args) {
        Pasien aldy = new Pasien("Aldy");
        dokter dok = new dokter("Jono");
        AntrianPasien antriPasien = new AntrianPasien();

        try {
            aldy.setTanggalLahir(5);
            aldy.setBulanLahir(1);
            aldy.setTahunLahir(1999);
            aldy.setTempatLahir("Palangka Raya");
            aldy.setAlamat("Jogjakarta");
            aldy.setNoRM(aldy.nomorRekamMedis());

            dok.setTanggalLahir(4);
            dok.setBulanLahir(12);
            dok.setTahunLahir(1997);
            dok.setTempatLahir("Paris");
            dok.setAlamat("Jogjakarta");
            dok.setNomorPegawai("122321");

            antriPasien.mendaftar(aldy);
            antriPasien.panggilPasien(0);

        } catch (Exception Ex) {
            Ex.printStackTrace();
        }
        System.out.println("-----PASIEN-----");
        System.out.println("Nama\t\t:" + aldy.getNama());
        System.out.println("Tanggal Lahir\t:" + aldy.getTanggalLahir() + "" + aldy.getBulanLahir() + "" + aldy.getTahunLahir());
        System.out.println("Tempat Lahir\t:" + aldy.getTempatLahir());
        System.out.println("Alamat\t\t:" + aldy.getAlamat());
        System.out.println("No Rekam Medis\t:" + aldy.getNoRM());
        System.out.println("--------------------");
        System.out.println("");

        System.out.println("-----DOKTER-----");
        System.out.println("Nama\t\t:" + dok.getNama());
        System.out.println("Tanggal Lahir\t:" + dok.getTanggalLahir() + "" + dok.getBulanLahir() + "" + dok.getTahunLahir());
        System.out.println("Tempat Lahir\t:" + dok.getTempatLahir());
        System.out.println("Alamat\t\t:" + dok.getAlamat());
        System.out.println("NoPegawai\t:" + dok.getNomorPegawai());
        System.out.println("--------------------");
        System.out.println("");

        System.out.println("Antrian Pasien\t:" + antriPasien.panggilPasien(0).getNama());
    }
}
