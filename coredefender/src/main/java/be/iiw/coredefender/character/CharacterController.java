
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.iiw.coredefender.character;

import be.iiw.coredefender.overlay.OverlayController;
import be.iiw.coredefender.pets.PetsController;
import be.iiw.coredefender.world.ResourceModel;
import be.iiw.coredefender.world.ResourceType;
import be.iiw.coredefender.world.WorldController;
import javafx.geometry.Point2D;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author kinga
 */

public class CharacterController {
    private final CharacterModel char_model;
    private final CharacterView char_view;
    private OverlayController overlay;
    private WorldController worldController;
    private PetsController petsController;

    
    private double mouseSceneX;
    private double mouseSceneY;
    
    private boolean harvesting = false;
    private long lastHarvestTime = 0;
    private static final long HARVEST_COOLDOWN = 0;



    public CharacterController(CharacterModel model, CharacterView view, WorldController worldController, OverlayController overlay, PetsController petsController) {
        this.char_model = model;
        this.char_view = view;
        this.worldController = worldController;
        this.overlay = overlay;
        this.petsController = petsController;
    }

    public void onKeyPressed(KeyEvent ep) {
        switch (ep.getCode()) {
            case LEFT:
                char_model.links();
                break;
            case RIGHT:
                char_model.rechts();
                break;
            case UP:
                char_model.boven();
                break;
            case DOWN:
                char_model.onder();
                break;
            case H:
                harvesting = true;
                break;
            default:
                return;
        }
    }
    
    public void onKeyReleased(KeyEvent er) { 
        switch (er.getCode()) { 
            case RIGHT: 
                char_model.stopX();    
                break; 
            case LEFT: 
                char_model.stopX(); 
                break; 
            case UP: 
                char_model.stopY(); 
                break; 
            case DOWN: 
                char_model.stopY(); 
                break; 
            case H:
                harvesting = false;
                break;
            default: 
                return; 
        }
    }
    
    public void onMouseMoved(MouseEvent me) {
        var charPos = char_view.localToScene(0, 0);
        
        mouseSceneX = me.getSceneX();
        mouseSceneY = me.getSceneY();

        double dx = me.getSceneX() - charPos.getX();
        double dy = me.getSceneY() - charPos.getY();

        char_model.setRotation(Math.toDegrees(Math.atan2(dy, dx)));
    }

    public void update(long now) {
        updateRotation();
        char_view.update();
        
        if (harvesting) {
            checkHarvest(worldController); // labels worden direct geüpdatet
        }
    }


    
    private void updateRotation() {
        Point2D charPos = char_view.localToScene(0, 0);

        double dx = mouseSceneX - charPos.getX();
        double dy = mouseSceneY - charPos.getY();

        char_model.setRotation(Math.toDegrees(Math.atan2(dy, dx)));
    }
    
    public void checkHarvest(WorldController world) {

        ResourceModel res = world.getClosestResource(
                char_model.getX(),
                char_model.getY(),
                110
        );

        if (res == null) return;

        ResourceType type = res.getType();

        // speler krijgt 1 resource (direct)
        switch (type) {
            case TREE:
                char_model.addWood();
                break;

            case STONE:
                char_model.addStone();
                break;
        }

        petsController.startHarvest(
                type,
                res.getX(),
                res.getY()
        );

        overlay.updateBuildingMaterials(char_model);
        overlay.updateInventory(char_model);
    }

    public CharacterView getView() {
        return char_view;
    }

    public CharacterModel getModel() {
        return char_model;
    }
    
    public WorldController getWorldController() {
        return worldController;
    }
}
