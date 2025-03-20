package model.towers;

import java.util.List;

import model.enemies.Enemy;

public abstract class Tower 
{   // Costants
    private static final int MAX_LEVEL = 3;

    // Fields
    int cost;           // cost to build and update tower, in game currency
    int range;          // range of tower
    int level;          // level of tower
    double damage;      // damage of tower
    double fireRate;    // fire rate of tower
    int x;              // x coordinate of tower
    int y;              // y coordinate of tower
    String name;        // name of tower
    int id;             // id of tower 
    List<Enemy> enemiesInRange; // list of enemies in range of tower
    private long lastAttackTime; // time of last attack

    // Constructor
    public Tower(int cost, int range, double damage, double fireRate, int x, int y, int id, String name) 
    {
        this.cost = cost;
        this.range = range;
        this.damage = damage;
        this.fireRate = fireRate;
        this.x = x;
        this.y = y;
        this.id = id;
        this.level = 1;
        this.name = name;
    }

    // Getters and Setters
    public int getCost() {
        return cost;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public double getFireRate() {
        return fireRate;
    }

    public void setFireRate(double fireRate) {
        this.fireRate = fireRate;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Enemy> getEnemiesInRange() {
        return enemiesInRange;
    }

    public void setEnemiesInRange(List<Enemy> enemiesInRange) {
        this.enemiesInRange = enemiesInRange;
    }
    
    // Abstract methods
    protected abstract void applyUpgradeEffects(); // abstract method to apply upgrade effects
    public abstract void attack();                 // abstract method to attack enemies

    // Methods
    public boolean upgrade()
    {
        if(this.level >= MAX_LEVEL) // checks if tower is already at max level
        {
            return false;
        }
        this.level++;

        applyUpgradeEffects();
        
        return true;
    }
    
    public boolean isInRange(Enemy enemy) // method to check if enemy is in range of tower
    {
        double distance = Math.sqrt(Math.pow(this.x - enemy.getX(), 2) + Math.pow(this.y - enemy.getY(), 2));
        if(distance <= this.range)
        {
            enemiesInRange.add(enemy);
            return true;
        }
        else if(enemiesInRange.contains(enemy)) // if enemy is not in range, remove from list
        {
            enemiesInRange.remove(enemy);       
        }
        return false;
    }

    public void findTarget() // method to find target enemy
    {
        for(Enemy enemy : enemiesInRange)
        {
            if(isInRange(enemy))
            {
                attack();
                break;
            }
        }
    }

    protected boolean checkFireRate() // method to check if tower can fire
    {
        long currentTime = System.currentTimeMillis(); // Get the current time in milliseconds
        if (currentTime - lastAttackTime >= 1000 / fireRate) 
        {
            lastAttackTime = currentTime;
            return true;
        }
        return false;
    }
}
