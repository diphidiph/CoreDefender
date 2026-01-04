package be.iiw.coredefender.overlay.buildoverlay;

import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author M. Arthur en R. Yediael
 */

public class BuildOverlayController {

    private final BuildOverlayView view;
    private boolean visible = false;
    

    public BuildOverlayController() {
        view = new BuildOverlayView();
    }

    public AnchorPane getView() {
        return view.getView();
    }
    public void setOnGoldStash(EventHandler<ActionEvent> handler) {
        view.getBuildGoldstashButton().setOnAction(handler);
    }
    
    public void setOnGoldMine(EventHandler<ActionEvent> handler) {
        view.getBuildGoldMineButton().setOnAction(handler);
    }
     public void setOnBombTower(EventHandler<ActionEvent> handler) {
        view.getBuildBombTowerButton().setOnAction(handler);
    }
    public void setOnWall(EventHandler<ActionEvent> handler) {
        view.getBuildWallButton().setOnAction(handler);
    }

    
    
    public void toggle(AnchorPane parentPane, Stage stage) {
        if(visible) {
            parentPane.getChildren().remove(view.getView());
            visible = false;
        } else {
            parentPane.getChildren().add(view.getView());

            view.getView().setLayoutX(stage.getScene().getWidth() - view.getView().getPrefWidth() - 20);
            view.getView().setLayoutY((stage.getScene().getHeight() - view.getView().getPrefHeight()) / 2);

            visible = true;
        }
    }
}
