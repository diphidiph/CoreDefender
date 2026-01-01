package be.iiw.coredefender.Buildings;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import be.iiw.coredefender.Buildings.GoldMineView;
import be.iiw.coredefender.Buildings.GoldMine_Model;
import be.iiw.coredefender.Buildings.StashView;
import be.iiw.coredefender.Buildings.Stash_Model;
import be.iiw.coredefender.Level.Level;
import java.util.ArrayList;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;

/**
 *
 * @author Gebruiker
 */
public class BuildingController {
    
        // Voor Stash (max 1)
    private Stash_Model stashModel;
    private StashView stashView;

    // Voor Gold Mines (max 6)
    private final int MAX_MINES = 6;
    private final ArrayList<GoldMine_Model> mineModels = new ArrayList<>();
    private final ArrayList<GoldMineView> mineViews = new ArrayList<>();

    // Geselecteerd gebouw
    private BuildingType selectedBuilding = null;
    
    
    private void placeBuilding(MouseEvent event) {
    if (selectedBuilding == null) return;

    int x = (int) event.getX();
    int y = (int) event.getY();

    switch (BuildingType) {
        case STASH:
            if (stashModel == null) { // max 1 stash
                stashModel = new Stash_Model(x, y, Level.level_1);
                stashView = new StashView(stashModel);
                world_pane.getChildren().add(stashView);
            }
            break;

        case GOLD_MINE:
            if (mineModels.size() < MAX_MINES) { // max 6
                GoldMine_Model mineModel = new GoldMine_Model(x, y, Level.level_1);
                GoldMineView mineView = new GoldMineView(mineModel);
                mineModels.add(mineModel);
                mineViews.add(mineView);
                world_pane.getChildren().add(mineView);
            }
            break;
    }

    // optioneel: deselecteer na plaatsing
    selectedBuilding = null;
    }
        
       
      
        
        
}


