/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.iiw.coredefender.character;

import be.iiw.coredefender.world.WorldController;
import java.util.TimerTask;
import javafx.application.Platform;

/**
 *
 * @author kinga
 */

public class CharacterAnimator extends TimerTask {

    private final CharacterController controller;
    private final CharacterModel char_model;

    public CharacterAnimator(CharacterController controller,CharacterModel char_model) {
        this.controller = controller;
        this.char_model = char_model;
    }

    @Override
    public void run() {
        WorldController world = controller.getWorldController(); 
        
        if (world != null) {
            char_model.tick(world);
        }
        
        Platform.runLater(controller::update);
    }
}
