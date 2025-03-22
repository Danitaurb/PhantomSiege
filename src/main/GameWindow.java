package main;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class GameWindow extends JFrame implements Runnable {

    private static final long serialVersionUID = 1L;
    private final GameScreen gameScreen;
    private BufferedImage img;

    private double timePerUpdate;
    private long lastUpdate;
    private int updates;
    private long lastTimeUPS;

    private Thread gameThread;

    public GameWindow() {

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

    private void start(){
        gameThread = new Thread(this){};

        //gameThread.start();
    }

    public void loopGame(){
        while(true){
          

           
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
        gameWindow.start();

    
    }

    public void run(){
        double timePerFrame;
        long lastFrame = System.nanoTime();

        timePerFrame = 1000000000.0 / 120.0;

        while (true) { 
            //Render
            if (System.nanoTime() - lastFrame >= timePerFrame){
                lastFrame = System.nanoTime();
                repaint();
            }  else {
                
            }   

            if (System.nanoTime() - lastUpdate >= timePerUpdate){
                updateGame();
            }
        }
    }
        
       
        //Update

        //Checking FPS & UPS
    
}