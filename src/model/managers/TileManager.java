package model.managers;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import model.map.Tile;
import model.saves.LoadSave;

public class TileManager {

    public Tile GRASS_1, GRASS_2, GRASS_3, GRASS_4, GRASS_5, GRASS_6, GRASS_7, GRASS_8, GRASS_9,
                GRASS_10, GRASS_11, GRASS_12, GRASS_13, GRASS_14, GRASS_15, GRASS_16;
    public Tile FLOWER_1, FLOWER_2, FLOWER_3;
    public Tile TRUNK;
    public Tile ROCK_1, ROCK_2, ROCK_3, ROCK_4;

    public Tile  WATER, ROAD;
    public BufferedImage atlas;
    public ArrayList<Tile> tiles = new ArrayList<>();

    public TileManager() {
        loadAtlas();
        createTiles();
    }

    private void createTiles() {
        int id = 0;
        tiles.add(GRASS_1 = new Tile(getSprite(0, 0), id++, "Grass_1"));
        tiles.add(GRASS_2 = new Tile(getSprite(1, 0), id++, "Grass_2"));
        tiles.add(GRASS_3 = new Tile(getSprite(2, 0), id++, "Grass_3"));
        tiles.add(GRASS_4 = new Tile(getSprite(0, 1), id++, "Grass_4"));
        tiles.add(GRASS_5 = new Tile(getSprite(1, 1), id++, "Grass_5"));
        tiles.add(GRASS_6 = new Tile(getSprite(2, 1), id++, "Grass_6"));
        tiles.add(GRASS_7 = new Tile(getSprite(0, 2), id++, "Grass_7"));
        tiles.add(GRASS_8 = new Tile(getSprite(1, 2), id++, "Grass_8"));
        tiles.add(GRASS_9 = new Tile(getSprite(2, 2), id++, "Grass_9"));
        tiles.add(GRASS_10 = new Tile(getSprite(0, 3), id++, "Grass_10"));
        tiles.add(GRASS_11 = new Tile(getSprite(1, 3), id++, "Grass_11"));
        tiles.add(GRASS_12 = new Tile(getSprite(2, 3), id++, "Grass_12"));
        tiles.add(GRASS_13 = new Tile(getSprite(0, 4), id++, "Grass_13"));
        tiles.add(GRASS_14 = new Tile(getSprite(1, 4), id++, "Grass_14"));
        tiles.add(GRASS_15 = new Tile(getSprite(2, 4), id++, "Grass_15"));
        tiles.add(GRASS_16 = new Tile(getSprite(1, 5), id++, "Grass_16"));
        tiles.add(FLOWER_1 = new Tile(getSprite(0, 5), id++, "Flower_1"));
        tiles.add(FLOWER_2 = new Tile(getSprite(2, 5), id++, "Flower_2"));
        tiles.add(FLOWER_3 = new Tile(getSprite(2, 6), id++, "Flower_3"));
        tiles.add(TRUNK = new Tile(getSprite(1, 6), id++, "Trunk"));
        tiles.add(ROCK_1 = new Tile(getSprite(0, 6), id++, "Rock_1"));
        tiles.add(ROCK_2 = new Tile(getSprite(0, 7), id++, "Rock_2"));
        tiles.add(ROCK_3 = new Tile(getSprite(1, 7), id++, "Rock_3"));
        tiles.add(ROCK_4 = new Tile(getSprite(2, 7), id++, "Rock_4"));
        
        tiles.add(ROAD = new Tile(getSprite(8, 1), id++, "Road"));
        
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
