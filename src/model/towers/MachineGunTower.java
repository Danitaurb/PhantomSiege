package model.towers;

public class MachineGunTower extends Tower
{ 
    // Constructor
    public MachineGunTower(int x, int y, int id)
    {
        super(300, 2, 0.5, 2, x, y, id, "Machine Gun Tower");
    }

    @Override
    protected void applyUpgradeEffects()
    {
        this.cost += 50;
        this.range += 1;
        this.damage += 1.25;
    }
    
    @Override
    public void attack() 
    {
        if (checkFireRate()) 
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
