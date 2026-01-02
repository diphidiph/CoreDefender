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
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;


/**
 *
 * @author Gebruiker
 */
public class BuildingController {   

 
    private BuildingType selectedBuilding = null; //we starten met geen type
    private AnchorPane worldPane;
    // Voor Stash (max 1)
    private Stash_Model stashModel;
    private StashView stashView;

    // Voor Gold Mines (max 6)
    private GoldMineView mineView;
    private GoldMine_Model mineModel;
    private static final int MAX_MINES = 6;
    private final ArrayList<GoldMine_Model> mineModels = new ArrayList<>();
    private final ArrayList<GoldMineView> mineViews = new ArrayList<>();
    
    // Voor Canons (max 8)
    //private static final int MAX_CANONS = 8;
    //private final ArrayList<Canon_Model> canonModels = new ArrayList<>();
    //private final ArrayList<CanonView> canonViews = new ArrayList<>();
    
    // Voor Walls (max 200)
    //private static final int MAX_WALLS = 200;
    //private final ArrayList<Wall_Model> wallModels = new ArrayList<>();
    //private final ArrayList<WallView> wallViews = new ArrayList<>();
    
      /**
       * Constructor (anchorpane meegeven, en 4 knoppen voor elke type gebouw)
       * */
        public BuildingController(AnchorPane worldPane) {
        this.worldPane = worldPane;                
        BuildingWorldClickHandler();
    }
        /**
       * Originele Methode om juiste gebouw aan te klikken. (Was niet ideaal omdat de controller in de view moest zoeken voor de juiste Buttons)
       
    private void BuildingButtonHandlers(){
        goldStashButton.setOnAction(e -> {
            selectedBuilding = BuildingType.GOLDSTASH;
        });
         goldMineButton.setOnAction(e -> {
            selectedBuilding = BuildingType.GOLDMINE;
        });
        /** canonButton.setOnAction(e -> {
            selectedBuilding = BuildingType.CANON;
        });
        * wallButton.setOnAction(e -> {
            selectedBuilding = BuildingType.WALL;
        });     
        
        **/
        
    public void selectBuilding(BuildingType type) {
    selectedBuilding = type;
    }
      
    /**
       * Methode om (gebouwplaatsting) aan te roepen wanneer er in de world geklikt wordt.
       * */    
    private void BuildingWorldClickHandler(){
        worldPane.setOnMouseClicked(this::placeBuilding);
    }
    
     /**
       * Methode om een gebouw te plaatsen met een muis klik op een bepaalde positie 
       * */ 
    private void placeBuilding(MouseEvent event){
        if (selectedBuilding == null) return;
        
        int x = (int) event.getX();
        int y = (int) event.getY();
        
         switch (selectedBuilding) {

            case GOLDSTASH:
                if (stashModel == null) {
                   
                    stashModel = new Stash_Model(x, y, Level.level_1);
                    stashView = new StashView(stashModel);

                    worldPane.getChildren().add(stashView);
                }
                break;

            case GOLDMINE:
                if (mineModels.size() < MAX_MINES) {
                    
                    mineModel = new GoldMine_Model(x, y, Level.level_1);
                    mineView = new GoldMineView(mineModel);

                    mineModels.add(mineModel);
                    mineViews.add(mineView);

                    worldPane.getChildren().add(mineView);
                }
                break;

            default:
                break;
        }

        selectedBuilding = null;
        
    }
    public void update() {

        // Stash (maar 1)
        if (stashView != null) {
            stashView.update();
            }

        // Alle gold mines
        for (GoldMineView view : mineViews) {
            view.update();
        }
    }
    
    
    
    
       
      
        
        
}


