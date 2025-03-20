package model.towers;

public class LaserTower extends Tower
{   // Fields
    //private double minDamage;
    private double maxDamage;

    // Constructor
    public LaserTower(int x, int y, int id)
    {
        super(400, 4, 0.25, 1, x, y, id, "Laser Tower");
        this.maxDamage = 1;
    }

    @Override
    protected void applyUpgradeEffects()
    {
        this.cost += 100;
        this.range += 3;
        this.damage += 1;
        this.maxDamage += 2;
    }
    
    @Override
    public void attack() 
    {
        // Perform the attack logic
        System.out.println("LaserTower fires a beam!");
        enemiesInRange.getFirst().takeDamageLaser(damage, maxDamage);
    }
}

