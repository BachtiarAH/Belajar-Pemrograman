/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package belajarGui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author user
 */
public class GUI implements ActionListener{
    
    int count = 0;
    JFrame frame;
    JButton button;
    JPanel panel;
    JLabel label;
    
    public static void main(String[] args) {
        //System.out.println("hello");
        new GUI();
    }
    public GUI (){
    
        frame = new JFrame();
        button = new JButton("click me");
        panel = new JPanel();
        label = new JLabel("number of click = "+count);
        
        button.addActionListener(this);
        
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0,1));
        panel.add(button);
        panel.add(label);
        
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("anying");
        frame.pack();
        frame.setVisible(true);
        
} 
    


    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        count++;
        label.setText("number of click = "+count);
    }
    
}
