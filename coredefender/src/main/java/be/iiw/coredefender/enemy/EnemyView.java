/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.iiw.coredefender.enemy;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author kinga
 */
    
public class EnemyView {
    private final Circle lichaam;

    // Constructor
    public EnemyView() {
        lichaam = new Circle(10, Color.RED);
        lichaam.setStroke(Color.BLACK);
    }

    // Past positie van pet aan (op scherm)
    public void update(double x, double y) {
        lichaam.setTranslateX(x);
        lichaam.setTranslateY(y);
    }
    
    // Getters
    public Circle getNode() {
        return lichaam;
    }
}