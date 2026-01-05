/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.iiw.coredefender.pets;

/**
 *
 * @author kinga
 */
public class Pet {
    private final PetTypeEnum type;
    private final String naam;
    private final String beschrijving;
    private final int beginPrijs;
    private final String beginPrijsResourceType;
    private int xp;
    private int level;

    // Maakt een nieuwe pet aan met type
    public Pet(PetTypeEnum type) {
        this.type = type;
        this.xp = 0;
        this.level = 1;

        // Bepaal eigenschappen op basis van het type
        switch (type) {
            case DEFENDER:
                naam = "DEFENDER";
                beschrijving = "A fiery fox companion";
                beginPrijs = 100;
                beginPrijsResourceType = "Gold";
                break;

            case COLLECTOR:
                naam = "COLLECTOR";
                beschrijving = "A cold and mysterious cat";
                beginPrijs = 150;
                beginPrijsResourceType = "Wood";
                break;

            // Gebeurd nooit buiten als er een fout is in de code
            default:
                throw new IllegalStateException("Unknown pet type: " + type);
        }
    }

    // Getters
    public PetTypeEnum getType() {
        return type;
    }
    
    public String getName() {
        return naam;
    }
    
    public String getDescription() {
        return beschrijving;
    }
    
    public int getBaseCost() {
        return beginPrijs;
    }
    
    public String getBaseCostResourceType() {
        return beginPrijsResourceType;
    }
    
    public int getXp() {
        return xp;
    }
    
    public int getLevel() {
        return level;
    }

    // Bepaalt hoeveel resources het pet harvest
    public int getHarvestAmount() {
        return level;
    }

    // Berekent hoeveel xp nodig is voor het volgende level
    public int getXpNextLevel() {
        return 100 + (level - 1) * 50;
    }

    // Kijkt of de pet genoeg XP heeft om te lvl up te gaan
    private void checkLevelUp() {
        int neededXp = getXpNextLevel();

        if (xp >= neededXp) {
            xp -= neededXp;
            level++;
        }
    }
    
    public void addXp(int amount) {
        xp += amount;
        checkLevelUp();
    }
}