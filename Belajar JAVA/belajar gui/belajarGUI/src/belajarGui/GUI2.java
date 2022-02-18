/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package belajarGui;

import javax.swing.JFrame;

/**
 *
 * @author user
 */
public class GUI2 {
    public static void main(String[] args) {
        //membuat objek jendela
        JFrame jendela = new JFrame();
        
        //memberikan judul pada jendela
        jendela.setTitle("belajar javax swing");
        
        //mengatur ukuran jendela
        jendela.setSize(500, 500);
        
        //menampilkan jendela
        jendela.setVisible(true);
    }
}
