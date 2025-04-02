package view.scenes;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import model.ImageLoader;
import model.map.Tile;
import view.components.ToolBar;
import view.gui.GameWindow;

public class Editing extends GameScene /*implements ScenesMethods*/{
    
    private int[][] lvl;
    private Tile selectedTile;
    private int mouseX, mouseY;
    private int lastTileX, lastTileY, lastTileId;
    private boolean drawSelect;
    private ToolBar toolBar;

    public Editing(GameWindow gameWindow) {
        super(gameWindow);
        loadDefaultLevel();
        toolBar = new ToolBar(1024, 0, 156, 640, this);
    }

    private void loadDefaultLevel() {
        lvl = ImageLoader.GetLevelData("new_level");
    }

    public void render(Graphics g){
        drawLevel(g);
        toolBar.draw(g);;
        drawSelectedTile(g);
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

    public void saveLevel(){
        ImageLoader.SaveLevel("new_level", lvl);
    }

    private void drawSelectedTile(Graphics g) {
        if (selectedTile != null && drawSelect) {
            g.drawImage(selectedTile.getSprite(), mouseX, mouseY, 32, 32, null);
        }
    }

    public void setSelectedTile(Tile tile) {
        this.selectedTile = tile;
        drawSelect = true;
    }

    public void changeTile(int x, int y) {
		if (selectedTile != null) {

			int tileX = x / 32;
			int tileY = y / 32;

			if (lastTileX == tileX && lastTileY == tileY && lastTileId == selectedTile.getId())
				return;

			lastTileX = tileX;
			lastTileY = tileY;
			lastTileId = selectedTile.getId();

			lvl[tileY][tileX] = selectedTile.getId();
		}
	}

    public ToolBar getToolBar() {
        return toolBar;
    }

    public void setDrawSelect(boolean drawSelect) {
        this.drawSelect = drawSelect;
    }

    public void setMousePosition(int mouseX, int mouseY) {
        this.mouseX = mouseX;
        this.mouseY = mouseY;
    }

}
