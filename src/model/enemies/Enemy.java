package model.enemies;

public abstract class Enemy 
{   
	// Fields
    private double health;
    private double speed;
    private int reward;
    private int damage;
    private int x;
    private int y;
    
	public Enemy(double health, double speed, int reward, int damage, int x, int y) {
		this.health = health;
		this.speed = speed;
		this.reward = reward;
		this.damage = damage;
		this.x = x;
		this.y = y;
	}

	// Getters and Setters
    public int getX(){
        return x;
    }

    public int getY() {
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
        throw new UnsupportedOperationException("Unimplemented method 'takeDamageLaser'");
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
