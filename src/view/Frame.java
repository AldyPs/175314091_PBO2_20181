/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import test.MainFrame;
import javax.swing.*;
import view.TambahPasienBaruDialog;
import view.TambahAntrianDialog;

/**
 *
 * @author Aldy
 */
public class Frame extends JFrame implements ActionListener {
    //membuat variabel baru
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenu menuPasien;
    private JMenuItem exitMenuItem;
    private JMenuItem tambahPasien;
    private JMenuItem tambahAntrian;
    
    public Frame() {
        init();
    }
    
    public void init() {
        this.setLayout(null);
        this.setJMenuBar(menuBar);
        menuBar = new JMenuBar();
        //membuat menu pada label
        fileMenu = new JMenu("Pasien");
        //membuat Judul label
        this.setTitle("Antrian");
        //menambahkan menu pada label menggunakan menuPasien, tambahPasien,
        //tambahAntrian dan exitMenuItem yang terdapat beberapa pilihan
        menuPasien = new JMenu("Menu");
        tambahPasien = new JMenuItem("Tambah Pasien");
        tambahAntrian = new JMenuItem("Tambah Antrian");
        exitMenuItem = new JMenuItem("Exit");
        
        menuBar.add(fileMenu);
        this.setJMenuBar(menuBar);
        fileMenu.add(tambahPasien);
        fileMenu.add(tambahAntrian);
        fileMenu.add(exitMenuItem);

        tambahPasien.addActionListener(this);
        tambahAntrian.addActionListener(this);
        exitMenuItem.addActionListener(this);
        
    }
    
    /**
     * method ini digunakan untuk menampilkan menu menu yang telah dibuat sebelumnya
     * @param tambah 
     */
    @Override
    public void actionPerformed(ActionEvent tambah) {
        //menampilkan tabel baru jika pengguna memilih tambahPasien
        //isi tabel tersebut berupa data yang telah di susun pada kelas
        //TambahPasienBaruDialog
        if (tambah.getSource() == tambahPasien) {
            TambahPasienBaruDialog test = new TambahPasienBaruDialog();
            test.setSize(400, 500);
            test.setVisible(true);
        }
        //menampilkan tabel baru jika pengguna memilih tambahAntrian
        //isi tabel tersebut berupa data yang telah di susun pada kelas
        //TambahAntrianDialog
        if (tambah.getSource() == tambahAntrian) {
            TambahAntrianDialog test = new TambahAntrianDialog();
            test.setSize(400, 500);
            test.setVisible(true);
        }
        //jika pengguna memilih exitMenuItem maka akan keluar dari tabel
        if (tambah.getSource() == exitMenuItem) {
            System.exit(0);
        }
    }
}
