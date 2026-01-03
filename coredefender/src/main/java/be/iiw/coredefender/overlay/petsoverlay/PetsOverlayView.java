package be.iiw.coredefender.overlay.petsoverlay;

import be.iiw.coredefender.pets.PetTypeEnum;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.layout.VBox;

public class PetsOverlayView {

    private final AnchorPane petsPane;
    private final HBox petsBoxContainer;
    private final List<PetRow> petRows = new ArrayList<>();

    public PetsOverlayView() {
        petsPane = new AnchorPane();
        petsPane.setPrefSize(620, 500);

        // Background rectangle
        Rectangle bg = new Rectangle(620, 500, Color.web("#2F3B52"));
        bg.setArcWidth(20);
        bg.setArcHeight(20);
        bg.setStroke(Color.web("#1B2640"));
        bg.setStrokeWidth(3);
        petsPane.getChildren().add(bg);

        // VBox to center rows vertically
        petsBoxContainer = new HBox();
        petsBoxContainer.setAlignment(Pos.CENTER);
        petsBoxContainer.setPrefWidth(620);
        petsBoxContainer.setLayoutY(20);
        petsPane.getChildren().add(petsBoxContainer);
    }

    // ---------------------- BUILD ROWS ----------------------
    public void buildRows(PetsOverlayModel model) {
        petsBoxContainer.getChildren().clear();
        petRows.clear();

        HBox mainRowContainer = new HBox(20); // spacing between columns
        mainRowContainer.setAlignment(Pos.CENTER);

        VBox iconsColumn = new VBox(15);
        VBox namesColumn = new VBox(15);
        VBox statsColumn = new VBox(15);
        VBox buttonsColumn = new VBox(15);

        iconsColumn.setAlignment(Pos.CENTER);
        namesColumn.setAlignment(Pos.CENTER_LEFT);
        statsColumn.setAlignment(Pos.CENTER_LEFT);
        buttonsColumn.setAlignment(Pos.CENTER);

        for (PetsOverlayModel.PetState state : model.getPetStates()) {
            PetTypeEnum pet = state.getPet();

            // Icon
            ImageView icon = new ImageView(new Image(getClass().getResourceAsStream(
                    "/be/iiw/coredefender/pets_resources/" + pet.name().toLowerCase() + ".png")));
            icon.setFitWidth(50);
            icon.setFitHeight(50);
            iconsColumn.getChildren().add(icon);

            // Name + Description
            VBox infoBox = new VBox(5);
            infoBox.setAlignment(Pos.CENTER_LEFT);

            Label nameLabel = new Label(pet.getName());
            nameLabel.setTextFill(Color.WHITE);
            nameLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 14px;");

            Label descLabel = new Label(pet.getDescription());
            descLabel.setTextFill(Color.LIGHTGRAY);
            descLabel.setStyle("-fx-font-size: 12px;");

            infoBox.getChildren().addAll(nameLabel, descLabel);
            namesColumn.getChildren().add(infoBox);

            // Cost + Level/XP
            VBox statsBox = new VBox(5);
            statsBox.setAlignment(Pos.CENTER_LEFT);

            Label costLabel = new Label("Cost: " + pet.getBaseCost() + " " + pet.getBaseCostResourceType());
            costLabel.setTextFill(Color.GOLD);
            costLabel.setStyle("-fx-font-size: 12px; -fx-font-weight: bold;");

            Label lvlLabel = new Label("Lvl: " + pet.getLvl() + " | XP: " + pet.getXp() + "/100");
            lvlLabel.setTextFill(Color.LIGHTGREEN);
            lvlLabel.setStyle("-fx-font-size: 12px;");

            statsBox.getChildren().addAll(costLabel, lvlLabel);
            statsColumn.getChildren().add(statsBox);

            // Action Button
            Button actionBtn = new Button("Buy");
            actionBtn.setPrefWidth(90);
            actionBtn.setPrefHeight(30);
            actionBtn.setStyle("-fx-background-color: #4A90E2; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 8;");
            buttonsColumn.getChildren().add(actionBtn);

            petRows.add(new PetRow(pet, state, actionBtn));
        }

        mainRowContainer.getChildren().addAll(iconsColumn, namesColumn, statsColumn, buttonsColumn);
        petsBoxContainer.getChildren().add(mainRowContainer);
    }

    // ---------------------- HELPERS ----------------------
    public AnchorPane getView() {
        return petsPane;
    }

    public List<PetRow> getPetRows() {
        return petRows;
    }

    public static class PetRow {
        private final PetTypeEnum pet;
        private final PetsOverlayModel.PetState state;
        private final Button actionButton;

        public PetRow(PetTypeEnum pet, PetsOverlayModel.PetState state, Button actionButton) {
            this.pet = pet;
            this.state = state;
            this.actionButton = actionButton;
        }

        public PetTypeEnum getPet() {
            return pet;
        }

        public PetsOverlayModel.PetState getState() {
            return state;
        }

        public Button getActionButton() {
            return actionButton;
        }
    }
}
