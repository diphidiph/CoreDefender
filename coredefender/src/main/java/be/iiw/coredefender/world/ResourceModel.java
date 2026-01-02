/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.iiw.coredefender.world;

/**
 *
 * @author Toon
 */

public class ResourceModel {

    private final ResourceType type;
    private final double x;
    private final double y;

    public ResourceModel(ResourceType type, double x, double y) {
        this.type = type;
        this.x = x;
        this.y = y;
    }

    public ResourceType getType() { return type; }
    public double getX() { return x; }
    public double getY() { return y; }
}
