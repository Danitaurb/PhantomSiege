package model.towers;

import java.util.ArrayList;
import java.util.List;
import model.enemies.Enemy;

public class FlameThrowerTower extends Tower 
{   // Costants
    private static final int COST_UPGRADE = 75;
    private static final int RANGE_UPGRADE = 1;
    private static final double DAMAGE_UPGRADE = 1;
    private static final int FLAME_LENGTH_UPGRADE = 1;

    private double theta; // Angle of the flame (in radians)
    int flameWidth = 1;   // Width of the flame
    int flameLength = 3;  // Length of the flame

    // Costruttore
    public FlameThrowerTower(int x, int y, int id) 
    {
        super(350, 3, 2, 1, x, y, id, "Flame Thrower Tower");
        this.theta = 0;  // Imposta la direzione iniziale
    }

    @Override
    protected void applyUpgradeEffects() 
    {
        this.cost += COST_UPGRADE;
        this.range += RANGE_UPGRADE;
        this.damage += DAMAGE_UPGRADE;
        this.flameLength += FLAME_LENGTH_UPGRADE;
    }
    
    @Override
    public void attack() 
    {
        System.out.println("FlameThrowerTower fires a burst of flames!");

        // Calculate the directional vector (dx, dy) of the flame
        double dx = Math.cos(theta);
        double dy = Math.sin(theta);

        // List of enemies hit by the flame
        List<Enemy> targets = getEnemiesInFlameArea(dx, dy, flameWidth, flameLength);
        
        // Deals damage to all enemies hit by the flame
        for (Enemy e : targets) 
        {
            e.takeDamage(damage);
            //System.out.println("Nemico colpito: " + e.getName());
        }
    }

    // Method to get the enemies in the flame area
    private List<Enemy> getEnemiesInFlameArea(double dx, double dy, int width, int length) 
    {
        List<Enemy> hitEnemies = new ArrayList<>();

        for (Enemy e : enemiesInRange) 
        {
            // Calculate the enemy's position relative to the tower
            double ex = e.getX() - this.x;
            double ey = e.getY() - this.y;

            // Projects the enemy along the direction of the flame
            double proj = ex * dx + ey * dy;

            // Checks if the enemy is within the flame's length and width
            if (proj > 0 && proj < length) 
            {
                double perpendicularDist = Math.abs(ex * dy - ey * dx);
                if (perpendicularDist < width / 2.0) {
                    hitEnemies.add(e);
                }
            }
        }
        return hitEnemies;
    }

    // Method to set the direction of the flame
    public void setDirection(double newTheta) {
        this.theta = newTheta;
    }
}
