package view.gui;

public enum GamePhase {
  
    MENU, PLAYING, SETTINGS, EDIT, PAUSE, GAME_OVER;

	public static GamePhase gamePhase = MENU;

	public static void setGamePhase(GamePhase phase) {
		gamePhase = phase;
	}

	public static GamePhase getGamePhase() {
		return gamePhase;
	}

}
