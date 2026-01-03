/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.iiw.coredefender.world;

import java.util.Random;

/**
 *
 * @author kinga
 */
public class WorldController {

    private final WorldModel model;
    private final WorldView view;
    private final Random random = new Random();

    public WorldController(int width, int height, int viewWidth, int viewHeight) {
        this.model = new WorldModel(width, height);
        this.view = new WorldView(width, height, viewWidth, viewHeight);
        
        generateResources(1500);
        view.renderResources(model.getResources());
    }

    private void generateResources(int amount) {
        for (int i = 0; i < amount; i++) {
            model.getResources().add(new ResourceModel(ResourceType.TREE,random.nextInt(model.getWidth() * 36),random.nextInt(model.getHeight()) * 36));

            model.getResources().add(new ResourceModel(ResourceType.STONE,random.nextInt(model.getWidth() * 36), random.nextInt(model.getHeight()) * 36));
        }
    }
    
    public ResourceModel getClosestResource(double x, double y, double maxDist) {
        ResourceModel closest = null;
        double best = Double.MAX_VALUE;

        for (ResourceModel r : model.getResources()) {
            double dx = x - r.getX();
            double dy = y - r.getY();
            double d = Math.sqrt(dx * dx + dy * dy);

            if (d < maxDist && d < best) {
                best = d;
                closest = r;
            }
        }
        return closest;
    }
    
    public void update(double playerX, double playerY) {
        view.updateTiles(playerX, playerY);
    }

    public WorldView getView() {
        return view;
    }
}
