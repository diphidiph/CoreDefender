package be.iiw.coredefender.overlay;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.SVGPath;

/**
 *
 * @author kinga
 */

public class OverlayView {

    private final AnchorPane overlayPane;
    private final Button attackButton, buildButton, levelButton, petsButton;
    
    private final Label woodLabel;
    private final Label stoneLabel;
    private final Label goldLabel;

    public OverlayView() {
        overlayPane = new AnchorPane();

        int buttonSize = 50;
        int spacing = 10;
        int padding = 20;
        int totalWidth = padding * 2 + 4 * buttonSize + 3 * spacing;
        int height = buttonSize + 2 * padding;

        overlayPane.setPrefSize(totalWidth, height);

        Rectangle container = new Rectangle(totalWidth, height, Color.web("#344263"));
        container.setStroke(Color.web("#1B2640"));
        overlayPane.getChildren().add(container);

        attackButton = createButton("M13 .5c0-.276-.226-.506-.498-.465-1.703.257-2.94 2.012-3 8.462a.5.5 0 0 0 .498.5c.56.01 1 .13 1 1.003v5.5a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5z");
        buildButton = createButton("M15.528 2.973a.75.75 0 0 1 .472.696v8.662a.75.75 0 0 1-.472.696l-7.25 2.9a.75.75 0 0 1-.557 0l-7.25-2.9A.75.75 0 0 1 0 12.331V3.669a.75.75 0 0 1 .471-.696L7.443.184l.01-.003.268-.108a.75.75 0 0 1 .558 0l.269.108.01.003zM10.404 2 4.25 4.461 1.846 3.5 1 3.839v.4l6.5 2.6v7.922l.5.2.5-.2V6.84l6.5-2.6v-.4l-.846-.339L8 5.961 5.596 5l6.154-2.461z");
        levelButton = createButton("M7.27 1.047a1 1 0 0 1 1.46 0l6.345 6.77c.6.638.146 1.683-.73 1.683H11.5v1a1 1 0 0 1-1 1h-5a1 1 0 0 1-1-1v-1H1.654C.78 9.5.326 8.455.924 7.816zM4.5 13.5a1 1 0 0 1 1-1h5a1 1 0 0 1 1 1v1a1 1 0 0 1-1 1h-5a1 1 0 0 1-1-1z");
        petsButton = createButton("M8 1a2.5 2.5 0 0 1 2.5 2.5V4h-5v-.5A2.5 2.5 0 0 1 8 1m3.5 3v-.5a3.5 3.5 0 1 0-7 0V4H1v10a2 2 0 0 0 2 2h10a2 2 0 0 0 2-2V4z");

        attackButton.setPrefSize(buttonSize, buttonSize);
        buildButton.setPrefSize(buttonSize, buttonSize);
        levelButton.setPrefSize(buttonSize, buttonSize);
        petsButton.setPrefSize(buttonSize, buttonSize);

        attackButton.setLayoutX(padding);
        buildButton.setLayoutX(padding + buttonSize + spacing);
        levelButton.setLayoutX(padding + 2 * (buttonSize + spacing));
        petsButton.setLayoutX(padding + 3 * (buttonSize + spacing));

        double centerY = (height - buttonSize) / 2.0;
        attackButton.setLayoutY(centerY);
        buildButton.setLayoutY(centerY);
        levelButton.setLayoutY(centerY);
        petsButton.setLayoutY(centerY);

        overlayPane.getChildren().addAll(attackButton, buildButton, levelButton, petsButton);
        
        woodLabel = new Label("Wood: 0");
        stoneLabel = new Label("Stone: 0");
        goldLabel = new Label("Gold: 0");

        woodLabel.setTextFill(Color.WHITE);
        stoneLabel.setTextFill(Color.WHITE);
        goldLabel.setTextFill(Color.WHITE);

        woodLabel.setLayoutX(10);
        woodLabel.setLayoutY(height + 5);

        stoneLabel.setLayoutX(100);
        stoneLabel.setLayoutY(height + 5);

        goldLabel.setLayoutX(200);
        goldLabel.setLayoutY(height + 5);

        overlayPane.getChildren().addAll(woodLabel, stoneLabel, goldLabel);
    }

    private Button createButton(String svgData) {
        Button btn = new Button();
        SVGPath svg = new SVGPath();
        svg.setContent(svgData);
        svg.setFill(Color.WHITE);
        svg.setScaleX(1.2);
        svg.setScaleY(1.2);
        btn.setGraphic(svg);
        btn.setStyle("-fx-background-color: #4A90E2; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 8;");
        btn.setFocusTraversable(false);
        return btn;
    }

    public AnchorPane getView() {
        return overlayPane;
    }

    public Button getAttackButton() {
        return attackButton;
    }

    public Button getBuildButton() {
        return buildButton;
    }

    public Button getLevelButton() {
        return levelButton;
    }
    
    public Button getPetsButton() {
        return petsButton;
    }
    
    public void updateInventory(int wood, int stone, int gold) {
        woodLabel.setText("Wood: " + wood);
        stoneLabel.setText("Stone: " + stone);
        goldLabel.setText("Gold: " + gold);
    }
}
