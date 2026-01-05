package be.iiw.coredefender;

import be.iiw.coredefender.building.BuildingController;
import be.iiw.coredefender.building.BuildingType;
import be.iiw.coredefender.character.CharacterController;
import be.iiw.coredefender.character.CharacterModel;
import be.iiw.coredefender.character.CharacterView;
import be.iiw.coredefender.overlay.OverlayController;
import be.iiw.coredefender.overlay.OverlayView;
import be.iiw.coredefender.overlay.buildoverlay.BuildOverlayController;
import be.iiw.coredefender.overlay.petsoverlay.PetsOverlayController;
import be.iiw.coredefender.overlay.skilltreeoverlay.SkillTreeOverlayController;
import be.iiw.coredefender.pets.PetsController;
import be.iiw.coredefender.world.WorldController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class CoredefenderFXMLController {

    @FXML
    private ResourceBundle resources;
    
    @FXML
    private URL location;
    
    @FXML
    private AnchorPane world_pane;
    private AnchorPane character_pane;
    private CharacterController characterController;
    private CharacterModel char_model;
    private PetsOverlayController petsOverlayController;
    private SkillTreeOverlayController skilltreeOverlayController;
    private OverlayController overlayController;
    private BuildOverlayController buildOverlayController;
    private BuildingController buildingController;
    private WorldController worldController;
    private OverlayView overlayView;
    private PetsController petsController;
    private Pane worldRoot;
    private double camX = 0;
    private double camY = 0;

    @FXML
    void initialize() {
        overlayView = new OverlayView();
        overlayController = new OverlayController(overlayView);

        createWorld();
        createCharacterModel();
        createPets();
        createCharacter();
        createSkillTree();
        setupInput();

        Platform.runLater(() -> {
            setupOverlays();
            overlayController.setPetsOverlayController(petsOverlayController);

            buildOverlayController = new BuildOverlayController();
            
            buildingController = new BuildingController(world_pane, this, worldController);
            
            
            buildOverlayController.setOnGoldStash(e -> {
            buildingController.selectBuilding(BuildingType.GOLDSTASH);
            buildOverlayController.toggle(world_pane, (Stage) world_pane.getScene().getWindow());
            // focus terug naar worldPane zodat klik geregistreerd wordt
            world_pane.requestFocus();
            });            
            buildOverlayController.setOnGoldMine(e -> {
            buildingController.selectBuilding(BuildingType.GOLDMINE);
            buildOverlayController.toggle(world_pane, (Stage) world_pane.getScene().getWindow());
            // focus terug naar worldPane zodat klik geregistreerd wordt
            world_pane.requestFocus();        
            });            
            buildOverlayController.setOnBombTower(e -> {
            buildingController.selectBuilding(BuildingType.BOMBTOWER);
            buildOverlayController.toggle(world_pane, (Stage) world_pane.getScene().getWindow());
            // focus terug naar worldPane zodat klik geregistreerd wordt
            world_pane.requestFocus();        
            });            
            buildOverlayController.setOnWall(e -> {
            buildingController.selectBuilding(BuildingType.WALL);
            buildOverlayController.toggle(world_pane, (Stage) world_pane.getScene().getWindow());
            // focus terug naar worldPane zodat klik geregistreerd wordt
            world_pane.requestFocus();        
            });
            
            overlayController.setBuildAction(this::onBuild);
            overlayController.setPetsAction(this::onPets);
            overlayController.setAttackAction(this::onAttack);
            overlayController.setSkillTreeAction(this::onSkillTree);

            overlayController.show(world_pane, (Stage) world_pane.getScene().getWindow()); 
        startAnimation();
        });
    }

    private void createWorld() {
        worldRoot = new Pane();
        worldController = new WorldController(1000, 1000, 60, 40);
        worldRoot.getChildren().add(worldController.getView());
        world_pane.getChildren().add(worldRoot);
    }

    private void createCharacterModel() {
        char_model = new CharacterModel();
    }

    private void createCharacter() {
        character_pane = new AnchorPane();
        character_pane.setPickOnBounds(true);
        character_pane.setFocusTraversable(true);

        AnchorPane.setTopAnchor(character_pane, 0.0);
        AnchorPane.setBottomAnchor(character_pane, 0.0);
        AnchorPane.setLeftAnchor(character_pane, 0.0);
        AnchorPane.setRightAnchor(character_pane, 0.0);

        world_pane.getChildren().add(character_pane);

        CharacterView char_view = new CharacterView(char_model);
        worldRoot.getChildren().add(char_view);

        characterController = new CharacterController(
            char_model,
            char_view,
            worldController,
            overlayController,
            petsController
        );
    }
    
    private void createPets() {
        petsController = new PetsController(
            char_model,
            worldRoot,
            overlayController
        );

        petsOverlayController = new PetsOverlayController(
            char_model,
            overlayView,
            petsController
        );
    }
    
    private void createSkillTree() {
        skilltreeOverlayController = new SkillTreeOverlayController();
    }

    private void setupInput() {
        character_pane.setOnKeyPressed(this::onMovementInput);
        character_pane.setOnKeyReleased(this::onMovementRelease);
        character_pane.setOnMouseMoved(characterController::onMouseMoved);
        character_pane.setOnMouseDragged(characterController::onMouseMoved);
    }
    
    private void setupOverlays() {
        buildOverlayController = new BuildOverlayController();
        buildingController = new BuildingController(world_pane, this, worldController);

        buildOverlayController.setOnGoldStash(e -> {
            buildingController.selectBuilding(BuildingType.GOLDSTASH);
            buildOverlayController.toggle(world_pane, getStage());
            world_pane.requestFocus();
        });

        buildOverlayController.setOnGoldMine(e -> {
            buildingController.selectBuilding(BuildingType.GOLDMINE);
            buildOverlayController.toggle(world_pane, getStage());
            world_pane.requestFocus();
        });

        overlayController.setBuildAction(this::onBuild);
        overlayController.setPetsAction(this::onPets);
        overlayController.setAttackAction(this::onAttack);
        overlayController.setSkillTreeAction(this::onSkillTree);

        overlayController.show(world_pane, getStage());
    }

    
    /** Dit is hoe wij geleerd hebben tot nu toe (met gebruik van TimerTask)
    private void startAnimation() {
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(
            new CharacterAnimator(characterController, char_model, this),10,20);
    }
    
    
    Maar er werd hiervoor de mening van chatgpt gevraagd, en die vond dat het gebruik van AnimationTimer veel beter was:
    * 1) Het is speciaal gemaakt voor animaties en het werkt dus automatisch op 60x per sec.
    * 2) Het mag direct de UI aanpassen in tegenstelling tot TimerTask: (daarvoor moesten we altijd Platform.runLater gebruiken)
   
    
    **/
    private void startAnimation() {
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                char_model.tick(
                    worldController,
                    (int) worldRoot.getWidth(),
                    (int) worldRoot.getHeight(),
                    characterController.getView().getWidth(),
                    characterController.getView().getHeight()
                );

                worldController.update(char_model.getX(), char_model.getY());
                characterController.update();

                if (buildingController != null) {
                    buildingController.update();
                }

                petsController.update();
                updateCamera();
            }
        }.start();
    }

    private void onMovementInput(KeyEvent e) {
        characterController.onKeyPressed(e);
    }

    private void onMovementRelease(KeyEvent e) {
        characterController.onKeyReleased(e);
    }

    private void onBuild(ActionEvent e) {
        buildOverlayController.toggle(world_pane, getStage());
        character_pane.requestFocus();
    }

    private void onPets(ActionEvent e) {
        petsOverlayController.toggle(world_pane, getStage());
        character_pane.requestFocus();
    }

    private void onAttack(ActionEvent e) {
        character_pane.requestFocus();
    }

    private void onSkillTree(ActionEvent e) {
        skilltreeOverlayController.toggle(world_pane, getStage());
        character_pane.requestFocus();
    }
    
    private void updateCamera() {
        double w = world_pane.getScene().getWidth();
        double h = world_pane.getScene().getHeight();

        double cx = char_model.getX() + characterController.getView().getWidth() / 2;
        double cy = char_model.getY() + characterController.getView().getHeight() / 2;

        double targetX = -(cx - w / 2);
        double targetY = -(cy - h / 2);

        camX += (targetX - camX) * 0.1;
        camY += (targetY - camY) * 0.1;

        worldRoot.setTranslateX(camX);
        worldRoot.setTranslateY(camY);
    }

    private Stage getStage() {
        return (Stage) world_pane.getScene().getWindow();
    }
    
    public Pane getWorldRoot() {
        return worldRoot;
    }

    public OverlayController getOverlayController(){
        return overlayController;
    }

    public double getCamX() {
        return camX;
    }

    public double getCamY() {
        return camY;
    }
}
