package be.iiw.coredefender.overlay;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author kinga
 */

public class OverlayController {

    private final OverlayView overlayView;

    public OverlayController() {
        overlayView = new OverlayView();
    }

    public AnchorPane getView() {
        return overlayView.getView();
    }

    public void show(AnchorPane parentPane, Stage stage) {
        AnchorPane pane = overlayView.getView();

        parentPane.getChildren().add(pane);

        pane.setLayoutX((stage.getScene().getWidth() - pane.getPrefWidth()) / 2);
        pane.setLayoutY(stage.getScene().getHeight() * 7 / 8 - pane.getPrefHeight() / 2);
    }

    public void setPetsAction(EventHandler<ActionEvent> handler) {
        overlayView.getPetsButton().setOnAction(handler);
    }

    public void setAttackAction(EventHandler<ActionEvent> handler) {
        overlayView.getAttackButton().setOnAction(handler);
    }

    public void setBuildAction(EventHandler<ActionEvent> handler) {
        overlayView.getBuildButton().setOnAction(handler);
    }

    public void setLevelAction(EventHandler<ActionEvent> handler) {
        overlayView.getLevelButton().setOnAction(handler);
    }
}
