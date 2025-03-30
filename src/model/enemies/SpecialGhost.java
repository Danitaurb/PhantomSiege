package model.enemies;

public class SpecialGhost extends Enemy
{
    // Constructor
    public SpecialGhost(double health, double speed, int reward, int damage, int id, float x, float y, GhostType type) {
        super(health, speed, reward, damage, id, x, y, type);
    }

    // Factory method using the enum
    public static SpecialGhost createGhost(GhostType type, float x, float y) {
        return new SpecialGhost(type.getHealth(), type.getSpeed(), type.getReward(), type.getDamage(), type.getId(), x, y, type.getGhostType());
    }

}
