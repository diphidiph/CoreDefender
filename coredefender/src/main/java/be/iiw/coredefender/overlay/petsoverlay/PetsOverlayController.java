package be.iiw.coredefender.overlay.petsoverlay;

import be.iiw.coredefender.character.CharacterModel;
import be.iiw.coredefender.overlay.OverlayView;
import be.iiw.coredefender.pets.PetTypeEnum;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class PetsOverlayController {

    private final PetsOverlayModel model;
    private final PetsOverlayView view;

    private final CharacterModel character;
    private final OverlayView overlayView;

    private boolean visible = false;

    // ---------------------- CONSTRUCTOR ----------------------
    public PetsOverlayController(CharacterModel character, OverlayView overlayView) {
        this.character = character;
        this.overlayView = overlayView;

        this.model = new PetsOverlayModel();
        this.view = new PetsOverlayView();

        view.buildRows(model);
        wireButtons();
    }

    // ---------------------- BUTTONS LINKEN ----------------------
    private void wireButtons() {
        for (PetsOverlayView.PetRow row : view.getPetRows()) {
            PetTypeEnum pet = row.getPet();
            row.getActionButton().setOnAction(e -> onPetButtonPressed(pet));
            updateButton(row);
        }
    }

    // ---------------------- BUTTON LOGICA ----------------------
    private void onPetButtonPressed(PetTypeEnum pet) {
        PetsOverlayModel.PetState state = model.getState(pet);

        if (!state.unlocked) {
            attemptPurchase(pet);
        } else {
            selectPet(pet);
        }

        refreshButtons();
    }

    // ---------------------- PET KOPEN ----------------------
    private void attemptPurchase(PetTypeEnum pet) {
        if (!canAfford(pet)) {
            System.out.println("Not enough resources to buy " + pet.getName());
            return;
        }

        payForPet(pet);
        model.unlockPet(pet);

        System.out.println("Unlocked pet: " + pet.getName());
        refreshInventoryOverlay();
    }

    private boolean canAfford(PetTypeEnum pet) {
        switch (pet.getBaseCostResourceType().toLowerCase()) {
            case "wood":  return character.getWoodCount()  >= pet.getBaseCost();
            case "stone": return character.getStoneCount() >= pet.getBaseCost();
            case "gold":  return character.getGoldCount()  >= pet.getBaseCost();
            default:      return false;
        }
    }

    private void payForPet(PetTypeEnum pet) {
        switch (pet.getBaseCostResourceType().toLowerCase()) {
            case "wood":
                for (int i = 0; i < pet.getBaseCost(); i++) character.removeWood();
                break;
            case "stone":
                for (int i = 0; i < pet.getBaseCost(); i++) character.removeStone();
                break;
            case "gold":
                for (int i = 0; i < pet.getBaseCost(); i++) character.removeGold();
                break;
        }
    }

    // ---------------------- SELECTEREN ----------------------
    private void selectPet(PetTypeEnum pet) {
        model.selectPet(pet);
        System.out.println("Selected pet: " + pet.getName());
    }

    // ---------------------- UI UPDATES ----------------------
    private void refreshButtons() {
        for (PetsOverlayView.PetRow row : view.getPetRows()) {
            updateButton(row);
        }
    }

    private void updateButton(PetsOverlayView.PetRow row) {
        PetsOverlayModel.PetState state = row.getState();
        switchStateText(row.getActionButton(), state);
    }

    private void switchStateText(javafx.scene.control.Button btn, PetsOverlayModel.PetState state) {
        if (!state.unlocked) {
            btn.setText("Buy");
        } else if (state.selected) {
            btn.setText("Selected");
        } else {
            btn.setText("Select");
        }
    }

    private void refreshInventoryOverlay() {
        overlayView.updateInventory(
                character.getWoodCount(),
                character.getStoneCount(),
                character.getGoldCount()
        );
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
    public PetsOverlayView getView() {
        return view;
    }

    public PetsOverlayModel getModel() {
        return model;
    }

    public boolean isVisible() {
        return visible;
    }
}
