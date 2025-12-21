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
        
        Circle lichaam = new Circle(0, 0, 30, Color.KHAKI);
        lichaam.setStroke(Color.BLACK);
        lichaam.setStrokeWidth(2);
        Circle linker_arm = new Circle(23,-18,12,Color.KHAKI);
        linker_arm.setStroke(Color.BLACK);
        linker_arm.setStrokeWidth(2);
        Circle rechter_arm = new Circle(-23,-18,12,Color.KHAKI);
        rechter_arm.setStroke(Color.BLACK);
        rechter_arm.setStrokeWidth(2);
        
        character_pane.getChildren().addAll(linker_arm, rechter_arm, lichaam);
        getChildren().add(character_pane);
        update();
    }

    public void update() {
        int x = model.getX();
        int y = model.getY();
        character_pane.setLayoutX(x);
        character_pane.setLayoutY(y);
        character_pane.setTranslateX(model.getX());
        character_pane.setTranslateY(model.getY());
    }
}
