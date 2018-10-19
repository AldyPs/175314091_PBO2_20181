/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test17okt2018;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class TestStreaming {
    public static void main(String[] args) {
        FileOutputStream fos = null;
        try {
            File file = new File("test.txt"); // file tujuan
            String data ="hello world"; // data yang disimpan
            fos = new FileOutputStream(file,true); // object stream
            fos.write(data.getBytes());
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(TestStreaming.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fos.close();
            } catch (IOException ex) {
                Logger.getLogger(TestStreaming.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}
