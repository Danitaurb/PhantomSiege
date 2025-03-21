package main;

import java.awt.Graphics;
import javax.swing.JPanel;

public class GamePanel extends JPanel{

    public GamePanel(){
        //gameWindow = new GameWindow();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawRect(100, 100, 200, 50);
    }
}
