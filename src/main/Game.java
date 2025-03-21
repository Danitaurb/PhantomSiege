package main;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.nio.Buffer;

import javax.imageio.ImageIO;

//import view.GameScreen;

import javax.swing.JFrame;

public class Game extends JFrame {

    private static final long serialVersionUID = 1L;
    private final GameScreen gameScreen;
    private BufferedImage img;

    public Game() {

        importImg();

        setVisible(true);
        setTitle("Phantom Siege");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        //setSize(2048/2, 1152/2);
        setSize(1024 + getInsets().left + getInsets().right, 
              576 + getInsets().top + getInsets().bottom);

        gameScreen = new GameScreen(img); // Initialize the game screen
    }

    public void importImg() {
        InputStream is = getClass().getResourceAsStream("/assets/32x32_map_tile.png");
        try {
            img = ImageIO.read(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    public GameScreen getGameScreen() {
        return gameScreen;
    }
}