package view.scenes;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import model.ImageLoader;
import view.components.ActionBar;
import view.gui.GameWindow;

public class Playing extends GameScene implements ScenesMethods {

    private int[][] lvl;
    private ActionBar sideBar;
    private int mouseX, mouseY;

    public Playing(GameWindow game) {
        super(game);

        loadDefaultLevel();
        sideBar = new ActionBar(1024, 0, 156, 640, this);
          
    }

    public void saveLevel(){
        ImageLoader.SaveLevel("new_level", lvl);
    }

    private void loadDefaultLevel() {
        lvl = ImageLoader.GetLevelData("new_level");
    }

    @Override
    public void render(Graphics g) {
        drawLevel(g);
        sideBar.draw(g);
    }

    private void drawLevel(Graphics g){
        for(int y = 0; y < lvl.length; y++){
            for(int x = 0; x < lvl[y].length; x++){
                int id = lvl[y][x];
                g.drawImage(getSprite(id), x * 32, y * 32, null);
            }
        }
    }
    
    public BufferedImage getSprite(int spriteID){
        return gameWindow.getTileManager().getSprite(spriteID);
    }

    @Override
    public void mouseClicked(int x, int y) {
        if (x >= 640) {
            sideBar.mouseClicked(x, y);
        } 
    }

    @Override
    public void mouseMoved(int x, int y) {
        if (x >= 640) {
			sideBar.mouseMoved(x, y);
		} else {
			mouseX = (x / 32) * 32;
			mouseY = (y / 32) * 32;
		}
    }

    @Override
    public void mousePressed(int x, int y) {
        if (x >= 640) {
            sideBar.mousePressed(x, y);
        }
    }

    @Override
    public void mouseReleased(int x, int y) {
            sideBar.mouseReleased(x, y);
    }

    @Override
    public void mouseDragged(int x, int y) {

	}
}
