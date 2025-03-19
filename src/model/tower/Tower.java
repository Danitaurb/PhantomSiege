package model.tower;

import java.util.List;

import model.enemy.Enemy;

public abstract class Tower 
{   // fields
    int cost;           // cost to build and update tower, in game currency
    int range;          // range of tower
    int level;          // level of tower
    double damage;      // damage of tower
    double fireRate;    // fire rate of tower
    int x;              // x coordinate of tower
    int y;              // y coordinate of tower
    int id;             // id of tower 
    List<Enemy> enemiesInRange; // list of enemies in range of tower

    // Constructor
    public Tower(int cost, int range, double damage, double fireRate, int x, int y, int id) 
    {
        this.cost = cost;
        this.range = range;
        this.damage = damage;
        this.fireRate = fireRate;
        this.x = x;
        this.y = y;
        this.id = id;
        this.level = 1;
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
    




    
}
