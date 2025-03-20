package model.towers;

//import java.util.List;

//import model.enemies.Enemy;

public class CannonTower extends Tower
{
    /* Fields
    int cost;           // cost to build and update tower, in game currency
    double damage;      // damage of tower
    int range;          // range of tower
    int level;          // level of tower
    double fireRate;    // fire rate of tower
    String name;        // name of tower
    int id;             // id of tower 
    List<Enemy> enemiesInRange; // list of enemies in range of tower*/
    
    
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