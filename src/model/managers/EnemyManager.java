package model.managers;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import model.enemies.*;
import view.scenes.Playing;

public class EnemyManager 
{   // Fields
    private Playing playing;
    private BasicGhost whiteGhost;
    private BufferedImage[] ghostImages;

    public EnemyManager(Playing playing) 
    {
        this.playing = playing;
        ghostImages = new BufferedImage[10];
        whiteGhost = BasicGhost.createGhost(GhostType.WHITE, 0, 0);
        loadEnemyImages();
    }

    private void loadEnemyImages() {
    
    }

    public void update()
    {

    }

    public void draw(Graphics g)
    {
        drawEnemy(whiteGhost, g);
    }

    private void drawEnemy(Enemy ghost, Graphics g) 
    {
        g.drawImage(ghostImages[0], (int) ghost.getX(), (int) ghost.getY(), null);
        // g.drawImage(ghostImages[whiteGhost2.getId()], (int) whiteGhost2.getX(), (int) whiteGhost2.getY(), null);
    }








}




