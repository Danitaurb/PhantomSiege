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
        return 0;
    }

    public int getY() {
        return 0;
    }
    
    public double getHealth() {
        return health;
    }    
    
	public void move() {
		
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
    
    private void dealDamage() {
    	
    }
}
