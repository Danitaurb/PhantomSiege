package view.scenes;

import java.awt.Color;
import java.awt.Graphics;
import view.components.MyButton;
import view.gui.GameWindow;

public class Settings extends GameScene implements ScenesMethods {

    private MyButton bMenu;

    public Settings(GameWindow game) {
        super(game);
        initButtons();
    }

    private void initButtons() {
		bMenu = new MyButton("Menu", 2, 2, 100, 30);
	}

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(0, 0, 640, 640);

        drawButtons(g);
    }

    private void drawButtons(Graphics g) {
		bMenu.draw(g);
	}

    @Override
    public void mouseClicked(int x, int y) {
        
    }

    @Override
    public void mouseMoved(int x, int y) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseMoved'");
    }

    @Override
    public void mousePressed(int x, int y) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mousePressed'");
    }

    @Override
    public void mouseReleased(int x, int y) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseReleased'");
    }

    @Override
	public void mouseDragged(int x, int y) {
		// TODO Auto-generated method stub
		
	}

}
