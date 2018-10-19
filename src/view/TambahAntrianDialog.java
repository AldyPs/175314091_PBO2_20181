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
 * @author Aldy
 */
public class TambahAntrianDialog extends JDialog implements ActionListener {
    //membuat variabel baru
    private JLabel namaLabel;
    private JLabel labelNama, labelAlamat, noRM;
    private JTextField textNama, textAlamat, textRM;

    public TambahAntrianDialog() {
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
        namaLabel = new JLabel("Form Daftar Antrian");
        namaLabel.setBounds(150, 30, 250, 20);
        this.add(namaLabel);

        //untuk "No RM", dan menginputkan data (20 yang berarti panjang x,
        //60 yang berarti panjang y, 100 untuk panjang tulisan "No RM",
        //dan 30 untuk tebal atau tinggi tulisan "No RM") 
        noRM = new JLabel("no RM");
        noRM.setBounds(20, 60, 50, 30);
        this.add(noRM);

        //mengatur kotak untuk mengisi data pada "No RM", yaitu 80 yang berarti
        // panjang x dari samping Label, 60 yang berarti panjang y dari atas Label
        //menuju ke bawah, 200 panjang kotak untuk mengisi data, 30 tinggi kotak
        //untuk mengisi data
        textRM = new JTextField();
        textRM.setBounds(80, 60, 200, 30);
        this.add(textRM);
        textRM.addActionListener(this);

        //untuk "Nama", dan menginputkan data (20 yang berarti panjang x,
        //100 yang berarti panjang y, 50 untuk panjang tulisan "Nama",
        //dan 30 untuk tebal atau tinggi tulisan "Nama")
        labelNama = new JLabel("Nama");
        labelNama.setBounds(20, 100, 50, 30);
        this.add(labelNama);

        //mengatur kotak untuk mengisi data pada "Nama", yaitu 80 yang berarti
        //panjang x dari samping Label, 100 yang berarti panjang y dari atas Label
        //menuju ke bawah, 200 panjang kotak untuk mengisi data, 30 tinggi kotak
        //untuk mengisi data
        textNama = new JTextField("");
        textNama.setBounds(80, 100, 200, 30);
        this.add(textNama);
        
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
        textAlamat.setBounds(80, 140, 200, 30);
        this.add(textAlamat);

    }
    
    /**
     * digunakan untuk menginputkan data yaitu pada "no RM" berupa nomor NIK Pasien
     * memanggil data yang telah di inputkan pada kelas 
     * TambahPasienBaruDialog, sehingga data akan tampil sesuai yang telah di simpan
     * pada kelas TambahPasienBaruDialog
     * @param a 
     */
    @Override
    public void actionPerformed(ActionEvent a) {
        if (a.getSource() == textRM) {
            if (Pasien.cariPasien(textRM.getText()) != null) {
                textNama.setText(Pasien.cariPasien(textRM.getText()).getNama());
                textAlamat.setText(Pasien.cariPasien(textRM.getText()).getAlamat());
            } else {
                JOptionPane.showMessageDialog(null, "Tidak Ada Data");
            }
        }

    }
}
