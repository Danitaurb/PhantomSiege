package main;

public class Player 
{
	//Fields
	private int health;
	private int coins;
	
	//Constructor
	public Player(int health, int coins) {
		this.health = health;
		this.coins = coins;
	}
	
	public void lowerHealth(int damage) {
	        this.health -= damage;
	        if (this.health <= 0) {
	           // gameOver();
	        }
	    
	}
	
	
	
}
