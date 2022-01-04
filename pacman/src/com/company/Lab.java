package com.company;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Lab extends Rectangle {

    public Lab(int x,int y)
    {
        setBounds(x,y,32,32);
    }
    public void paintComponent(Graphics g)
    {
        g.setColor(Color.blue);
        g.fillRect(x, y, width, height);
    }

}
