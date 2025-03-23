package model.towers;

public class IceTower extends Tower
{   // Costants
    private static final int COST_UPGRADE = 50;
    private static final int RANGE_UPGRADE = 1;
    private static final double DAMAGE_UPGRADE = 1.25;

    // Constructor
    public IceTower(int x, int y, int id)
    {
        super(300, 2, 0.5, 2, x, y, id, "Ice Tower");
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
        // Perform the attack logic
        System.out.println("IceTower fires a burst of bullets!");
        enemiesInRange.getFirst().takeDamage(damage);
    }
}
