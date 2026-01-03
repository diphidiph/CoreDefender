package be.iiw.coredefender.pets;

public enum PetTypeEnum {

    DEFENDER("DEFENDER", "A fiery fox companion", 100, "Gold", 0, 1),
    COLLECTOR("COLLECTOR", "A cold and mysterious cat", 150, "Wood", 0, 1);

    private final String name;
    private final String description;
    private final int baseCost;
    private final String baseCostResourceType;
    private int xp;
    private int lvl;

    PetTypeEnum(String name, String description, int baseCost, String baseCostResourceType, int xp, int lvl) {
        this.name = name;
        this.description = description;
        this.baseCost = baseCost;
        this.baseCostResourceType = baseCostResourceType;
        this.xp = xp;
        this.lvl = lvl;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getBaseCost() {
        return baseCost;
    }

    public String getBaseCostResourceType() {
        return baseCostResourceType;
    }

    public int getXp() {
        return xp;
    }

    public int getLvl() {
        return lvl;
    }

    // Optional: methods to add XP and level up
    public void addXp(int amount) {
        this.xp += amount;
        checkLevelUp();
    }

    private void checkLevelUp() {
        // Example: every 100 XP = 1 level
        while (xp >= 100) {
            xp -= 100;
            lvl++;
        }
    }
}
