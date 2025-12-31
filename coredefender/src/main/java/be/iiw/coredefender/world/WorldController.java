/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.iiw.coredefender.world;

/**
 *
 * @author kinga
 */
public class WorldController {
    private final WorldView worldView;

    public WorldController(int width, int height) {
        this.worldView = new WorldView(width, height);
    }

    public WorldView getView() {
        return worldView;
    }
}