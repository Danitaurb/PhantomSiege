package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static main.GameStates.*;

import main.GameWindow;
import main.GameStates;

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
	   if(e.getKeyCode() == KeyEvent.VK_W) {
	       System.out.println("W is pressed");
	   }
	   
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}