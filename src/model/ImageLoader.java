package model;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class ImageLoader {
    public static BufferedImage getSpriteAtlas(){

        BufferedImage img = null;

        InputStream is = ImageLoader.class.getClassLoader().getResourceAsStream("assets/32x32_map_tile.png");
        try {
            img = ImageIO.read(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return img;
    }

}
