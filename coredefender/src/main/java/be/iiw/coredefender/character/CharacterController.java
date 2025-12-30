/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.iiw.coredefender.character;

import be.iiw.coredefender.CoredefenderFXMLController;
import static javafx.scene.input.KeyCode.H;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author kinga
 */



public class CharacterController {
    private final CharacterModel char_model;
    private final CharacterView char_view;
    private final CoredefenderFXMLController mainController;

    public CharacterController(CharacterModel model, CharacterView view, CoredefenderFXMLController mainController) {
        this.char_model = model;
        this.char_view = view;
        this.mainController = mainController;
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
                mainController.checkHarvest();
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

    public void update() {
            char_view.update();
    }

    public CharacterView getView() {
        return char_view;
    }

    public CharacterModel getModel() {
        return char_model;
    }
}
