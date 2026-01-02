package be.iiw.coredefender;

import be.iiw.coredefender.Buildings.BuildingController;
import be.iiw.coredefender.Buildings.BuildingType;
import be.iiw.coredefender.character.CharacterAnimator;
import be.iiw.coredefender.character.CharacterController;
import be.iiw.coredefender.character.CharacterModel;
import be.iiw.coredefender.character.CharacterView;
import be.iiw.coredefender.overlay.OverlayController;
import be.iiw.coredefender.overlay.buildoverlay.BuildOverlayController;
import be.iiw.coredefender.overlay.petsoverlay.PetsOverlayController;
import be.iiw.coredefender.world.WorldController;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CoredefenderFXMLController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text item_gold;

    @FXML
    private Text item_stone;

    @FXML
    private Text item_wood;

    @FXML
    private AnchorPane world_pane;

    @FXML
    private AnchorPane character_pane;

    private CharacterController characterController;
    private CharacterModel char_model;
    private PetsOverlayController petsController;
    private OverlayController overlayController;
    private BuildOverlayController buildOverlayController;
    private BuildingController buildingController;
    private WorldController worldController;

    @FXML
    void initialize() {
        overlayController = new OverlayController();

        createWorld();
        createCharacter();
        createPets();
        setupInput();
        

        Platform.runLater(() -> {
            buildOverlayController = new BuildOverlayController();
            
            buildingController = new BuildingController(world_pane);
            buildOverlayController.setOnGoldStash(e -> buildingController.selectBuilding(BuildingType.GOLDSTASH));
            buildOverlayController.setOnGoldMine(e -> buildingController.selectBuilding(BuildingType.GOLDMINE));

            overlayController.setBuildAction(this::onBuild);
            overlayController.setPetsAction(this::onPets);
            overlayController.setAttackAction(this::onAttack);
            overlayController.setLevelAction(this::onLevel);

            overlayController.show(world_pane, (Stage) world_pane.getScene().getWindow());
        
        startAnimation();
            
            
        });
    }

    private void createWorld() {
        // Assign to class field, not local variable
        worldController = new WorldController(100, 100);
        world_pane.getChildren().add(worldController.getView());
    }

    private void createCharacter() {
        character_pane = new AnchorPane();
        character_pane.setPickOnBounds(false);
        character_pane.setFocusTraversable(true);

        AnchorPane.setTopAnchor(character_pane, 0.0);
        AnchorPane.setBottomAnchor(character_pane, 0.0);
        AnchorPane.setLeftAnchor(character_pane, 0.0);
        AnchorPane.setRightAnchor(character_pane, 0.0);

        world_pane.getChildren().add(character_pane);

        char_model = new CharacterModel();
        CharacterView char_view = new CharacterView(char_model);

        characterController = new CharacterController(char_model, char_view, worldController, overlayController);

        character_pane.getChildren().add(char_view);
    }
    
    private void createPets() {
        petsController = new PetsOverlayController();
    }

    private void setupInput() {
        character_pane.setPickOnBounds(true);
        character_pane.setOnKeyPressed(this::onMovementInput);
        character_pane.setOnKeyReleased(this::onMovementRelease);
        character_pane.setOnMouseMoved(characterController::onMouseMoved);
        character_pane.setOnMouseDragged(characterController::onMouseMoved);
    }

    
    /** Dit is hoe wij geleerd hebben tot nu toe (met gebruik van TimerTask)
    private void startAnimation() {
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(
            new CharacterAnimator(characterController, char_model),10,20);
    }
    
    
    Maar er werd hiervoor de mening van chatgpt gevraagd, en die vond dat het gebruik van AnimationTimer veel beter was:
    * 1) Het is speciaal gemaakt voor animaties en het werkt dus automatisch op 60x per sec.
    * 2) Het mag direct de UI aanpassen in tegenstelling tot TimerTask: (daarvoor moesten we altijd Platform.runLater gebruiken)
   
    
    **/
    private void startAnimation() {

    new AnimationTimer() {
        
        //handle is gekend door JavaFX en loopt 60x per sec. We nemen die en passen het aan met @override
        //now is de tijdstip van type long (in nano sec) en dat is nodig voor Java om de tijd bij te houden.
        
        @Override
        public void handle(long now) { //handle is gekend door JavaFX en loopt 60x per sec. We nemen die en passen het aan met @override

            // character model moet geupdate worden
            char_model.tick();

            // character view update (via controller.update())
            characterController.update();

            // building updates
            if (buildingController != null) {
                buildingController.update();
            }
        }

    }.start();
}


    private void onMovementInput(KeyEvent ep) {
        characterController.onKeyPressed(ep);
    }

    private void onMovementRelease(KeyEvent er) {
        characterController.onKeyReleased(er);
    }
    
    private void onBuild(ActionEvent event) {
        Stage stage = (Stage) world_pane.getScene().getWindow();
        buildOverlayController.toggle(world_pane, stage);
        character_pane.requestFocus();
    }

    private void onPets(ActionEvent event) {
        Stage stage = (Stage) world_pane.getScene().getWindow();
        petsController.toggle(world_pane, stage);
        character_pane.requestFocus();
    }

    private void onAttack(ActionEvent event) {
        character_pane.requestFocus();
    }

    private void onLevel(ActionEvent event) {
        character_pane.requestFocus();
    }
}
