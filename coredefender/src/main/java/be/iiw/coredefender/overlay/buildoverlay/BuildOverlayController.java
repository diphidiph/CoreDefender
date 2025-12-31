package be.iiw.coredefender.overlay.buildoverlay;

import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author kinga
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
