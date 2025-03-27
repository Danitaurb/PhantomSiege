package scenes;

import help.LevelBuild;
import java.awt.Graphics;
import main.GameWindow;
import managers.TileManager;
import ui.BottomBar;

public class Playing extends GameScene implements ScenesMethods {

    private int[][] lvl;
    private TileManager tileManager;

    private BottomBar bottomBar;

    public Playing(GameWindow game) {
        super(game);

        lvl = LevelBuild.getLevelData();
        tileManager = new TileManager();
        bottomBar = new BottomBar(0, 640, 1050, 100, this);
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
        bottomBar.draw(g);
        
    }

    public TileManager getTileManager(){
        return tileManager;
    }

    public void callMe() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseClicked(int x, int y) {
        if (y >= 640) {
            bottomBar.mouseClicked(x, y);
        }
    }
    
    @Override
    public void mouseMoved(int x, int y) {
        if (y >= 640) {
            bottomBar.mouseMoved(x, y);
        }
    }

    @Override
    public void mousePressed(int x, int y) {
        if (y >= 640) {
            bottomBar.mousePressed(x, y);
        }
    }

    @Override
    public void mouseReleased(int x, int y) {
            bottomBar.mouseReleased(x, y);
        }
}
