package be.iiw.coredefender.building;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import be.iiw.coredefender.CoredefenderFXMLController;
import be.iiw.coredefender.building.GoldMineView;
import be.iiw.coredefender.building.GoldMine_Model;
import be.iiw.coredefender.building.StashView;
import be.iiw.coredefender.building.StashModel;
import be.iiw.coredefender.level.Level;
import be.iiw.coredefender.world.WorldController;
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
    private WorldController worldController;
    // Voor Stash (max 1)
    private StashModel stashModel;
    private StashView stashView;
    private final int TILE_SIZE = 36;
    private CoredefenderFXMLController Main;
    
   

    // Voor Gold Mines (max 6)
    private GoldMineView mineView;
    private GoldMine_Model mineModel;
    private static final int MAX_MINES = 6;
    private final ArrayList<GoldMine_Model> mineModels = new ArrayList<>();
    private final ArrayList<GoldMineView> mineViews = new ArrayList<>();
    
    //Voor bomb towers (max 8)
    private BombTowerModel bombTowerModel;
    private BombTowerView bombTowerView;
    private static final int MAX_TOWERS = 8;
    private final ArrayList<BombTowerModel> bombTowerModels = new ArrayList<>();
    private final ArrayList<BombTowerView> bombTowerViews = new ArrayList<>();
    
    // Voor Walls (max 200)
     private WallModel wallModel;
    private WallView wallView;
    private static final int MAX_WALLS = 200;
    private final ArrayList<WallModel> wallModels = new ArrayList<>();
    private final ArrayList<WallView> wallViews = new ArrayList<>();
    
      /**
       * Constructor (anchorpane meegeven, en 4 knoppen voor elke type gebouw)
       * */
        public BuildingController(AnchorPane worldPane, CoredefenderFXMLController Main, WorldController worldController) {
        this.worldPane = worldPane;
        this.Main = Main;
        this.worldController = worldController;
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
        
        double camX = Main.getCamX();
        double camY = Main.getCamY();
               
       
        // wereldpositie van de klik
        double worldX = event.getSceneX() - camX;
        double worldY = event.getSceneY() - camY;
        
      
        
        int gridX = (int)(worldX / TILE_SIZE);
        int gridY = (int)(worldY / TILE_SIZE);  
        
        
        int snappedX = gridX * TILE_SIZE;
        int snappedY = gridY * TILE_SIZE;
      
         switch (selectedBuilding) {

            case GOLDSTASH:
                if (stashModel == null) {
                   
                    stashModel = new StashModel(snappedX, snappedY, Level.level_1);
                    stashView = new StashView(stashModel);
                    stashView.setTranslateX(stashModel.getRenderX());
                    stashView.setTranslateY(stashModel.getRenderY());

                    
                    Main.getWorldRoot().getChildren().add(stashView);
                    worldController.addCollidable(stashModel);
                }
                break;

            case GOLDMINE:
                if (mineModels.size() < MAX_MINES) {
                    
                    mineModel = new GoldMine_Model(snappedX, snappedY, Level.level_1);
                    mineView = new GoldMineView(mineModel);
                    mineView.setTranslateX(mineModel.getRenderX());
                    mineView.setTranslateY(mineModel.getRenderY());

                    mineModels.add(mineModel);
                    mineViews.add(mineView);

                    Main.getWorldRoot().getChildren().add(mineView);
                    worldController.addCollidable(mineModel);
                }
                break;
            case BOMBTOWER:
                if (bombTowerModels.size() < MAX_TOWERS) {
                    
                    bombTowerModel = new BombTowerModel(snappedX, snappedY, Level.level_1);
                    bombTowerView = new BombTowerView(bombTowerModel);
                    bombTowerView.setTranslateX(bombTowerModel.getRenderX());
                    bombTowerView.setTranslateY(bombTowerModel.getRenderY());

                    bombTowerModels.add(bombTowerModel);
                    bombTowerViews.add(bombTowerView);

                    Main.getWorldRoot().getChildren().add(bombTowerView);
                    worldController.addCollidable(bombTowerModel);
                }
                break;
            
            case WALL:
                if (bombTowerModels.size() < MAX_WALLS) {
                    
                    wallModel = new WallModel(snappedX, snappedY, Level.level_1);
                    wallView = new WallView(wallModel);
                    wallView.setTranslateX(wallModel.getRenderX());
                    wallView.setTranslateY(wallModel.getRenderY());

                    wallModels.add(wallModel);
                    wallViews.add(wallView);

                    Main.getWorldRoot().getChildren().add(wallView);
                    worldController.addCollidable(wallModel);
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
        // Verzamel goud van alle mines en voeg toe aan stash
    if (stashModel != null) {
        double totalGold = 0;
        for (GoldMine_Model mine : mineModels) {
            totalGold += mine.getIncome(); // gebruik jouw methode getIncome()
            }
            stashModel.addGold(totalGold); // voeg alles toe aan de stash
            Main.getOverlayController().updateGold(stashModel);
        }
        
    }
    
}


