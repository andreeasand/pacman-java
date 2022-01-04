package com.company;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;

public class Food extends Rectangle implements ImageObserver{

    public Food(int x,int y)
    {
        setBounds(x+12,y+12,12,12);
    }
    public void paintComponent(Graphics g)
    {
        Image food=new ImageIcon("food4.png").getImage();
        g.drawImage(food,x,y,12,12,  this);
    }
    @Override
    public boolean imageUpdate(Image arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
        // TODO Auto-generated method stub
        return false;
    }
}
