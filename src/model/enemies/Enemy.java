package model.enemies;

public class Enemy 
{   // Fields
    private double health;
    
    // Getters and Setters
    public int getX(){
        return 0;
    }

    public int getY() {
        return 0;
    }

    public void takeDamage(double damage) {
        this.health -= damage;
        if (this.health <= 0) {
            die();
        }
    }

    private void die() {
        System.out.println("Enemy has been defeated!");
        // Additional logic for removing the enemy from the game
    }

    public double getHealth() {
        return health;
    }
}
