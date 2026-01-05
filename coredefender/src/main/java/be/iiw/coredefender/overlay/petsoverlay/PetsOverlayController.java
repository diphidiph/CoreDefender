package be.iiw.coredefender.overlay.petsoverlay;

import be.iiw.coredefender.character.CharacterModel;
import be.iiw.coredefender.overlay.OverlayView;
import be.iiw.coredefender.pets.Pet;
import be.iiw.coredefender.pets.PetsController;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class PetsOverlayController {

    private final PetsOverlayModel model;
    private final PetsOverlayView view;
    private final PetsController petsController;

    private final CharacterModel character;
    private final OverlayView overlayView;

    private boolean visible = false;

    // ---------------------- CONSTRUCTOR ----------------------
    public PetsOverlayController(
            CharacterModel character,
            OverlayView overlayView,
            PetsController petsController
    ) {
        this.character = character;
        this.overlayView = overlayView;
        this.petsController = petsController;

        this.model = new PetsOverlayModel();
        this.view = new PetsOverlayView();

        view.buildRows(model);
        wireButtons();
    }

    // ---------------------- BUTTONS LINKEN ----------------------
    private void wireButtons() {
        for (PetsOverlayView.PetRow row : view.getPetRows()) {
            Pet pet = row.getPet();
            row.getActionButton().setOnAction(e -> onPetButtonPressed(pet));
            updateButton(row);
        }
    }

    // ---------------------- BUTTON LOGICA ----------------------
    private void onPetButtonPressed(Pet pet) {
        PetsOverlayModel.PetState state = model.getState(pet);
        if (state == null) return;

        if (!state.unlocked) {
            attemptPurchase(pet);
        } else {
            selectPet(pet);
        }

        refreshButtons();
    }

    // ---------------------- PET KOPEN ----------------------
    private void attemptPurchase(Pet pet) {
        if (!canAfford(pet)) {
            System.out.println("Not enough resources to buy " + pet.getName());
            return;
        }

        payForPet(pet);
        model.unlockPet(pet);

        System.out.println("Unlocked pet: " + pet.getName());
        refreshInventoryOverlay();
    }

    private boolean canAfford(Pet pet) {
        int cost = pet.getBaseCost();
        String type = pet.getBaseCostResourceType();
        if (type == null) return false;

        switch (type.toLowerCase()) {
            case "wood":
                return character.getWoodCount() >= cost;
            case "stone":
                return character.getStoneCount() >= cost;
            case "gold":
                return character.getGoldCount() >= cost;
            default:
                return false;
        }
    }

    private void payForPet(Pet pet) {
        int cost = pet.getBaseCost();
        String type = pet.getBaseCostResourceType();
        if (type == null) return;

        switch (type.toLowerCase()) {
            case "wood":
                for (int i = 0; i < cost; i++) character.removeWood();
                break;
            case "stone":
                for (int i = 0; i < cost; i++) character.removeStone();
                break;
            case "gold":
                for (int i = 0; i < cost; i++) character.removeGold();
                break;
        }
    }

    // ---------------------- SELECTEREN ----------------------
    private void selectPet(Pet pet) {
        model.selectPet(pet);
        petsController.selectPet(pet);
    }

    // ---------------------- UI UPDATES ----------------------
    private void refreshButtons() {
        for (PetsOverlayView.PetRow row : view.getPetRows()) {
            updateButton(row);
        }
    }

    private void updateButton(PetsOverlayView.PetRow row) {
        PetsOverlayModel.PetState state = row.getState();

        if (!state.unlocked) {
            row.getActionButton().setText("Buy");
        } else if (state.selected) {
            row.getActionButton().setText("Selected");
        } else {
            row.getActionButton().setText("Select");
        }
    }

    private void refreshInventoryOverlay() {
        overlayView.updateBuildingMaterials(
                character.getWoodCount(),
                character.getStoneCount());                
    }

    // ---------------------- OVERLAY TOGGLE ----------------------
    public void toggle(AnchorPane parentPane, Stage stage) {
        AnchorPane petsPane = view.getView();

        if (!visible) {
            if (!parentPane.getChildren().contains(petsPane)) {
                parentPane.getChildren().add(petsPane);
            }

            petsPane.setLayoutX((stage.getScene().getWidth() - petsPane.getPrefWidth()) / 2);
            petsPane.setLayoutY((stage.getScene().getHeight() - petsPane.getPrefHeight()) / 2);
            visible = true;
        } else {
            parentPane.getChildren().remove(petsPane);
            visible = false;
        }
    }

    // ---------------------- GETTERS ----------------------
    public boolean isVisible() {
        return visible;
    }
    
    public void refreshPetStats() {
        for (PetsOverlayView.PetRow row : view.getPetRows()) {
            row.updateStats();
        }
    }

    public void refresh() {
        view.buildRows(model);
        wireButtons();
    }

}
