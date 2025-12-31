package be.iiw.coredefender.overlay.buildoverlay;

import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.SVGPath;

/**
 *
 * @author kinga
 */

public class BuildOverlayView {

    private final AnchorPane overlayPane;
    private final Button buildTownButton;
    private final Button buildKannonButton;
    private final Button buildTowerButton;

    public BuildOverlayView() {
        overlayPane = new AnchorPane();

        int buttonSize = 50;
        int spacing = 10;
        int padding = 20;
        int width = buttonSize + 2 * padding;
        int totalHeight = padding * 2 + 3 * buttonSize + 2 * spacing;

        overlayPane.setPrefSize(width, totalHeight);

        Rectangle container = new Rectangle(width, totalHeight, Color.web("#344263"));
        container.setStroke(Color.web("#1B2640"));
        overlayPane.getChildren().add(container);

        buildTownButton = createButton("M8.277.084a.5.5 0 0 0-.554 0l-7.5 5A.5.5 0 0 0 .5 6h1.875v7H1.5a.5.5 0 0 0 0 1h13a.5.5 0 1 0 0-1h-.875V6H15.5a.5.5 0 0 0 .277-.916zM12.375 6v7h-1.25V6zm-2.5 0v7h-1.25V6zm-2.5 0v7h-1.25V6zm-2.5 0v7h-1.25V6zM8 4a1 1 0 1 1 0-2 1 1 0 0 1 0 2M.5 15a.5.5 0 0 0 0 1h15a.5.5 0 1 0 0-1z");
        buildKannonButton = createButton("M5.5.5a.5.5 0 0 0-1 0V2A2.5 2.5 0 0 0 2 4.5H.5a.5.5 0 0 0 0 1H2v1H.5a.5.5 0 0 0 0 1H2v1H.5a.5.5 0 0 0 0 1H2v1H.5a.5.5 0 0 0 0 1H2A2.5 2.5 0 0 0 4.5 14v1.5a.5.5 0 0 0 1 0V14h1v1.5a.5.5 0 0 0 1 0V14h1v1.5a.5.5 0 0 0 1 0V14h1v1.5a.5.5 0 0 0 1 0V14a2.5 2.5 0 0 0 2.5-2.5h1.5a.5.5 0 0 0 0-1H14v-1h1.5a.5.5 0 0 0 0-1H14v-1h1.5a.5.5 0 0 0 0-1H14v-1h1.5a.5.5 0 0 0 0-1H14A2.5 2.5 0 0 0 11.5 2V.5a.5.5 0 0 0-1 0V2h-1V.5a.5.5 0 0 0-1 0V2h-1V.5a.5.5 0 0 0-1 0V2h-1zm1 4.5h3A1.5 1.5 0 0 1 11 6.5v3A1.5 1.5 0 0 1 9.5 11h-3A1.5 1.5 0 0 1 5 9.5v-3A1.5 1.5 0 0 1 6.5 5");
        buildTowerButton = createButton("M6.707 9h4.364c-.536 1.573 2.028 3.806 4.929-.5-2.9-4.306-5.465-2.073-4.929-.5H6.707L4.854 6.146a.5.5 0 1 0-.708.708L5.293 8h-.586L2.854 6.146a.5.5 0 1 0-.708.708L3.293 8h-.586L.854 6.146a.5.5 0 1 0-.708.708L1.793 8.5.146 10.146a.5.5 0 0 0 .708.708L2.707 9h.586l-1.147 1.146a.5.5 0 0 0 .708.708L4.707 9h.586l-1.147 1.146a.5.5 0 0 0 .708.708z");

        buildTownButton.setPrefSize(buttonSize, buttonSize);
        buildKannonButton.setPrefSize(buttonSize, buttonSize);
        buildTowerButton.setPrefSize(buttonSize, buttonSize);

        buildTownButton.setLayoutX(padding);
        buildTownButton.setLayoutY(padding);

        buildKannonButton.setLayoutX(padding);
        buildKannonButton.setLayoutY(padding + buttonSize + spacing);

        buildTowerButton.setLayoutX(padding);
        buildTowerButton.setLayoutY(padding + 2 * (buttonSize + spacing));

        overlayPane.getChildren().addAll(buildTownButton, buildKannonButton, buildTowerButton);
    }

    private Button createButton(String svgData) {
        Button btn = new Button();
        SVGPath svg = new SVGPath();
        svg.setContent(svgData);
        svg.setFill(Color.WHITE);
        svg.setScaleX(1.2);
        svg.setScaleY(1.2);
        btn.setGraphic(svg);
        btn.setFocusTraversable(false);
        return btn;
    }

    public AnchorPane getView() {
        return overlayPane;
    }

    public Button getBuildTownButton() {
        return buildTownButton;
    }

    public Button getBuildTowerButton() {
        return buildKannonButton;
    }

    public Button getBuildBarracksButton() {
        return buildTowerButton;
    }
}
