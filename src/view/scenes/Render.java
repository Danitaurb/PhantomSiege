package view.scenes;

import static view.gui.GamePhase.MENU;

import java.awt.Graphics;

import view.gui.GamePhase;
import view.gui.GameWindow;

public class Render {
    
    private GameWindow gameWindow;
    
        public Render(GameWindow gameWindow) {
            this.gameWindow = gameWindow;
            
    }

    public void renderGame(Graphics g) {
        switch (GamePhase.gameState) {

            case MENU:
             gameWindow.getMenu().render(g);
                break;
            case PLAYING:
            gameWindow.getPlaying().render(g);

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
