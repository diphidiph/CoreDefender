/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.iiw.coredefender.character;

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
    
    private double mouseSceneX;
    private double mouseSceneY;

    public CharacterController(CharacterModel model, CharacterView view) {
        this.char_model = model;
        this.char_view = view;
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

    public void update() {
        updateRotation();
        char_view.update();
    }
    
    private void updateRotation() {
        Point2D charPos = char_view.localToScene(0, 0);

        double dx = mouseSceneX - charPos.getX();
        double dy = mouseSceneY - charPos.getY();

        char_model.setRotation(Math.toDegrees(Math.atan2(dy, dx)));
    }

    public CharacterView getView() {
        return char_view;
    }

    public CharacterModel getModel() {
        return char_model;
    }
}
