/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.iiw.coredefender.pets;

import be.iiw.coredefender.character.CharacterModel;
import be.iiw.coredefender.overlay.OverlayController;
import be.iiw.coredefender.world.ResourceType;
import javafx.scene.layout.Pane;
/**
 *
 * @author kinga
 */

// Maakt actieve pet aan
// Update movement, harvesting en xp
// Nodig om Overlay te updaten
public class PetsController {
    private final CharacterModel characterModel;
    private final OverlayController overlayController;
    private final Pane worldRoot;
    private PetsModel petModel;
    private PetsView petView;

    // Maakt een PetsController aan met owner, worldRoot, overlayController
    public PetsController(
            CharacterModel owner,
            Pane worldRoot,
            OverlayController overlayController
    ) {
        this.characterModel = owner;
        this.worldRoot = worldRoot;
        this.overlayController = overlayController;
    }

    // Selecteer een pet en maakt het actief
    public void selectPet(Pet pet) {
        if(petModel != null) {
        }
        else {
            petModel = new PetsModel(characterModel, pet);
            petView = new PetsView();

            worldRoot.getChildren().add(petView.getNode());
        }
    }

    // Update (elke game-tick): verplaatsingen, model, stats
    public void update() {
        if(petModel == null) {
            return;
        }
        else {
            int woodBefore = characterModel.getWoodCount();
            int stoneBefore = characterModel.getStoneCount();

            petModel.update();

            petView.getNode().setTranslateX(petModel.getX());
            petView.getNode().setTranslateY(petModel.getY());

            // Controleert of het pet resources heeft geharvest
            if (characterModel.getWoodCount() != woodBefore || characterModel.getStoneCount() != stoneBefore) {
                overlayController.updateInventory(characterModel);
                overlayController.refreshPetStats();
            }
        }
    }

    // Laat het pet beginnen met harvesten van een resource. (x en y coordinaten van resource)
    public void startHarvest(ResourceType type, double x, double y) {
        if (petModel == null) return;
        petModel.startHarvest(type, x, y);
    }
}
