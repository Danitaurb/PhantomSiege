package view.scenes;

import static view.gui.GamePhase.MENU;

import java.awt.Graphics;

import view.gui.GamePhase;
import view.gui.GameWindow;

public class Render {
    
    private GameWindow game;
    
        public Render(GameWindow game) {
            this.game = game;
            
    }

    public void renderGame(Graphics g) {
        switch (GamePhase.gameState) {

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
