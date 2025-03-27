package view.gui;

public enum GameStates {
  
       MENU, PLAYING, SETTINGS, EDIT, PAUSE, GAME_OVER;

	public static GameStates gameState = MENU;

	public static void SetGameState(GameStates state) {
		gameState = state;
	}

}
