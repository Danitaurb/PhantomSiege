package view;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import inputs.KeyboardInputs;

public class GamePanel extends JPanel{


      

    public GamePanel(){
        //gameWindow = new GameWindow();
       
        addKeyListener(new KeyboardInputs());

            
        
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawRect(100, 100, 200, 50);
    }
}
