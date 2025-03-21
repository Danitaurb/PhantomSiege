package main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

public class GameScreen extends JPanel {
    
    private Random random;
    public GameScreen(){
       random = new Random();

    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        g.setColor(Color.RED);
       
        for(int x = 0; x <20;x++){

           g.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
           g.fillRect(x * 32, 32, 0, 0);
           
        }


     }
}   
