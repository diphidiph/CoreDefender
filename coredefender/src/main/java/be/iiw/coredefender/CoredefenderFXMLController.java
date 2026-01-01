package be.iiw.coredefender;

import be.iiw.coredefender.character.CharacterAnimator;
import be.iiw.coredefender.character.CharacterController;
import be.iiw.coredefender.character.CharacterModel;
import be.iiw.coredefender.character.CharacterView;
import be.iiw.coredefender.overlay.OverlayController;
import be.iiw.coredefender.overlay.buildoverlay.BuildOverlayController;
import be.iiw.coredefender.pets.PetsController;
import be.iiw.coredefender.world.WorldController;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
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
    private PetsController petsController;
    private OverlayController overlayController;
    private BuildOverlayController buildOverlayController;

    @FXML
    void initialize() {
        createWorld();
        createCharacter();
        createPets();
        setupInput();
        startAnimation();

        Platform.runLater(() -> {
            overlayController = new OverlayController();
            buildOverlayController = new BuildOverlayController();

            overlayController.setBuildAction(this::onBuild);
            overlayController.setPetsAction(this::onPets);
            overlayController.setAttackAction(this::onAttack);
            overlayController.setLevelAction(this::onLevel);

            overlayController.show(world_pane, (Stage) world_pane.getScene().getWindow());
        });
    }

    private void createWorld() {
        WorldController worldController = new WorldController(100, 100);
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
        characterController = new CharacterController(char_model, char_view);

        character_pane.getChildren().add(char_view);
    }
    
    private void createPets() {
        petsController = new PetsController();
    }

    private void setupInput() {
        character_pane.setPickOnBounds(true);
        character_pane.setOnKeyPressed(this::onMovementInput);
        character_pane.setOnKeyReleased(this::onMovementRelease);
        character_pane.setOnMouseMoved(characterController::onMouseMoved);
        character_pane.setOnMouseDragged(characterController::onMouseMoved);
    }

    private void startAnimation() {
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(
            new CharacterAnimator(characterController, char_model),10,20);
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
