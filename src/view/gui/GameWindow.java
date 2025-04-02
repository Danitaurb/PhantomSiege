package view.gui;

import javax.swing.JFrame;

import controller.EditingController;
import model.ImageLoader;
import model.managers.TileManager;
import view.scenes.Editing;
import view.scenes.GameMenu;
import view.scenes.Playing;
import view.scenes.Render;
import view.scenes.Settings;

public class GameWindow extends JFrame implements Runnable {

    private GameScreen gameScreen;
    
    private Thread gameThread;
        
    private final double FPS_SET = 120.0;
    private final double UPS_DATE = 60.0;    
    
    private Render render;
    private GameMenu menu;
    private Playing playing;
    private Settings settings;
    private Editing editing;
    private TileManager tileManager;

        public GameWindow() {
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            initClasses();
            createDefaultLevel();
            setResizable(false);
            add(gameScreen);
            pack();
            setVisible(true);  
            setTitle("Phantom Siege");
        }
    
        private void createDefaultLevel() {
            int[] arr = new int[640];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = 0;
            }
    
            ImageLoader.CreateLevel("new_level", arr);
        }

        private void initClasses() {
            tileManager = new TileManager();
            render = new Render(this);
            gameScreen = new GameScreen(this);
            menu = new GameMenu(this);
            playing = new Playing(this);
            settings = new Settings(this);
            editing = new Editing(this);

           }
        public void start(){
            gameThread = new Thread(this){};
            gameThread.start();
        }
    
        private void updateGame() {

            // System.out.println("Game Updated!");
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
        
        public GameScreen getGameScreen(){
            return gameScreen;
        }

        public Render getRender() {
            return render;
        } 

        public GameMenu getMenu() {
            return menu;
        }

        public Playing getPlaying() {
            return playing;
        }

        public Settings getSettings() {
            return settings;
        }

        public Editing getEditor() {
            return editing;
        }

        public TileManager getTileManager(){
            return tileManager;
        }

}