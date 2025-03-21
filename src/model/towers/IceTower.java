package model.towers;

public class IceTower extends Tower
{
    // Constructor
    public IceTower(int x, int y, int id)
    {
        super(300, 2, 0.5, 2, x, y, id, "Ice Tower");
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
        // Perform the attack logic
        System.out.println("IceTower fires a burst of bullets!");
        enemiesInRange.getFirst().takeDamage(damage);
    }
}
