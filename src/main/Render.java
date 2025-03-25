package main;

import static main.GameStates.MENU;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

public class Render {
  
    private GameScreen gameScreen;
    private BufferedImage img;
    private ArrayList<BufferedImage> sprites = new ArrayList<BufferedImage>();
    private Random random;
    
        public Render(GameScreen gameScreen) {
            this.gameScreen = gameScreen;
            importImg();
            random = new Random();
            loadSprites();
    }

    public void renderGame(Graphics g) {
        switch (GameStates.gameState) {

            case MENU:

            for(int x = 0; x <32; x++){
                for(int y = 0; y < 18; y++){
                    g.drawImage(sprites.get(getRndInt()), x*32, y*32, null);
                }
              }

                break;
            case PLAYING:

                break;
            case SETTINGS:

                break;
            case EDIT:

                break;
            case GAME_OVER:

                break;
        }
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
}
