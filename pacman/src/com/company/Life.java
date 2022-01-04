package com.company;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;

public class Life extends Rectangle implements ImageObserver {
    public Life(int x,int y) {
        setBounds(x,y,32,32);
    }
    public void paintComponent(Graphics g) {
        Image life=new ImageIcon("life.png").getImage();
        g.drawImage(life,x,y,32,32,this);
    }
    @Override
    public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
        // TODO Auto-generated method stub
        return false;
    }
}
