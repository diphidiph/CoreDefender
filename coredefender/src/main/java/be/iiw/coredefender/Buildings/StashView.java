/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.iiw.coredefender.Buildings;

import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;

/**
 *
 * @author Gebruiker
 */
public class StashView extends BuildingView {

    private SVGPath svg;

    public StashView(Stash_Model model) {
        super(model);

        svg = new SVGPath();
        svg.setContent("coredefender-GoldStash.svg");
        
        

        getChildren().add(svg);
    }    

    
}
