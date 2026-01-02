/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.iiw.coredefender.overlay.petsoverlay;

import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author kinga
 */

public class PetsOverlayController {

    private final PetsOverlayView petsView;
    private boolean visible = false;

    public PetsOverlayController() {
        petsView = new PetsOverlayView();
    }

    public AnchorPane getView() {
        return petsView.getView();
    }

    public boolean isVisible() {
        return visible;
    }

    public void toggle(AnchorPane parentPane, Stage stage) {
        AnchorPane petsPane = petsView.getView();

        if(!visible) {
            if(!parentPane.getChildren().contains(petsPane)) {
                parentPane.getChildren().add(petsPane);
            }

            petsPane.setLayoutX((stage.getScene().getWidth() - petsPane.getPrefWidth()) / 2);
            petsPane.setLayoutY((stage.getScene().getHeight() - petsPane.getPrefHeight()) / 2);

            visible = true;
        } else {
            parentPane.getChildren().remove(petsPane);
            visible = false;
        }
    }
}
