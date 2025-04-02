package view.components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import model.map.Tile;
import static view.gui.GamePhase.*;
import view.scenes.Editing;

public class ToolBar extends Bar{
    private Editing editing;
    private MyButton bMenu, bSave;
    private Tile selectedTile;

    private ArrayList<MyButton> tileButtons = new ArrayList<>();

    public ToolBar(int x, int y, int width, int height, Editing editing){
        super(x, y, width, height);
        this.editing = editing;
        initButtons();
    }

    private void initButtons() {
        bMenu = new MyButton("Menu", 1037, 4, 90, 30);
        bSave = new MyButton("Save", 1037, 40, 90, 30);

        int w = 50;
        int h = 50;
        int xStart = 1056;
        int yStart = 150;
        int yOffset = (int) (h * 1.2f);

        int i = 0;
        for (Tile tile : editing.getGame().getTileManager().tiles) {
            tileButtons.add(new MyButton(tile.getName(), xStart, yStart + (i * yOffset), w, h, tile.getId()));
            i++;
        }
    }

    private void saveLevel() {
        editing.saveLevel();
    }

    public void draw(Graphics g) {
        //Background
        g.setColor(new Color(220, 123, 15));
        g.fillRect(x, y, width, height);

        //Buttons
        drawButtons(g);
    }   

    public void drawButtons(Graphics g) {
        bMenu.draw(g);
        bSave.draw(g);
        drawTileButtons(g);
        drawSelectedTile(g);
    }

    private void drawSelectedTile(Graphics g) {
        if (selectedTile != null) {
            g.drawImage(selectedTile.getSprite(), 1056, 90, 50, 50, null);
            g.setColor(Color.black);
            g.drawRect(550, 650, 50, 50);
        }
    }
        
    private void drawTileButtons(Graphics g) {
                
        for (MyButton b : tileButtons) {

            //Sprite
            g.drawImage(getButtId(b.getId()), b.x, b.y, b.width, b.height, null);

            //Mouseover
            if (b.isMouseOver()) {
                g.setColor(Color.white);
            } else {
                g.setColor(Color.BLACK);
            }

            //Border
            g.drawRect(b.x, b.y, b.width, b.height);

            //Mousepressed
            if (b.isMousePressed()) {
				g.drawRect(b.x + 1, b.y + 1, b.width - 2, b.height - 2);
				g.drawRect(b.x + 2, b.y + 2, b.width - 4, b.height - 4);
			}
        }
    }

    public BufferedImage getButtId(int id){
        return editing.getGame().getTileManager().getSprite(id);
    }

    public void mouseClicked(int x, int y) {
        if (bMenu.getBounds().contains(x, y)) 
            setGamePhase(MENU);
        else if (bSave.getBounds().contains(x, y))
            saveLevel();
        else {
            for (MyButton b : tileButtons) {
                if (b.getBounds().contains(x, y)) {
                    selectedTile = editing.getGame().getTileManager().getTile(b.getId());
                    editing.setSelectedTile(selectedTile);
                    return;
                }
            }
        }
    }

    public void mouseMoved(int x, int y) {
        bMenu.setMouseOver(false);
        bSave.setMouseOver(false);
        for (MyButton b : tileButtons) {
            b.setMouseOver(false);
        }

        if (bMenu.getBounds().contains(x, y)) {
            bMenu.setMouseOver(true);
        } else if (bSave.getBounds().contains(x, y)) {
            bSave.setMouseOver(true);
        } else {
            for (MyButton b : tileButtons) {
                if (b.getBounds().contains(x, y)) {
                    b.setMouseOver(true);
                    return;
                }
            }
        }
    }

    public void mousePressed(int x, int y) {
        if (bMenu.getBounds().contains(x, y)) {
            bMenu.setMousePressed(true);
        } else if (bSave.getBounds().contains(x, y)) {  
            bSave.setMousePressed(true);
        } else {
            for (MyButton b : tileButtons) {
                if (b.getBounds().contains(x, y)) {
                    b.setMousePressed(true);
                    return;
                }
            }
        }
    }

    public void mouseReleased(int x, int y) {
        bMenu.resetBooleans();
        bSave.resetBooleans();
        for (MyButton b : tileButtons) {
            b.resetBooleans();
        }
    }
}
