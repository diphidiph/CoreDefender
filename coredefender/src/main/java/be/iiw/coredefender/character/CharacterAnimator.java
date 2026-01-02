/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.iiw.coredefender.character;

import be.iiw.coredefender.CoredefenderFXMLController;
import java.util.TimerTask;
import javafx.application.Platform;

/**
 *
 * @author kinga
 */

public class CharacterAnimator extends TimerTask {
    private final CharacterController controller;
    private final CharacterModel char_model;
    private final CoredefenderFXMLController cameraUpdate;

    public CharacterAnimator(CharacterController controller, CharacterModel char_model, CoredefenderFXMLController cameraUpdate) {
        this.controller = controller;
        this.char_model = char_model;
        this.cameraUpdate = cameraUpdate;
    }

    @Override
    public void run() {
        char_model.tick();
        Platform.runLater(() -> {
            controller.update();
            cameraUpdate.updateCamera();
        });
    }
}
