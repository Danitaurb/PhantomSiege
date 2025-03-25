package scenes;

import main.GameWindow;

public class GameScene {
    private GameWindow gameWindow;

    public GameScene(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        // Evita di creare un'istanza di GameMenu o GameWindow qui
    }
}
