/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.iiw.coredefender.world;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kinga
 */
public class WorldModel {

    private final int width;
    private final int height;

    private final List<ResourceModel> resources = new ArrayList<>();

    public WorldModel(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() { return width; }
    public int getHeight() { return height; }

    public List<ResourceModel> getResources() {
        return resources;
    }
}
