package model.managers;

import model.enemies.BlueGhost;
import model.enemies.Enemy;
import model.enemies.GreenGhost;
import model.enemies.OrangeGhost;
import model.enemies.RedGhost;
import model.enemies.TransparentGhost;
import model.enemies.WhiteGhost;
import view.scenes.Playing;

public class EnemyManager 
{   // Fields
    private Playing playing;
    private WhiteGhost whiteGhost;
    private GreenGhost greenGhost;
    private OrangeGhost orangeGhost;
    private RedGhost redGhost;
    private BlueGhost blueGhost;
    private TransparentGhost transparentGhost;


    public EnemyManager(Playing playing) 
    {
        this.playing = playing;
        /*this.whiteGhost = new WhiteGhost(100, 1, 10, 5, 0, 0); // Example values
        this.greenGhost = new GreenGhost(150, 1.5, 15, 7, 0, 0); // Example values
        this.orangeGhost = new OrangeGhost(200, 2, 20, 10, 0, 0); // Example values
        this.redGhost = new RedGhost(250, 2.5, 25, 12, 0, 0); // Example values
        this.blueGhost = new BlueGhost(300, 3, 30, 15, 0, 0); // Example values
        this.transparentGhost = new TransparentGhost(350, 3.5, 35, 20, 0, 0); // Example values*/
    }

}
