/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.iiw.coredefender.building;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.SVGPath;

/**
 *
 * @author Gebruiker
 */
public class GoldMineView extends BuildingView {
    private final Button GoldMineButton;
    private final GoldMine_Model mineModel;
    private final int ButtonSize = 72;

    public GoldMineView(GoldMine_Model mineModel) {
        
        super(mineModel);
        this.mineModel = mineModel;
        
        GoldMineButton = createButtonWithImage("/be/iiw/coredefender/Buildings_Images/Gold-mine.png");      
        
        getChildren().add(GoldMineButton);
    }   
        private Button createButtonWithImage(String imagePath) {
        Button btn = new Button();
        Image img = new Image(getClass().getResource(imagePath).toExternalForm());
        ImageView imgView = new ImageView(img);       
        btn.setGraphic(imgView);        
        imgView.setFitWidth(ButtonSize);
        imgView.setFitHeight(ButtonSize);
        imgView.setPreserveRatio(true);     

        btn.setPrefSize(ButtonSize, ButtonSize);
        btn.setMinSize(ButtonSize, ButtonSize);
        btn.setMaxSize(ButtonSize, ButtonSize);

        btn.setPadding(Insets.EMPTY);
        btn.setFocusTraversable(false); // focusrand weg   
        
        return btn;
    }
    
    

}
    

