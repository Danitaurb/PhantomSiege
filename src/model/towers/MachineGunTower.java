package model.towers;

public class MachineGunTower extends Tower
{   // Costants
    private static final int COST_UPGRADE = 50;
    private static final int RANGE_UPGRADE = 1;
    private static final double DAMAGE_UPGRADE = 1.25;

    // Constructor
    public MachineGunTower(int x, int y, int id)
    {
        super(300, 2, 0.5, 2, x, y, id, "Machine Gun Tower");
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
            System.out.println("MachineGunTower fires a burst of bullets!");
            enemiesInRange.getFirst().takeDamage(damage);
        } else {
            // Not enough time has passed to fire again
            System.out.println("MachineGunTower is reloading...");
        }
    }

}
