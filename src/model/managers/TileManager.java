package model.managers;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import model.map.Tile;
import model.saves.LoadSave;

public class TileManager {

    public Tile GRASS, WATER, ROAD;
    public BufferedImage atlas;
    public ArrayList<Tile> tiles = new ArrayList<>();

    public TileManager() {
        loadAtlas();
        createTiles();
    }

    private void createTiles() {
        int id = 0;
        tiles.add(ROAD = new Tile(getSprite(8, 1), id++, "Road"));
        tiles.add(GRASS = new Tile(getSprite(0, 6), id++, "Grass"));
        tiles.add(WATER = new Tile(getSprite(9, 8), id++, "Water"));
    }

    private void loadAtlas() {
        atlas = LoadSave.getSpriteAtlas();
    }

    public Tile getTile(int id) {
        return tiles.get(id);
    }

    public BufferedImage getSprite(int id) {
        return tiles.get(id).getSprite();
    }
                        
    private BufferedImage getSprite(int xCord, int yCord){
        return atlas.getSubimage(xCord * 32, yCord * 32, 32, 32);
    }
                       
}
