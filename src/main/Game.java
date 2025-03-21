package main;

//import view.GameScreen;

import javax.swing.JFrame;

public class Game extends JFrame {

    private static final long serialVersionUID = 1L;
    private final GameScreen gameScreen;

    public Game() {
        setVisible(true);
        setTitle("Phantom Siege");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setSize(2048, 1152);

        gameScreen = new GameScreen(); // Initialize the game screen
    }

    public GameScreen getGameScreen() {
        return gameScreen;
    }
}