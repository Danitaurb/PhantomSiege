package model;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class ImageFix {
    //Rotate
    public static BufferedImage getRotImage(BufferedImage image, int rotAngle) {
        int w = image.getWidth();
        int h = image.getHeight();

        BufferedImage newImage = new BufferedImage(w, h, image.getType());
        Graphics2D g2D = newImage.createGraphics();

        g2D.rotate(Math.toRadians(rotAngle), w / 2, h / 2);
        g2D.drawImage(image, 0, 0, null);
        g2D.dispose();

        return newImage;
    }

    //Image layer build
    public static BufferedImage buildImage(BufferedImage[] images){
        int w = images[0].getWidth();
        int h = images[0].getHeight();

        BufferedImage newImage = new BufferedImage(w, h, images[0].getType());
        Graphics2D g2D = newImage.createGraphics();
    
        for(BufferedImage img: images) 
            g2D.drawImage(img, 0, 0, null);

        g2D.dispose(); 
        return newImage;       
    }

}
