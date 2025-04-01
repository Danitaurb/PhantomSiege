package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import view.gui.GamePhase;
import view.gui.GameWindow;

public class MyMouseListener implements MouseListener, MouseMotionListener {

	private GameWindow gameWindow;

	public MyMouseListener(GameWindow gameWindow) {
		this.gameWindow = gameWindow;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		switch (GamePhase.gameState) {
		case MENU:
			gameWindow.getMenu().mouseDragged(e.getX(), e.getY());
			break;
		case PLAYING:
			gameWindow.getPlaying().mouseDragged(e.getX(), e.getY());
			break;
		case SETTINGS:
			//gameWindow.getSettings().mouseDragged(e.getX(), e.getY());
			break;
		default:
			break;
		}

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		switch (GamePhase.gameState) {
		case MENU:
			gameWindow.getMenu().mouseMoved(e.getX(), e.getY());
			break;
		case PLAYING:
			gameWindow.getPlaying().mouseMoved(e.getX(), e.getY());
			break;
		case SETTINGS:
			//gameWindow.getSettings().mouseMoved(e.getX(), e.getY());
			break;
		default:
			break;

		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {

			switch (GamePhase.gameState) {
			case MENU:
				gameWindow.getMenu().mouseClicked(e.getX(), e.getY());
				break;
			case PLAYING:
				gameWindow.getPlaying().mouseClicked(e.getX(), e.getY());
				break;
			case SETTINGS:
				//gameWindow.getSettings().mouseClicked(e.getX(), e.getY());
				break;
			default:
				break;

			}

		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		switch (GamePhase.gameState) {
		case MENU:
			gameWindow.getMenu().mousePressed(e.getX(), e.getY());
			break;
		case PLAYING:
			gameWindow.getPlaying().mousePressed(e.getX(), e.getY());
			break;
		case SETTINGS:
			//gameWindow.getSettings().mousePressed(e.getX(), e.getY());
			break;
		default:
			break;

		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		switch (GamePhase.gameState) {
		case MENU:
			gameWindow.getMenu().mouseReleased(e.getX(), e.getY());
			break;
		case PLAYING:
			gameWindow.getPlaying().mouseReleased(e.getX(), e.getY());
			break;
		case SETTINGS:
			//gameWindow.getSettings().mouseReleased(e.getX(), e.getY());
			break;
		default:
			break;

		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}



