package inputs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import main.GameStates;
import main.GameWindow;

public class MyMouseListener implements MouseListener, MouseMotionListener {

	private GameWindow game;

	public MyMouseListener(GameWindow game) {
		this.game = game;
	}
    
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
    
    public void mouseMoved(MouseEvent e) {
        switch (GameStates.gameState)
        {
            case MENU:
                game.getMenu().mouseMoved(e.getX(), e.getY());
                break;
            case PLAYING:
                break;
            case SETTINGS:
                break;
            default:
                break;
        }
    }

    public void mouseClicked(MouseEvent e) {
       if (e.getButton() == MouseEvent.BUTTON1) {
        switch (GameStates.gameState)
        {
            case MENU:
                game.getMenu().mouseClicked(e.getX(), e.getY());
                break;
            case PLAYING:
                break;
            case SETTINGS:
                break;
            default:
                break;
        }
       }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        switch (GameStates.gameState)
        {
            case MENU:
                game.getMenu().mousePressed(e.getX(), e.getY());
                break;
            case PLAYING:
                break;
            case SETTINGS:
                break;
            default:
                break;
        }
       }

    public void mouseReleased(MouseEvent e) {
        switch (GameStates.gameState)
        {
            case MENU:
                game.getMenu().mouseReleased(e.getX(), e.getY());
                break;
            case PLAYING:
                break;
            case SETTINGS:
                break;
            default:
                break;
        }
    }

    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
    }
}


