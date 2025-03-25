package main;

import static main.GameStates.MENU;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

public class Render {
    
    private GameWindow game;
    
        public Render(GameWindow game) {
            this.game = game;
            
            
            
    }

    public void renderGame(Graphics g) {
        switch (GameStates.gameState) {

            case MENU:
             game.getMenu().render(g);
                break;
            case PLAYING:
            game.getPlaying().render(g);

                break;
            case SETTINGS:

                break;
            case EDIT:

                break;
            case GAME_OVER:

                break;
        }
    }


   
}
