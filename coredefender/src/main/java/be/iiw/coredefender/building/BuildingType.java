/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package be.iiw.coredefender.building;

/**
 *
 * @author Gebruiker
 */
public enum BuildingType {
    GOLDMINE(72,72), 
    GOLDSTASH(72,72), 
    CANON(72,72), 
    WALL(36,36);
    
    
    private final int width;
    private final int height;

    BuildingType(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() { 
        return width; 
    }
    public int getHeight() { 
        return height; 
    }
}
