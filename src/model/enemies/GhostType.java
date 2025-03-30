package model.enemies;

public enum GhostType 
{   // Enum values for different enemy types
    WHITE(1, 1, 10, 1),
	GREEN(2, 2, 20, 2),
	ORANGE(4, 3, 30, 3),
	BLUE(4, 3, 0, 4),
	RED(4, 3, 0, 4),
	TRANSPARENT(5, 3, 0, 5),
	ARMORED(5, 3, 0, 6),
	FAST(2, 8, 0, 6),
	SUMMONER(6, 2, 0, 6),
	RAINBOW(4, 3, 0, 6);

	private static GhostType ghostType;
	private final double health;
    private final double speed;
    private final int reward;
    private final int damage;

	GhostType(double health, double speed, int reward, int damage) {
		this.health = health;
		this.speed = speed;
		this.reward = reward;
		this.damage = damage;
	}

	public double getHealth() {
		return health;
	}

	public double getSpeed() {
		return speed;
	}

	public int getReward() {
		return reward;
	}

	public int getDamage() {
		return damage;
	}

	public int getId() {
		return this.ordinal();
	}
	
	public GhostType getGhostType() {
		return ghostType;
	}

	public static void SetGhostType(GhostType type) {
		ghostType = type;
	}

}
