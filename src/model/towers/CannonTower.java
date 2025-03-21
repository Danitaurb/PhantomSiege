package model.towers;

//import java.util.List;

//import model.enemies.Enemy;

public class CannonTower extends Tower
{  
    // Constructor
    public CannonTower(int x, int y, int id)
    {
        super(250, 1, 2, 1, x, y, id, "Cannon Tower");
    }

    @Override
    protected void applyUpgradeEffects()
    {
        this.cost += 50;
        this.range += 1;
        this.damage += 1;
    }
    
    @Override
    public void attack() 
    {
        if (checkFireRate()) 
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