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
public class dokter {

    private String nomorPegawai;
    private String nama;
    private String alamat;
    private String tempatLahir;
    private int tanggalLahir;
    private int bulanLahir;
    private int tahunLahir;

    public dokter() {
    }

    public dokter(String nama) {
        this.nama = nama;
    }

    public String getNomorPegawai() {
        return nomorPegawai;
    }
        /**
     * fungsi ini bertujuan untuk mengatur nomor rekam medis, dimana kode atau
     * nomor rekam medis harus sama dengan 6 digit, jika tidak maka akan menampilkan
     * outputan Salah Nomor Pegawai.
     * @param nomorPegawai
     * @throws Exception 
     */
    public void setNomorPegawai(String nomorPegawai) throws Exception {
        if (nomorPegawai.length() == 6) {
            this.nomorPegawai = (nomorPegawai + nama.substring(0, 3));
        } else {
            throw new Exception("Salah Nomor Pegawai");
        }
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
        /**
     * fungsi ini bertujuan untuk mengatur tanggal lahir, dimana jika tanggal
     * lahir benar yaitu tanggal 1 sampai tanggal 31 maka outputan akan sesuai
     * tanggal lahir yang di inpiutkan. Akan tetapi jika salah yaitu tanggal lahir
     * melebihi tanggal 31 maka akan menampilkan outputan Tanggal Lahir Salah.
     * @param tanggalLahir
     * @throws Exception 
     */
    public void setTanggalLahir(int tanggalLahir) throws Exception {
        if (tanggalLahir > 0) {
            if (tanggalLahir <= 31) {
                this.tanggalLahir = tanggalLahir;
            } else {
                throw new Exception("Tanggal Lahir Salah");
            }
        } else {
            throw new Exception("Tanggal Lahir Salah");
        }
    }

    public int getBulanLahir() {
        return bulanLahir;
    }
    /**
     * fungsi ini bertujuan untuk mengatur bulan lahir, dimana jika
     * bulan lahir benar yaitu 1 sampai bulan 12 maka outputan akan sesuai
     * bulan yang di inputkan. Akan tetapi jika salah yaitu bulan kurang dari 0
     * dan melebihi dari bulan 12 maka akan menampikan outputan Bulan Lahir Salah.
     * @param bulanLahir
     * @throws Exception 
     */
    public void setBulanLahir(int bulanLahir) throws Exception {
        if (bulanLahir > 0) {
            if (bulanLahir <= 12) {
                this.bulanLahir = bulanLahir;
            } else {
                throw new Exception("Bulan Lahir Salah");
            }
        } else {
            throw new Exception("Bulan Lahir Salah");
        }
    }

    public int getTahunLahir() {
        return tahunLahir;
    }
    /**
     * fungsi ini bertujuan untuk mengatur tahun lahir, dimana jika
     * tahun lahir benar yaitu diatas 0 maka akan menampilkan sesuai tahun itu,
     * tetapi jika salah maka akan keluar outputan Tahun Lahir Salah.
     * @param tahunLahir
     * @throws Exception 
     */
    public void setTahunLahir(int tahunLahir) throws Exception {
        if (tahunLahir > 0) {
            this.tahunLahir = tahunLahir;
        } else {
            throw new Exception("Tahun Lahir Salah");
        }
    }
}
