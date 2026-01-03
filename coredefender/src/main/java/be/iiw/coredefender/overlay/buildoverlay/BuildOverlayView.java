package be.iiw.coredefender.overlay.buildoverlay;

import java.net.URL;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    private final Button GoldStashButton;
    private final Button CanonButton;
    private final Button WallButton;
    private final Button GoldMineButton;
    private final int buttonSize = 50;

    public BuildOverlayView() {
        overlayPane = new AnchorPane();
        
        
        int buttonTotal = 4; //aantal knoppen
        
        int spacing = 10;
        int padding = 10;
        int width = buttonSize + 2 * padding;
        int totalHeight = padding * 2 + buttonTotal * buttonSize + (buttonTotal - 1) * spacing;

        overlayPane.setPrefSize(width, totalHeight);

        Rectangle container = new Rectangle(width, totalHeight, Color.web("#344263"));
        container.setStroke(Color.web("#1B2640"));
        overlayPane.getChildren().add(container);

        GoldStashButton = createButtonWithImage("/be/iiw/coredefender/Buildings_Images/GoldStash_Level_1.png");
        CanonButton = createButton("M5.5.5a.5.5 0 0 0-1 0V2A2.5 2.5 0 0 0 2 4.5H.5a.5.5 0 0 0 0 1H2v1H.5a.5.5 0 0 0 0 1H2v1H.5a.5.5 0 0 0 0 1H2v1H.5a.5.5 0 0 0 0 1H2A2.5 2.5 0 0 0 4.5 14v1.5a.5.5 0 0 0 1 0V14h1v1.5a.5.5 0 0 0 1 0V14h1v1.5a.5.5 0 0 0 1 0V14h1v1.5a.5.5 0 0 0 1 0V14a2.5 2.5 0 0 0 2.5-2.5h1.5a.5.5 0 0 0 0-1H14v-1h1.5a.5.5 0 0 0 0-1H14v-1h1.5a.5.5 0 0 0 0-1H14v-1h1.5a.5.5 0 0 0 0-1H14A2.5 2.5 0 0 0 11.5 2V.5a.5.5 0 0 0-1 0V2h-1V.5a.5.5 0 0 0-1 0V2h-1V.5a.5.5 0 0 0-1 0V2h-1zm1 4.5h3A1.5 1.5 0 0 1 11 6.5v3A1.5 1.5 0 0 1 9.5 11h-3A1.5 1.5 0 0 1 5 9.5v-3A1.5 1.5 0 0 1 6.5 5");
        WallButton = createButton("M6.707 9h4.364c-.536 1.573 2.028 3.806 4.929-.5-2.9-4.306-5.465-2.073-4.929-.5H6.707L4.854 6.146a.5.5 0 1 0-.708.708L5.293 8h-.586L2.854 6.146a.5.5 0 1 0-.708.708L3.293 8h-.586L.854 6.146a.5.5 0 1 0-.708.708L1.793 8.5.146 10.146a.5.5 0 0 0 .708.708L2.707 9h.586l-1.147 1.146a.5.5 0 0 0 .708.708L4.707 9h.586l-1.147 1.146a.5.5 0 0 0 .708.708z");
        GoldMineButton = createButton("Gold-mine.svg");
        
        GoldStashButton.setPrefSize(buttonSize, buttonSize);
        CanonButton.setPrefSize(buttonSize, buttonSize);
        WallButton.setPrefSize(buttonSize, buttonSize);
        GoldMineButton.setPrefSize(buttonSize, buttonSize);

        GoldStashButton.setLayoutX(padding);
        GoldStashButton.setLayoutY(padding);

        CanonButton.setLayoutX(padding);
        CanonButton.setLayoutY(padding + buttonSize + spacing);

        WallButton.setLayoutX(padding);
        WallButton.setLayoutY(padding + 2 * (buttonSize + spacing));
        
        GoldMineButton.setLayoutX(padding);
        GoldMineButton.setLayoutY(padding + 3 * (buttonSize + spacing));
        
        
        

        overlayPane.getChildren().addAll(GoldStashButton, CanonButton, WallButton, GoldMineButton);
    }

    private Button createButton(String svgData) {
        Button btn = new Button();
        SVGPath svg = new SVGPath();
        svg.setContent(svgData);
        
        svg.setScaleX(1.2);
        svg.setScaleY(1.2);
        btn.setGraphic(svg);
        btn.setStyle("-fx-background-color: #4A90E2; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 8;");
        btn.setFocusTraversable(false);
        return btn;
    }
     private Button createButtonWithImage(String imagePath) {
        Button btn = new Button();
        Image img = new Image(getClass().getResource(imagePath).toExternalForm());
        ImageView imgView = new ImageView(img);
        imgView.setFitWidth(buttonSize);   // breedte van knop
        imgView.setFitHeight(buttonSize);  // hoogte van knop
        btn.setGraphic(imgView);
        btn.setStyle("-fx-background-color: #4A90E2; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 8;");
        btn.setFocusTraversable(false);
        return btn;
    }
   
    

    public AnchorPane getView() {
        return overlayPane;
    }
    

    public Button getBuildGoldstashButton() {
        return GoldStashButton;
    }
    public Button getBuildGoldMineButton() {
        return GoldMineButton;
    }

    public Button getBuildCanonButton() {
        return CanonButton;
    }

    public Button getBuildWallButton() {
        return WallButton;
    }
    
}
