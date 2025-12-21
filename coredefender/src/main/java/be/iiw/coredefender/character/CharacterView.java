/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.iiw.coredefender.character;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author kinga
 */
public class CharacterView extends Region {
    private CharacterModel model;
    private AnchorPane character_pane;
    
    public CharacterView(CharacterModel model) {
        this.model = model;
        
        character_pane = new AnchorPane();
        
        Circle lichaam = new Circle(25,25,25,Color.YELLOW);
        lichaam.setStroke(Color.BROWN);
        Circle linker_arm = new Circle(25,25,25,Color.YELLOW);
        linker_arm.setStroke(Color.BROWN);
        Circle rechter_arm = new Circle(25,25,25,Color.YELLOW);
        linker_arm.setStroke(Color.BROWN);
        
        character_pane.getChildren().addAll(lichaam,linker_arm,rechter_arm);
        getChildren().add(character_pane);
        update();
    }

    public void update() {
        int x = model.getX();
        int y = model.getY();
        character_pane.setLayoutX(x);
        character_pane.setLayoutY(y);
    }
}
