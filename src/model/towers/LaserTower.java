package model.towers;

public class LaserTower extends Tower
{   // Costants
    private static final int COST_UPGRADE = 100;
    private static final int RANGE_UPGRADE = 3;
    private static final int DAMAGE_UPGRADE = 1;
    private static final int MAX_DAMAGE_UPGRADE = 2;

    // Fields
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
        this.cost += COST_UPGRADE;
        this.range += RANGE_UPGRADE;
        this.damage += DAMAGE_UPGRADE;
        this.maxDamage += MAX_DAMAGE_UPGRADE;
    }
    
    @Override
    public void attack() 
    {
        // Perform the attack logic
        System.out.println("LaserTower fires a beam!");
        enemiesInRange.getFirst().takeDamageLaser(damage, maxDamage);
    }
}

