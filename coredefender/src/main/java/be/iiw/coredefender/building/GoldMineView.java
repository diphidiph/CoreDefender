/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.iiw.coredefender.building;

import javafx.scene.shape.SVGPath;

/**
 *
 * @author Gebruiker
 */
public class GoldMineView extends BuildingView {
    private final SVGPath svg;
    private final GoldMine_Model mineModel;

    public GoldMineView(GoldMine_Model mineModel) {
        
        super(mineModel);
        this.mineModel = mineModel;
        svg = new SVGPath();
        svg.setContent("Gold-mine.svg");      
        
        getChildren().add(svg);
    }   
    
    

}
    

