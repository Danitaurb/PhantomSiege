package model.towers;

//import java.util.List;

//import model.enemies.Enemy;

public class CannonTower extends Tower
{   // Costants
    private static final int COST_UPGRADE = 50;
    private static final int RANGE_UPGRADE = 1;
    private static final double DAMAGE_UPGRADE = 1;

    // Constructor
    public CannonTower(int x, int y, int id)
    {
        super(250, 1, 2, 1, x, y, id, "Cannon Tower");
    }

    @Override
    protected void applyUpgradeEffects()
    {
        this.cost += COST_UPGRADE;
        this.range += RANGE_UPGRADE;
        this.damage += DAMAGE_UPGRADE;
    }
    
    @Override
    public void attack() 
    {
        if (isReadyToShoot()) 
        {
            // Perform the attack logic
            System.out.println("CannonTower fires a projectile!");
            enemiesInRange.getFirst().takeDamage(damage);
        } else {
            // Not enough time has passed to fire again
            System.out.println("CannonTower is reloading...");
        }
    }
}