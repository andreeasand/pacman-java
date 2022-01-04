package com.company;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame f =new JFrame();
        Joc b=new Joc();
        f.add(b);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(710,840);
        f.setResizable(false);
        f.setVisible(true);
    }
}
