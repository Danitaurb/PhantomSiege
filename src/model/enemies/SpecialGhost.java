package model.enemies;

public class SpecialGhost extends Enemy
{
    // Constructor
    public SpecialGhost(double health, double speed, int reward, int damage, float x, float y, GhostType type) {
        super(health, speed, reward, damage, x, y, type);
    }

    // Factory method using the enum
    public static SpecialGhost createGhost(GhostType type, float x, float y) {
        return new SpecialGhost(type.getHealth(), type.getSpeed(), type.getReward(), type.getDamage(), x, y, type.getGhostType());
    }

}
