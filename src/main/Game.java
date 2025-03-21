 package main;

import javax.swing.JFrame;

public class Game extends JFrame {

    private static final long serialVersionUID = 1L;
    private GameScreen gameScreen;

    public Game() {
        setVisible(true);
        setTitle("Phantom Siege");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setSize(1024, 576);
        
        gameScreen = new GameScreen();
        add(gameScreen);
    }


    
}