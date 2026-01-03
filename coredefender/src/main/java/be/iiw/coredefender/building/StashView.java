/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.iiw.coredefender.building;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;

/**
 *
 * @author Gebruiker
 */
public class StashView extends BuildingView {

    private SVGPath svg;
    private final int ButtonSize =72;
    private Button GoldStashButton;

    public StashView(Stash_Model model) {
        super(model);        
        
        GoldStashButton = createButtonWithImage("/be/iiw/coredefender/Buildings_Images/GoldStash.png");  

        svg = new SVGPath();
        svg.setContent("coredefender-GoldStash.svg");
        
        

        getChildren().add(GoldStashButton);
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
