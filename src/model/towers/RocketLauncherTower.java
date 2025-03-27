package model.towers;

import model.enemies.Enemy;
import model.managers.GameManager;

public class RocketLauncherTower extends Tower
{   // Costants
    private static final int COST_UPGRADE = 100;
    private static final int RANGE_UPGRADE = 1;
    private static final double DAMAGE_UPGRADE = 3;
    private static final int EXPLOSION_AREA_UPGRADE = 1;
    
    // Fields
    private int explosionArea; // Area of the explosion of the rocket
    private int targetX;
    private int targetY;

    // Constructor
    public RocketLauncherTower(int x, int y, int id) 
    {
        super(400, 2, 3, 0.5, x, y, id, "Rocket Launcher Tower");
        this.explosionArea = 1;
    }

    @Override
    protected void applyUpgradeEffects() 
    {
        this.cost += COST_UPGRADE;
        this.range += RANGE_UPGRADE;
        this.damage += DAMAGE_UPGRADE;
        this.explosionArea += EXPLOSION_AREA_UPGRADE;
    }

    @Override
    public void attack() 
    {
        if (isReadyToShoot()) 
        {
            // Perform the attack logic
            // Get the target enemy (e.g., the first enemy in range)
            Enemy target = enemiesInRange.getFirst();
            targetX = target.getX();
            targetY = target.getY();
            
            System.out.println("RocketLauncher fires a rocket at (" + targetX + ", " + targetY + ")!");
            // Deal full damage to the target enemy
            target.takeDamage(damage);

            // Deal explosion damage to other enemies in the circular explosion area
            for (Enemy enemy : GameManager.activeEnemies)
            {
                if (isInExplosionArea(enemy, targetX, targetY, explosionArea)) {
                    enemy.takeDamage(damage / 2); // Explosion deals half damage to nearby enemies
                }
            }
        } else {
            // Not enough time has passed to fire again
            System.out.println("RocketLauncher is reloading...");
        }
    }

    private boolean isInExplosionArea(Enemy enemy, int centerX, int centerY, int explosionArea) {
        int enemyX = enemy.getX();
        int enemyY = enemy.getY();
    
        // Calculate the Euclidean distance between the enemy and the explosion center
        double distance = Math.sqrt(Math.pow(enemyX - centerX, 2) + Math.pow(enemyY - centerY, 2));
    
        // Check if the distance is within the explosion radius
        return distance <= explosionArea;
    }
}
