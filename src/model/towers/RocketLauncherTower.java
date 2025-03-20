package model.towers;

public class RocketLauncherTower extends Tower
{   // Fields
    private int explosionArea; // Area of the explosion of the rocket

    // Constructor
    public RocketLauncherTower(int x, int y, int id) 
    {
        super(400, 2, 3, 0.5, x, y, id, "Rocket Launcher Tower");
        this.explosionArea = 1;
    }

    @Override
    protected void applyUpgradeEffects() 
    {
        this.cost += 100;
        this.range += 1;
        this.damage += 3;
        this.explosionArea += 1;
    }

    @Override
    public void attack() 
    {
        if (checkFireRate()) 
        {
            // Perform the attack logic
            System.out.println("RocketLaucher fires a rocket!");
            enemiesInRange.getFirst().takeDamage(damage); // Da finire
        } else {
            // Not enough time has passed to fire again
            System.out.println("RocketLauncher is reloading...");
        }
    }
}
