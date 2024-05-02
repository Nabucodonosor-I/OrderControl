package com.ordercontrol;

import java.awt.Color;

import javax.swing.JFrame;

public class Frame {
    JFrame frame = new JFrame(); 

    Frame() {
        frame.setSize(750, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setUndecorated(true);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(new Color(255, 255, 255));
    }
}
