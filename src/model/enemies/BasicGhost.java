package model.enemies;

public class BasicGhost extends Enemy
{
    // Constructor
    public BasicGhost(double health, double speed, int reward, int damage, float x, float y, GhostType type) {
        super(health, speed, reward, damage, x, y, type);
    }

    // Factory method using the enum
    public static BasicGhost createGhost(GhostType type, float x, float y) {
        return new BasicGhost(type.getHealth(), type.getSpeed(), type.getReward(), type.getDamage(), x, y, type.getGhostType());
    }

}
