package controller;

import static view.gui.GameStates.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import view.gui.GameStates;
import view.gui.GameWindow;

public class KeyboardListener implements KeyListener {
	private GameWindow game;

	public KeyboardListener(GameWindow game) {
		this.game = game;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
	   if(e.getKeyCode() == KeyEvent.VK_Q) {
		   GameStates.gameState = MENU;
	       System.out.println("Menu");
	     }
		else if(e.getKeyCode() == KeyEvent.VK_W){
			GameStates.gameState = PLAYING;
		}


	   }
	   

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}