/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.iiw.coredefender.world;

import be.iiw.coredefender.Collidables.Collidable;

/**
 *
 * @author Toon
 */

public class ResourceModel implements Collidable {

    private final ResourceType type;
    private final double x;
    private final double y;

    public ResourceModel(ResourceType type, double x, double y) {
        this.type = type;
        this.x = x;
        this.y = y;
    }

    public ResourceType getType() { return type; }
    @Override
    public double getX() { return x; }
    @Override
    public double getY() { return y; }
    
    @Override
    public double getRadius() {
        return 55;
    }
}

