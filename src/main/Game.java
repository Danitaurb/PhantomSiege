package main;

import view.gui.GameWindow;

public class Game {
    private GameWindow gameWindow;

    public Game() {
     
        gameWindow = new GameWindow();

        enebleInputs();
        startGame();


       // gameWindow.getGameScreen().initInputs();
       //gameWindow.start();

    }


    private void enebleInputs() {
        gameWindow.getGameScreen().initInputs();
    }

    private void startGame() {
        gameWindow.start();
    }

   


}
