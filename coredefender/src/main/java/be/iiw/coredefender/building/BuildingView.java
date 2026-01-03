/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.iiw.coredefender.building;

import javafx.scene.layout.Region;

/**
 *
 * @author R. Yediael
 */
public abstract class BuildingView extends Region{
      protected final Building model;

    public BuildingView(Building model) {
        this.model = model;       
        
    }

    public void update(){    
        if (!model.isAlive()) {
            setVisible(false);
        }
    }
    
}
