/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import model.Pasien;

/**
 *
 * @author jarkom
 */
public class TambahPasienBaruDialog extends JDialog implements ActionListener {

    //membuat variabel baru
    private JLabel namaLabel, jenisKelamin;
    private JLabel judulLabel, noNIK, labelAlamat, labelTanggal, labelTahun, labelBulan;
    private JTextField namaText, textNIK, textAlamat;
    private JButton saveBotton;
    private JRadioButton lakiLaki, wanita;
    private JComboBox tanggalBox, BulanBox, TahunBox;
    private String tanggal[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9",
        "10", "11", "12", "13", "14", "15", "16", "17", "18",
        "19", "20", "21", "22", "23", "24", "25", "26", "27",
        "28", "29", "30", "31"};
    private String bulan[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9",
        "10", "11", "12"};
    private String tahun[] = {"1970", "1971", "1972", "1973", "1974", "1975",
        "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984",
        "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993",
        "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002",
        "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012",
        "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021"};

    public TambahPasienBaruDialog() {
        init();

    }

    /**
     * method ini berfungsi untuk menginputkan data atau format Label yang ingin
     * dibuat
     */
    public void init() {
        this.setLayout(null);
        //untuk judul label yaitu "Form Daftar Antrian", dan menginputkan
        //data (150 yang berarti panjang x, 30 yang berarti panjang y,
        //250 untuk panjang tulisan dan 20 untuk tebal atau tinggi tulisan)
        judulLabel = new JLabel("Form Daftar Pasien");
        judulLabel.setBounds(130, 30, 250, 20);
        this.add(judulLabel);

        //untuk "NIK", dan menginputkan data (20 yang berarti panjang x,
        //60 yang berarti panjang y, 100 untuk panjang tulisan "NIK",
        //dan 30 untuk tebal atau tinggi tulisan "NIK") 
        noNIK = new JLabel("NIK");
        noNIK.setBounds(20, 60, 100, 30);
        this.add(noNIK);

        //mengatur kotak untuk mengisi data pada "NIK", yaitu 80 yang berarti
        //panjang x dari samping Label, 60 yang berarti panjang y dari atas Label
        //menuju ke bawah, 200 panjang kotak untuk mengisi data, 30 tinggi kotak
        //untuk mengisi data
        textNIK = new JTextField("");
        textNIK.setBounds(80, 60, 200, 30);
        this.add(textNIK);

        //untuk "Nama", dan menginputkan data (20 yang berarti panjang x,
        //100 yang berarti panjang y, 50 untuk panjang tulisan "Nama",
        //dan 30 untuk tebal atau tinggi tulisan "Nama")
        namaLabel = new JLabel("Nama");
        namaLabel.setBounds(20, 100, 50, 30);
        this.add(namaLabel);

        //mengatur kotak untuk mengisi data pada "Nama", yaitu 80 yang berarti
        //panjang x dari samping Label, 100 yang berarti panjang y dari atas Label
        //menuju ke bawah, 200 panjang kotak untuk mengisi data, 30 tinggi kotak
        //untuk mengisi data
        namaText = new JTextField("");
        namaText.setBounds(80, 100, 200, 30);
        this.add(namaText);

        //untuk "Alamat", dan menginputkan data (20 yang berarti panjang x,
        //140 yang berarti panjang y, 50 untuk panjang tulisan "Alamat",
        //dan 30 untuk tebal atau tinggi tulisan "Alamat")
        labelAlamat = new JLabel("Alamat");
        labelAlamat.setBounds(20, 140, 50, 30);
        this.add(labelAlamat);

        //mengatur kotak untuk mengisi data pada "Alamat", yaitu 80 yang berarti
        //panjang x dari samping Label, 140 yang berarti panjang y dari atas Label
        //menuju ke bawah, 200 panjang kotak untuk mengisi data, 30 tinggi kotak
        //untuk mengisi data
        textAlamat = new JTextField("");
        textAlamat.setBounds(80, 140, 200, 100);
        this.add(textAlamat);

        //untuk "Jenis Kelamin", dan menginputkan data (20 yang berarti panjang x,
        //250 yang berarti panjang y, 90 untuk panjang tulisan "Jenis Kelamin",
        //dan 30 untuk tebal atau tinggi tulisan "Jenis Kelamin")
        jenisKelamin = new JLabel("Jenis Kelamin");
        jenisKelamin.setBounds(20, 250, 90, 30);
        this.add(jenisKelamin);

        //untuk "Pria", dan menginputkan data (120 yang berarti panjang x,
        //250 yang berarti panjang y, 60 untuk panjang tulisan "Pria",
        //dan 30 untuk tebal atau tinggi tulisan "Pria")
        lakiLaki = new JRadioButton("Pria", true);
        lakiLaki.setBounds(120, 250, 60, 30);
        this.add(lakiLaki);

        //untuk "Wanita", dan menginputkan data (190 yang berarti panjang x,
        //250 yang berarti panjang y, 80 untuk panjang tulisan "Wanita",
        //dan 30 untuk tebal atau tinggi tulisan "Wanita")
        wanita = new JRadioButton("Wanita", false);
        wanita.setBounds(190, 250, 80, 30);
        this.add(wanita);

        //untuk mengelompokkan wanita dan pria mengunakan variabel kelaminButtonGroup
        ButtonGroup kelaminButtonGroup = new ButtonGroup();
        kelaminButtonGroup.add(wanita);
        kelaminButtonGroup.add(lakiLaki);

        //untuk "Simpan", dan menginputkan data (80 yang berarti panjang x,
        //330 yang berarti panjang y, 100 untuk panjang tulisan "Simpan",
        //dan 30 untuk tebal atau tinggi tulisan "Simpan")
        saveBotton = new JButton("Simpan");
        saveBotton.setBounds(80, 330, 100, 30);
        this.add(saveBotton);
        saveBotton.addActionListener(this);

        //untuk "Tanggal", dan menginputkan data (20 yang berarti panjang x,
        //290 yang berarti panjang y, 50 untuk panjang tulisan "Tanggal",
        //dan 30 untuk tebal atau tinggi tulisan "Tanggal")
        labelTanggal = new JLabel("Tanggal");
        labelTanggal.setBounds(20, 290, 50, 30);
        this.add(labelTanggal);

        //mengatur kotak untuk mengisi data pada "Tanggal", yaitu 70 yang berarti
        //panjang x dari samping Label, 290 yang berarti panjang y dari atas Label
        //menuju ke bawah, 50 panjang kotak untuk mengisi data, 30 tinggi kotak
        //untuk mengisi data
        tanggalBox = new JComboBox(tanggal);
        tanggalBox.setBounds(70, 290, 50, 30);
        this.add(tanggalBox);

        //untuk "Bulan", dan menginputkan data (130 yang berarti panjang x,
        //290 yang berarti panjang y, 50 untuk panjang tulisan "Bulan",
        //dan 30 untuk tebal atau tinggi tulisan "Bulan")
        labelBulan = new JLabel("Bulan");
        labelBulan.setBounds(130, 290, 50, 30);
        this.add(labelBulan);

        //mengatur kotak untuk mengisi data pada "Bulan", yaitu 170 yang berarti
        //panjang x dari samping Label, 290 yang berarti panjang y dari atas Label
        //menuju ke bawah, 50 panjang kotak untuk mengisi data, 30 tinggi kotak
        //untuk mengisi data
        BulanBox = new JComboBox(bulan);
        BulanBox.setBounds(170, 290, 50, 30);
        this.add(BulanBox);

        //untuk "Tahun", dan menginputkan data (220 yang berarti panjang x,
        //290 yang berarti panjang y, 50 untuk panjang tulisan "Tahun",
        //dan 30 untuk tebal atau tinggi tulisan "Tahun")
        labelTahun = new JLabel("Tahun");
        labelTahun.setBounds(220, 290, 50, 30);
        this.add(labelTahun);

        //mengatur kotak untuk mengisi data pada "Tahun", yaitu 260 yang berarti
        //panjang x dari samping Label, 290 yang berarti panjang y dari atas Label
        //menuju ke bawah, 70 panjang kotak untuk mengisi data, 30 tinggi kotak
        //untuk mengisi data
        TahunBox = new JComboBox(tahun);
        TahunBox.setBounds(260, 290, 70, 30);
        this.add(TahunBox);

    }

    /**
     * digunakan untuk menginputkan data yang nantinya akan pengguna masukkan
     * pada label sehingga data tersebut dapat tersimpan dengan baik
     *
     * @param a
     */
    @Override
    public void actionPerformed(ActionEvent a) {
        if (a.getSource() == saveBotton) {
            Pasien pasien = new Pasien();
            pasien.setNoRM(textNIK.getText());
            pasien.setNama(namaText.getText());
            pasien.setAlamat(textAlamat.getText());
            Pasien.tambahPasienBaru(pasien);
            pasien.setTanggalLahir(Integer.valueOf(tanggalBox.getSelectedItem().toString()));
            pasien.setBulanLahir(Integer.valueOf(BulanBox.getSelectedItem().toString()));
            pasien.setTahunLahir(Integer.valueOf(TahunBox.getSelectedItem().toString()));
            JOptionPane.showMessageDialog(null, "Telah Ditambahkan");
            this.dispose();
        }
    }
}
