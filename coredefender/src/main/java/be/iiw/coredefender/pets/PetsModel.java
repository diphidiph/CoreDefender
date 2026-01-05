/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.iiw.coredefender.pets;

import be.iiw.coredefender.character.CharacterModel;
import be.iiw.coredefender.world.ResourceType;
import static be.iiw.coredefender.world.ResourceType.STONE;
import static be.iiw.coredefender.world.ResourceType.TREE;
/**
 *
 * @author kinga
 */
//Bevat logica van pet: bewegen, speler volgen, harvest, xp verdienen
public class PetsModel {
    private final CharacterModel characterModel;
    private final Pet pet;
    private ResourceType harvestTarget;
    private static final double volgAfstand = 70;
    private static final double snelheid = 0.7;
    private static final double afstootKracht = 1.5;
    private static final long harvestTijd = 1000;
    private double x;
    private double y;
    private boolean harvesting = false;
    private boolean bewegenRichtingTarget = false;
    private double targetX;
    private double targetY;
    private long laatsteHarvestTijd = 0;

    // Pet "spawnt" naast character
    public PetsModel(CharacterModel characterModel, Pet pet) {
        this.characterModel = characterModel;
        this.pet = pet;

        this.x = characterModel.getX() + 80;
        this.y = characterModel.getY();
    }
    
    // Bepaalt wat de pet moet doen
    public void update() {
        // Pet onderweg richting target
        if(bewegenRichtingTarget) {
            moveToTarget();
            pushAwayFromOwner();
        }
        
        // Pet aan het harvesten
        else if(harvesting) {
            harvestTick();
            pushAwayFromOwner();
        }
        
        // Pet volgt character
        else {
            followOwner();
            pushAwayFromOwner();
        }
    }
    
    // Pet volgt character tot op een afstand
    private void followOwner() {
        double dx = characterModel.getX() - x;
        double dy = characterModel.getY() - y;
        double afstand = Math.sqrt(dx * dx + dy * dy);
        
        // Beweegt alleen indien afstand groot genoeg is
        if(afstand > volgAfstand) {
            x += (dx / afstand) * snelheid;
            y += (dy / afstand) * snelheid;
        }
    }

    // Beweegt pet richting target
    private void moveToTarget() {
        double dx = targetX - x;
        double dy = targetY - y;
        double afstand = Math.sqrt(dx * dx + dy * dy);

        // Indien dicht genoeg begint de pet met harvesten
        if(afstand < 5) {
            bewegenRichtingTarget = false;
            harvesting = true;
        }
        
        // Anders bewegen richting target
        else {
            x += (dx / afstand) * snelheid;
            y += (dy / afstand) * snelheid;
        }
    }

    // Harvesten met tijdsinterval
    private void harvestTick() {
        long now = System.currentTimeMillis();
        
        // Zorgt ervoor dat er niet te snel geharvest wordt
        if(now - laatsteHarvestTijd < harvestTijd) {
        }
        
        else {
            laatsteHarvestTijd = now;
            int amount = pet.getHarvestAmount();

            if(harvestTarget == null) {
            }
            
            // Harvest afhankelijk van resource type
            else {
                switch (harvestTarget) {
                    case TREE:
                        for (int i = 0; i < amount; i++) {
                            characterModel.addWood();
                            pet.addXp(1);
                        }
                    break;

                    case STONE:
                        for (int i = 0; i < amount; i++) {
                            characterModel.addStone();
                            pet.addXp(1);
                        }
                    break;
                }
            }
        }
    }
    
    // Start harvest opdracht
    public void startHarvest(ResourceType type, double x, double y) {
        this.harvestTarget = type;
        this.targetX = x;
        this.targetY = y;

        harvesting = false;
        bewegenRichtingTarget = true;
    }

    // Duwt pet weg van character indien te dicht bij elkaar
    private void pushAwayFromOwner() {
        double dx = x - characterModel.getX();
        double dy = y - characterModel.getY();
        double afstand = Math.sqrt(dx * dx + dy * dy);

        if(afstand < 35 && afstand > 0) {
            x += (dx / afstand) * afstootKracht;
            y += (dy / afstand) * afstootKracht;
        }
    }
    
    // Getters
    public double getX() {
        return x;
    }
    
    public double getY() {
        return y;
    }
    
    public Pet getPet() {
        return pet;
    }
}
