package scenes;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;
import static main.GameStates.*;
import javax.imageio.ImageIO;

import main.GameWindow;
import ui.MyButton;


public class GameMenu extends GameScene implements ScenesMethods {


    private BufferedImage img;
    private ArrayList<BufferedImage> sprites = new ArrayList<BufferedImage>();
    private Random random;
    private GameWindow gameWindow; 

    private MyButton bPlaying, bSettings, bQuit;


    public GameMenu(GameWindow game){
        super(game);
        random = new Random();
        importImg();    
        loadSprites();
        initButtons();
    }
            
    private void initButtons() {
        bPlaying = new MyButton("Play", 100, 100, 100, 30);
        bSettings = new MyButton("Settings", 100, 150, 100, 30);
        bQuit = new MyButton("Quit", 100, 200, 100, 30);
    }
        
    @Override
    public void render(Graphics g) {
        drawButtons(g);
    }
               
    private void drawButtons(Graphics g) {
        bPlaying.draw(g);
        bSettings.draw(g);
        bQuit.draw(g);
    }
        
    public void callMe() {
        // TODO Auto-generated method stub

    }

     private void loadSprites()
    {
        for(int y = 0; y < 20; y++){
            for(int x = 0; x < 20; x++){
                sprites.add(img.getSubimage(x*32, y*32, 32, 32));
            }
        }
    }

    public void importImg() {
        InputStream is = getClass().getResourceAsStream("/assets/32x32_map_tile.png");
        try {
            img = ImageIO.read(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    private int getRndInt()
    {
        return random.nextInt(399);
    }

    @Override
    public void mouseClicked(int x, int y) {
        if (bPlaying.getBounds().contains(x, y)) {
            SetGameState(PLAYING);
        }

        if (bSettings.getBounds().contains(x, y)) {
            SetGameState(SETTINGS);
        }

        if (bQuit.getBounds().contains(x, y)) {
            System.exit(0);
        }
    }

    @Override
    public void mouseMoved(int x, int y) {
        if (bPlaying.getBounds().contains(x, y)) {
            bPlaying.setMouseOver(true);
        } 

        if (bSettings.getBounds().contains(x, y)) {
            bSettings.setMouseOver(true);
        }

        if (bQuit.getBounds().contains(x, y)) {
            bQuit.setMouseOver(true);
        }
    }

    @Override
    public void mousePressed(int x, int y) {
        if (bPlaying.getBounds().contains(x, y)) {
            bPlaying.setMousePressed(true);
        } 

        if (bSettings.getBounds().contains(x, y)) {
            bSettings.setMousePressed(true);
        }

        if (bQuit.getBounds().contains(x, y)) {
            bQuit.setMousePressed(true);
        }
    }

    @Override
    public void mouseReleased(int x, int y) {
       resetButtons();
    }
       
    private void resetButtons() {
        bPlaying.setMousePressed(false);

        bSettings.setMousePressed(false);

        bQuit.setMousePressed(false);
    }


}
