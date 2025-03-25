package scenes;

import java.awt.Color;
import java.awt.Graphics;

import main.GameWindow;

public class Playing extends GameScene implements ScenesMethods {

    public Playing(GameWindow game) {
        super(game);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 0, 1024, 576);
        
    }

    @Override
    public void callMe() {
        // TODO Auto-generated method stub
        
    }



}
