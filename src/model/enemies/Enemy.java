package model.enemies;

import java.awt.Rectangle;

public abstract class Enemy 
{   
	// Fields
    private double health;
    private double speed;
    private int reward;
    private int damage;
    private float x;
    private float y;
    private Rectangle hitbox;
    private GhostType type;

    // Constructor
	public Enemy(double health, double speed, int reward, int damage, float x, float y, GhostType type) {
		this.health = health;
		this.speed = speed;
		this.reward = reward;
		this.damage = damage;
		this.x = x;
		this.y = y;
        this.type = type;
        this.hitbox = new Rectangle((int)x, (int)y, 32, 32); // Example hitbox size
	}

	// Getters and Setters
    public float getX(){
        return x;
    }

    public float getY() {
        return y;
    }
    
    public double getHealth() {
        return health;
    }  

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    // Methods
	public void move() {
		// TODO
	}

    public void takeDamage(double damage) {
        this.health -= damage;
        if (this.health <= 0) {
            die();
        }
    }

    public void takeDamageLaser(double damage, double maxDamage) {
        // TODO Auto-generated method stub
        
    }

    private void die()
    {
        System.out.println("Enemy has been defeated!");
        // Additional logic for removing the enemy from the game
    }
    
    public void dealDamage() {
    	// TODO
    }

    
}
