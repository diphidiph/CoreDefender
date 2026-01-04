package be.iiw.coredefender.overlay.buildoverlay;


import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


/**
 *
 * @author kinga
 */

public class BuildOverlayView {

    private final AnchorPane overlayPane;
    private final Button GoldStashButton;
    private final Button BombTowerButton;
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

        GoldStashButton = createButtonWithImage("/be/iiw/coredefender/Buildings_Images/GoldStash.png");
        BombTowerButton = createButtonWithImage("/be/iiw/coredefender/Buildings_Images/BombTower.png");
        WallButton = createButtonWithImage("/be/iiw/coredefender/Buildings_Images/Wall.png");
        GoldMineButton = createButtonWithImage("/be/iiw/coredefender/Buildings_Images/Gold-mine.png");
        
        GoldStashButton.setPrefSize(buttonSize, buttonSize);
        BombTowerButton.setPrefSize(buttonSize, buttonSize);
        WallButton.setPrefSize(buttonSize, buttonSize);
        GoldMineButton.setPrefSize(buttonSize, buttonSize);

        GoldStashButton.setLayoutX(padding);
        GoldStashButton.setLayoutY(padding);

        BombTowerButton.setLayoutX(padding);
        BombTowerButton.setLayoutY(padding + buttonSize + spacing);

        WallButton.setLayoutX(padding);
        WallButton.setLayoutY(padding + 2 * (buttonSize + spacing));
        
        GoldMineButton.setLayoutX(padding);
        GoldMineButton.setLayoutY(padding + 3 * (buttonSize + spacing));
        
        
        

        overlayPane.getChildren().addAll(GoldStashButton, BombTowerButton, WallButton, GoldMineButton);
    }

    
    
     private Button createButtonWithImage(String imagePath) {
        Button btn = new Button();
        Image img = new Image(getClass().getResource(imagePath).toExternalForm());
        ImageView imgView = new ImageView(img);       
        btn.setGraphic(imgView);        
        imgView.setFitWidth(44);
        imgView.setFitHeight(44);
        imgView.setPreserveRatio(true); 
        
        btn.setStyle("-fx-background-color: #4A90E2; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 8;");
        btn.setPrefSize(50, 50);
        btn.setMinSize(50, 50);
        btn.setMaxSize(50, 50);

        btn.setPadding(Insets.EMPTY);
        btn.setFocusTraversable(false); // focusrand weg   
        
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

    public Button getBuildBombTowerButton() {
        return BombTowerButton;
    }

    public Button getBuildWallButton() {
        return WallButton;
    }
    
}
