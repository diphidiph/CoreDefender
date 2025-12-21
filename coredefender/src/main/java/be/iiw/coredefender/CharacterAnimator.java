/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.iiw.coredefender;

import be.iiw.coredefender.character.CharacterModel;
import java.util.TimerTask;
import javafx.application.Platform;

/**
 *
 * @author kinga
 */
public class CharacterAnimator extends TimerTask {
    private CharacterModel model;
    private CoredefenderFXMLController controller;
    
    public CharacterAnimator(CharacterModel model, CoredefenderFXMLController controller) {
        this.model = model;
        this.controller = controller;
    }

    @Override
    public void run() {
        model.tick();
        Platform.runLater(controller::update);
    }
}
