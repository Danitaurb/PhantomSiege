package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
//import java.nio.Buffer;
import java.util.Random;
import java.util.ArrayList;

import javax.swing.JPanel;

public class GameScreen extends JPanel {
    
    private Random random;
    private BufferedImage img;
    private ArrayList<BufferedImage> sprites = new ArrayList<BufferedImage>();

    public GameScreen(BufferedImage img) 
    {
        this.img = img;
        loadSprites();
        random = new Random();

    }

    
    private void loadSprites()
    {
        for(int y = 0; y < 20; y++){
            for(int x = 0; x < 20; x++){
                sprites.add(img.getSubimage(x*32, y*32, 32, 32));
            }
        }
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);

//      g.drawImage(sprites.get(103), 0, 0, null);
//      g.drawImage(img.getSubimage(32*0, 32*10, 32, 32), 32, 0, null);
//      g.drawImage(img.getSubimage(32*1, 32*8, 32, 32), 0, 32, null);
//      g.drawImage(img.getSubimage(32*2, 32*8, 32, 32), 32, 32, null);
//      g.drawImage(img.getSubimage(32*1, 32*9, 32, 32), 0, 64, null);
//      g.drawImage(img.getSubimage(32*2, 32*9, 32, 32), 32, 64, null);
//      g.drawImage(img.getSubimage(32*1, 32*10, 32, 32), 0, 96, null);
//      g.drawImage(img.getSubimage(32*2, 32*10, 32, 32), 32, 96, null);

        for(int x = 0; x <32; x++){
           for(int y = 0; y < 18; y++){
               g.drawImage(sprites.get(getRndInt()), x*32, y*32, null);
           }
         }
     

     }

    private int getRndInt()
    {
        return random.nextInt(399);
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