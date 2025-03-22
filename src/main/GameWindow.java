package main;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class GameWindow extends JFrame {

    private static final long serialVersionUID = 1L;
    private final GameScreen gameScreen;
    private BufferedImage img;

    private double timePerFrame;
    private long lastFrame;
    private double timePerUpdate;
    private long lastUpdate;
    private int updates;
    private long lastTimeUPS;

    public GameWindow() {

        timePerFrame = 1000000000.0 / 120.0;
        timePerUpdate = 1000000000.0 / 60.0;

        importImg();

        setSize(1024 + getInsets().left + getInsets().right, 
        576 + getInsets().top + getInsets().bottom);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setTitle("Phantom Siege");
        setResizable(false);
        
        gameScreen = new GameScreen(img); // Initialize the game screen
        add(gameScreen);
        setVisible(true);
    }

    public void importImg() {
        InputStream is = getClass().getResourceAsStream("/assets/32x32_map_tile.png");
        try {
            img = ImageIO.read(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    public void loopGame(){
        while(true){
            if (System.nanoTime() - lastUpdate >= timePerUpdate){
                updateGame();

                callUps();
            }

            if (System.nanoTime() - lastFrame >= timePerFrame){
                lastFrame = System.nanoTime();
                repaint();
            }  else {
                
            }
        }      
    }

    private void callUps(){
        if (System.currentTimeMillis() - lastTimeUPS >= 1000){
            System.out.println("UPS: " + updates);
            updates = 0;
            lastTimeUPS = System.currentTimeMillis();
        }
    }

    private void updateGame() {
        updates++;
        lastUpdate = System.nanoTime();
        //System.out.println("Update game!");
    }

    public GameScreen getGameScreen() {
        return gameScreen;
    }

    public static void main(String[] args) {
        GameWindow gameWindow = new GameWindow();
        new GameWindow().loopGame();
    }
}