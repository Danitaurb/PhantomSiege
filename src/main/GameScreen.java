package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
//import java.nio.Buffer;
import java.util.Random;
import java.util.ArrayList;
import javax.swing.JPanel;



public class GameScreen extends JPanel {
    
    private Random random;
    private GameWindow game;
    
    private final int PANEL_WIDTH = 1024;
    private final int PANEL_HEIGHT = 576;

    
    
    
    public GameScreen(GameWindow game) 
    {   
        this.game = game;
        setPanelSize();
        random = new Random();


    }
    
    
    public void setPanelSize(){
            setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        }
    
    
    
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        game.getRender().renderGame(g);

//      g.drawImage(sprites.get(103), 0, 0, null);
//      g.drawImage(img.getSubimage(32*0, 32*10, 32, 32), 32, 0, null);
//      g.drawImage(img.getSubimage(32*1, 32*8, 32, 32), 0, 32, null);
//      g.drawImage(img.getSubimage(32*2, 32*8, 32, 32), 32, 32, null);
//      g.drawImage(img.getSubimage(32*1, 32*9, 32, 32), 0, 64, null);
//      g.drawImage(img.getSubimage(32*2, 32*9, 32, 32), 32, 64, null);
//      g.drawImage(img.getSubimage(32*1, 32*10, 32, 32), 0, 96, null);
//      g.drawImage(img.getSubimage(32*2, 32*10, 32, 32), 32, 96, null);

       

     }


    
     /* 
     private Color getRndColor()
     {
         //return new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255));
         int r = random.nextInt(255);
         int g = random.nextInt(255);
         int b = random.nextInt(255);
         return new Color(r,g,b);
      }
     */



}   