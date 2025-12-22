/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.iiw.coredefender.character;

import java.util.TimerTask;
import javafx.application.Platform;

/**
 *
 * @author kinga
 */

public class CharacterAnimator extends TimerTask {

    private final CharacterController controller;

    public CharacterAnimator(CharacterController controller) {
        this.controller = controller;
    }

    @Override
    public void run() {
        controller.tick();
        Platform.runLater(() -> controller.getView().update());
    }
}
