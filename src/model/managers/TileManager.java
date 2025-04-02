package model.managers;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import model.ImageFix;
import model.ImageLoader;
import model.map.Tile;

public class TileManager {

    public Tile GRASS_1, BR_WATER_CORNER, TL_WATER_CORNER;
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
        tiles.add(BR_WATER_CORNER = new Tile(ImageFix.buildImage(getImages(0, 0, 5, 0)), id++, "BR_Water_corner"));
        //BR_WATER_CORNER in realtà è un blocco (?)
        tiles.add(TL_WATER_CORNER = new Tile(ImageFix.getBuildRotImage(getImages(0, 0, 0, 5), 90, 1), id++, "TL_Water_corner"));
        //TL_WATER_CORNER sono rose girate (?)
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

    private BufferedImage[] getImages(int firstX, int firstY, int secondX, int secondY){
        return new BufferedImage[]{getSprite(firstX,firstY), getSprite(secondX, secondY)};
    }

    private void loadAtlas() {
        atlas = ImageLoader.getSpriteAtlas();
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
