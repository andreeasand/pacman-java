package com.company;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class Tabla {

    public int width;
    public int height;
    public Joc b = new Joc();
    public Lab[][] lab;
    public List<Food> food = new ArrayList<Food>();
    public List<Enemy> enemy = new ArrayList<Enemy>();
    public List<Life> life = new ArrayList<Life>();

    public Tabla() {
        try {
            BufferedImage map = ImageIO.read(new File("map.png"));
            this.width = map.getWidth();
            this.height = map.getHeight();
            //System.out.println("latimea: "+ width+ " inaltimea: "+height);
            int[] pixel = new int[width * height];
            lab = new Lab[width][height];

            map.getRGB(0, 0, width, height, pixel, 0, width);

            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    //valoare= pixel[offset+ (j-startY)*width+ (i-startX)]
                    int valoare = pixel[ (j * width) + i];
                    if (valoare == 0xFF000000) {    //negru
                        //Lab
                        lab[i][j] = new Lab(i * 32, j * 32);

                    } else if (valoare == 0xFFFFD800) { //Pacman
                        b.setPacX(i * 32);
                        b.setPacY(j * 32);

                    } else if (valoare == 0xFFFF0000) { //Enemy
                        b.setG1x(i * 32);
                        b.setG1y(j * 32);

                    } else if (valoare == 0xFFFF180C) {    //Enemy
                        b.setG2x(i * 32);
                        b.setG2y(j * 32);
                    } else if (valoare == 0xFFFF0026) {  //Enemy
                        b.setG3x(i * 32);
                        b.setG3y(j * 32);
                    } else if (valoare == 0xFFFF075E) {  //enemy
                        b.setG4x(i * 32);
                        b.setG4y(j * 32);
                    } else if (valoare == 0xFFFFFFFF) {  //Food
                        food.add(new Food(i * 32, j * 32));
                    } else if (valoare == 0xFFFF6A00) {  //Life
                        life.add(new Life(i * 32, j * 32));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void paintComponent(Graphics g) {

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (lab[i][j] != null) lab[i][j].paintComponent(g);
            }
        }

        for (int k = 0; k < food.size(); k++) {
            food.get(k).paintComponent(g);
        }
        for (int l = 0; l < enemy.size(); l++) {
            enemy.get(l).paintComponent(g);
        }
        for (int m = 0; m < life.size(); m++) {
            life.get(m).paintComponent(g);
        }
    }
}
	