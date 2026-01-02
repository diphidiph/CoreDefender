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

    public WorldController(int width, int height) {
        this.model = new WorldModel(width, height);
        this.view = new WorldView(width, height);

        generateResources(15);
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
    
    public boolean checkCollision(double nextX, double nextY, double playerRadius) {
        for (ResourceModel r : model.getResources()) {
            double dx = nextX - r.getX();
            double dy = nextY - r.getY();
            double distance = Math.sqrt(dx * dx + dy * dy);
            
            double objectRadius = 55; //Straal hitbox object
            
            if (distance < (playerRadius + objectRadius)) {
                System.out.println("BOTSING!");
                return true; //Botsing
            }
        }
        return false;//GeenBotsing
    }
    
    public WorldView getView() {
        return view;
    }
}
