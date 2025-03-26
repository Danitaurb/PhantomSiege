package scenes;

import help.LevelBuild;
import java.awt.Graphics;
import main.GameWindow;
import managers.TileManager;

public class Playing extends GameScene implements ScenesMethods {

    private int[][] lvl;
    private TileManager tileManager;


    public Playing(GameWindow game) {
        super(game);

        lvl = LevelBuild.getLevelData();
        tileManager = new TileManager();
        //the lvl
        //tilemanager
    }

    @Override
    public void render(Graphics g) {
        //g.setColor(Color.DARK_GRAY);
        //g.fillRect(0, 0, 1024, 576);
        for(int y = 0; y < lvl.length; y++){
            for(int x = 0; x < lvl[y].length; x++){
                int id = lvl[y][x];
                g.drawImage(tileManager.getSprite(id), x * 32, y * 32, null);
            }
        }
        
    }

    public void callMe() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseClicked(int x, int y) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseClicked'");
    }

    @Override
    public void mouseMoved(int x, int y) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseMoved'");
    }



}
