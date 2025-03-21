package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.nio.Buffer;
import java.util.Random;

import javax.swing.JPanel;

public class GameScreen extends JPanel {
    
    private Random random;
    private BufferedImage img;
    public GameScreen(BufferedImage img) {
        this.img = img;
        random = new Random();

    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.drawImage(img, 0, 0, null);
    /* 
         for(int x = 0; x <32; x++)
         {
           g.setColor(getRndColor());
           g.fillRect(x * 32, 0, 32, 32);
           for(int y = 0; y < 18; y++)
           {
               g.setColor(getRndColor());
               g.fillRect(x * 32, y * 32, 32, 32);
           }
         }
     */

     }
     private Color getRndColor()
     {
         //return new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255));
         int r = random.nextInt(255);
         int g = random.nextInt(255);
         int b = random.nextInt(255);
         return new Color(r,g,b);
      }




}   
