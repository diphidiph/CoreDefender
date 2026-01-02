/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.iiw.coredefender.overlay.petsoverlay;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author kinga
 */
public class PetsOverlayView {

    private final AnchorPane petsPane;

    public PetsOverlayView() {
        petsPane = new AnchorPane();
        petsPane.setPrefSize(600, 400);

        Rectangle container = new Rectangle(600, 400, Color.web("#344263"));
        container.setStroke(Color.web("#1B2640"));
        
        petsPane.getChildren().add(container);
    }
    
    public AnchorPane getView() {
        return petsPane;
    }
}