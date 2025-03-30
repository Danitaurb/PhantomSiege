package view.gui;

public enum GamePhase {
  
    MENU, PLAYING, SETTINGS, EDIT, PAUSE, GAME_OVER;

	public static GamePhase gameState = MENU;

	public static void SetGameState(GamePhase state) {
		gameState = state;
	}

}
