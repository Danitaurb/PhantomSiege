package main;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class GameWindow extends JFrame implements Runnable {

    private static final long serialVersionUID = 1L;
    private final GameScreen gameScreen;
    private BufferedImage img;

    private int updates;
    private long lastTimeUPS;

    private Thread gameThread;

    private final int FRAME_WIDTH = 1024;
    private final int FRAME_HEIGHT = 576;
    private final double FPS_SET = 120;
    private final double UPS_DATE = 60;

    public GameWindow() 
    {
        importImg();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setTitle("Phantom Siege");
        setResizable(false);
        
        gameScreen = new GameScreen(img); // Initialize the game screen
        add(gameScreen);
        setVisible(true);
        
        // Set the frame size to account for insets
        int frameWidth = FRAME_WIDTH + getInsets().left + getInsets().right;
        int frameHeight = FRAME_HEIGHT + getInsets().top + getInsets().bottom;
        setSize(frameWidth, frameHeight);
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

        gameThread.start();
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
        double timePerFrame = 1000000000.0 / FPS_SET;
        double timePerUpdate = 1000000000.0 / UPS_DATE;

        long lastFrame = System.nanoTime();
        long lastUpdate = System.nanoTime();
        long lastTimeCheck = System.currentTimeMillis();

        int frames = 0;
        int updates = 0;

        while (true) { 
            //Render
            if (System.nanoTime() - lastFrame >= timePerFrame){
                repaint();
                lastFrame = System.nanoTime();
                frames++;
            }  else {
                
            }   

            if (System.nanoTime() - lastUpdate >= timePerUpdate){
                updateGame();
                lastUpdate = System.nanoTime();
                updates++;
            }

            if(System.currentTimeMillis() - lastTimeCheck >= 1000){
                System.out.println("FPS: " + frames + "| UPS: " + updates);
                frames = 0;
                updates = 0;
                lastTimeCheck = System.currentTimeMillis();
            }
        }
    }
        
       
        //Update

        //Checking FPS & UPS
    
}