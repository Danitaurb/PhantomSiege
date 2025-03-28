package model.saves;

import java.util.List;

import model.enemies.Enemy;
import model.towers.Tower;

public class GameState {
    

    private int coins;
    private int health;
    private List<Tower> towers;
    private List<Enemy> enemies;


    private int currentWave;
    private int currentLevel;


    public GameState(int coins, int health, List<Tower> towers, List<Enemy> enemies, int currentWave, int currentLevel) {
        this.coins = coins;
        this.health = health;
        this.towers = towers;
        this.enemies = enemies;
        this.currentWave = currentWave;
        this.currentLevel = currentLevel;
    }


    
    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public List<Tower> getTowers() {
        return towers;
    }

    public void setTowers(List<Tower> towers) {
        this.towers = towers;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public void setEnemies(List<Enemy> enemies) {
        this.enemies = enemies;
    }

    public int getCurrentWave() {
        return currentWave;
    }

    public void setCurrentWave(int currentWave) {
        this.currentWave = currentWave;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

}
