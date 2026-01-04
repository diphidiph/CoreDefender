/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 * R. Yediael
 */
package be.iiw.coredefender.building;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Gebruiker
 */
public class BombTowerView extends BuildingView {
        private Button BombTowerButton;
    private final int ButtonSize = 72;
    
    
    public BombTowerView(BombTowerModel bombTowerModel){
        super(bombTowerModel);
        BombTowerButton = createButtonWithImage("/be/iiw/coredefender/Buildings_Images/BombTower.png");      
        getChildren().add(BombTowerButton);
    }
     private Button createButtonWithImage(String imagePath) {
        Button btn = new Button();
        Image img = new Image(getClass().getResource(imagePath).toExternalForm());
        ImageView imgView = new ImageView(img);       
        btn.setGraphic(imgView);        
        imgView.setFitWidth(ButtonSize);
        imgView.setFitHeight(ButtonSize);
        imgView.setPreserveRatio(true);     

        btn.setStyle("-fx-background-color: transparent");
        btn.setPrefSize(ButtonSize, ButtonSize);
        btn.setMinSize(ButtonSize, ButtonSize);
        btn.setMaxSize(ButtonSize, ButtonSize);

        btn.setPadding(Insets.EMPTY);
        btn.setFocusTraversable(false); // focusrand weg   
        
        return btn;
    }
}
