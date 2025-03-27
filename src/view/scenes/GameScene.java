package view.scenes;

import view.gui.GameWindow;

public class GameScene {
    protected GameWindow gameWindow;

    public GameScene(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
    }

    public GameWindow getGame() {
		return gameWindow;
	}
}
