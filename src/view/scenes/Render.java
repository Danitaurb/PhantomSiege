package view.scenes;

import java.awt.Graphics;
import view.gui.GamePhase;
import static view.gui.GamePhase.MENU;
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
                gameWindow.getSettings().render(g);
                break;
            case EDIT:
                gameWindow.getEditor().render(g);
                break;
            default:
                break;
        }
    }

}
