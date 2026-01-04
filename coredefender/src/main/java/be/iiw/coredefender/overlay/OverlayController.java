package be.iiw.coredefender.overlay;

import be.iiw.coredefender.building.StashModel;
import be.iiw.coredefender.character.CharacterModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class OverlayController {

    private final OverlayView overlayView;

    public OverlayController() {
        overlayView = new OverlayView();
    }

    public OverlayController(OverlayView overlayView) {
        this.overlayView = overlayView;
    }

    public void updateBuildingMaterials(CharacterModel model) {
        overlayView.updateBuildingMaterials(
            model.getWoodCount(),
            model.getStoneCount());            
           }
    public void updateGold(StashModel stash){
        overlayView.updateGoldAmount((int) stash.getGoldAmount());
        }

    public AnchorPane getView() {
        return overlayView.getView();
        }

    public void show(AnchorPane parentPane, Stage stage) {
        AnchorPane pane = overlayView.getView();

        if (!parentPane.getChildren().contains(pane)) {
            parentPane.getChildren().add(pane);
        }

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

    public void setSkillTreeAction(EventHandler<ActionEvent> handler) {
        overlayView.getLevelButton().setOnAction(handler);
    }
}
