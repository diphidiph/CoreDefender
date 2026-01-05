package be.iiw.coredefender.overlay.petsoverlay;

import be.iiw.coredefender.pets.Pet;
import be.iiw.coredefender.pets.PetTypeEnum;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class PetsOverlayView {

    private final AnchorPane petsPane;
    private final HBox petsBoxContainer;
    private final List<PetRow> petRows = new ArrayList<>();

    public PetsOverlayView() {
        petsPane = new AnchorPane();
        petsPane.setPrefSize(620, 500);

        Rectangle bg = new Rectangle(620, 500, Color.web("#2F3B52"));
        bg.setArcWidth(20);
        bg.setArcHeight(20);
        bg.setStroke(Color.web("#1B2640"));
        bg.setStrokeWidth(3);
        petsPane.getChildren().add(bg);

        petsBoxContainer = new HBox();
        petsBoxContainer.setAlignment(Pos.CENTER);
        petsBoxContainer.setPrefWidth(620);
        petsBoxContainer.setLayoutY(20);
        petsPane.getChildren().add(petsBoxContainer);
    }

    // ---------------------- BUILD ----------------------
    public void buildRows(PetsOverlayModel model) {
        petsBoxContainer.getChildren().clear();
        petRows.clear();

        HBox main = new HBox(20);
        main.setAlignment(Pos.CENTER);

        VBox icons = new VBox(15);
        VBox names = new VBox(15);
        VBox stats = new VBox(15);
        VBox buttons = new VBox(15);

        icons.setAlignment(Pos.CENTER);
        names.setAlignment(Pos.CENTER_LEFT);
        stats.setAlignment(Pos.CENTER_LEFT);
        buttons.setAlignment(Pos.CENTER);

        for (PetsOverlayModel.PetState state : model.getPetStates()) {

            Pet pet = state.getPet();
            PetTypeEnum type = pet.getType();

            // Icon
            ImageView icon = new ImageView(new Image(
                    getClass().getResourceAsStream(
                            "/be/iiw/coredefender/pets_resources/"
                                    + type.name().toLowerCase() + ".png"
                    )
            ));
            icon.setFitWidth(50);
            icon.setFitHeight(50);
            icons.getChildren().add(icon);

            // Name + desc
            VBox info = new VBox(5);
            Label name = new Label(pet.getName());
            name.setTextFill(Color.WHITE);
            name.setStyle("-fx-font-weight: bold");

            Label desc = new Label(pet.getDescription());
            desc.setTextFill(Color.LIGHTGRAY);

            info.getChildren().addAll(name, desc);
            names.getChildren().add(info);

            // Stats
            VBox statBox = new VBox(5);
            Label cost = new Label(
                    "Cost: " + pet.getBaseCost() + " " + pet.getBaseCostResourceType()
            );
            cost.setTextFill(Color.GOLD);

            Label lvl = new Label(
                "Lvl: " + pet.getLevel() +
                " | XP: " + pet.getXp() + "/" + pet.getXpNextLevel()
            );
            lvl.setTextFill(Color.LIGHTGREEN);

            statBox.getChildren().addAll(cost, lvl);
            stats.getChildren().add(statBox);

            // Button
            Button btn = new Button("Buy");
            btn.setStyle("-fx-background-color: #4A90E2; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 8;");
            btn.setPrefWidth(90);
            buttons.getChildren().add(btn);

            petRows.add(new PetRow(pet, state, btn, lvl));
        }

        main.getChildren().addAll(icons, names, stats, buttons);
        petsBoxContainer.getChildren().add(main);
    }

    // ---------------------- HELPERS ----------------------
    public AnchorPane getView() {
        return petsPane;
    }

    public List<PetRow> getPetRows() {
        return petRows;
    }

    // ---------------------- ROW ----------------------
    public static class PetRow {

        private final Pet pet;
        private final PetsOverlayModel.PetState state;
        private final Button actionButton;
        private final Label levelLabel;

        public PetRow(Pet pet,
                      PetsOverlayModel.PetState state,
                      Button actionButton,
                      Label levelLabel) {
            this.pet = pet;
            this.state = state;
            this.actionButton = actionButton;
            this.levelLabel = levelLabel;
        }

        public void updateStats() {
            levelLabel.setText(
                "Lvl: " + pet.getLevel() +
                " | XP: " + pet.getXp() + "/" + pet.getXpNextLevel()
            );
        }

        public Pet getPet() { return pet; }
        public PetsOverlayModel.PetState getState() { return state; }
        public Button getActionButton() { return actionButton; }
    }
}
