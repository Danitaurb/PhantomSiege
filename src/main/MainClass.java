package main;

import view.gui.GameWindow;


public class MainClass 
{   
    public static void main(String[] args){
    GameWindow gameWindow = new GameWindow();
        gameWindow.getGameScreen().initInputs();
        gameWindow.start();

    }
}
