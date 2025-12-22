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
    private CharacterModel char_model;
    private AnchorPane character_pane;
    
    public CharacterView(CharacterModel model) {
        this.char_model = model;
        
        character_pane = new AnchorPane();
        
        Circle lichaam = new Circle(0, 0, 30, Color.web("#9e7b5c"));
        lichaam.setStroke(Color.web("#262235"));
        lichaam.setStrokeWidth(2);
        Circle linker_arm = new Circle(23,-18,12,Color.web("#8c6b54"));
        linker_arm.setStroke(Color.web("#262235"));
        linker_arm.setStrokeWidth(2);
        Circle rechter_arm = new Circle(-23,-18,12,Color.web("#8c6b54"));
        rechter_arm.setStroke(Color.web("#262235"));
        rechter_arm.setStrokeWidth(2);
        
        character_pane.getChildren().addAll(linker_arm, rechter_arm, lichaam);
        getChildren().add(character_pane);
        update();
    }

    public void update() {
        int x = char_model.getX();
        int y = char_model.getY();
        character_pane.setLayoutX(x);
        character_pane.setLayoutY(y);
        character_pane.setTranslateX(char_model.getX());
        character_pane.setTranslateY(char_model.getY());
    }
}
