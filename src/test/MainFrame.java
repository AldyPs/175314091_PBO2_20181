/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import view.Frame;
import javax.swing.JFrame;

/**
 *
 * @author Aldy
 */
public class MainFrame extends JFrame {
    
    /**
     * method ini berfungsi untuk memanggil data yang telah dibuat
     * @param args 
     */
    public static void main(String[] args) {
        Frame test = new Frame();
        //ukuran tabel yang akan dibuat
        test.setSize(400, 400);
        test.setVisible(true);
        test.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
