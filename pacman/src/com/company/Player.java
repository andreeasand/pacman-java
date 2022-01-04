package com.company;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
import javax.swing.ImageIcon;

public class Player extends Rectangle implements ImageObserver{

    public int index;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
    Joc board=new Joc();
    public Player(int x,int y)
    {
        setBounds(x,y,32,32);
    }

    public void paintComponent(Graphics g)
    {
        if(board.getDir()==1)
        {
            Image pac1=new ImageIcon("pacdr.png").getImage();
            g.drawImage(pac1,board.getPacX(),board.getPacY(),32,32,this);
        }

        if(board.getDir()==2)
        {
            Image pac2=new ImageIcon("pacst.png").getImage();
            g.drawImage(pac2,board.getPacX(),board.getPacY(),32,32,this);
        }

        if(board.getDir()==3)
        {
            Image pac3=new ImageIcon("pacsus.png").getImage();
            g.drawImage(pac3,board.getPacX(),board.getPacY(),32,32,this);
        }

        if(board.getDir()==4)
        {
            Image pac4=new ImageIcon("pacjos.png").getImage();
            g.drawImage(pac4,board.getPacX(),board.getPacY(),32,32,this);
        }


    }

    public boolean allowedToMove(int nextX,int nextY) {
        Rectangle limit=new Rectangle(nextX,nextY,32,32);
        Tabla t=Joc.tabla;

        for(int i=0;i<t.lab.length;i++)
        {
            for(int j=0;j<t.lab[0].length;j++)
            {
                if(t.lab[i][j]!=null)
                {
                    if(limit.intersects(t.lab[i][j]))
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public boolean meetsFood(int x,int y)
    {
        Rectangle limit =new Rectangle(x,y,32,32);
        Tabla t=Joc.tabla;
        for(index=0;index<t.food.size();index++)
        {
            if(limit.intersects(t.food.get(index)))
                return true;
        }
        return false;
    }

    public boolean meetsEnemy(int x,int y)
    {
        Rectangle pac=new Rectangle(x,y,32,32);
        Rectangle gh1=new Rectangle(board.getG1x(),board.getG1y(),32,32);
        Rectangle gh2=new Rectangle(board.getG2x(),board.getG2y(),32,32);
        Rectangle gh3=new Rectangle(board.getG3x(),board.getG3y(),32,32);
        Rectangle gh4=new Rectangle(board.getG4x(),board.getG4y(),32,32);
        if(pac.intersects(gh1) || pac.intersects(gh2) || pac.intersects(gh3) ||pac.intersects(gh4))
            return true;
        return false;
    }

    @Override
    public boolean imageUpdate(Image arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
        // TODO Auto-generated method stub
        return false;
    }
}
