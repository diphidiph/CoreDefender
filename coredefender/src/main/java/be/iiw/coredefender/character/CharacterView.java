package be.iiw.coredefender.character;

import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class CharacterView extends Region {

    private final CharacterModel char_model;

    public CharacterView(CharacterModel model) {
        this.char_model = model;

        setPickOnBounds(false);

        Circle lichaam = new Circle(0, 0, 30, Color.web("#9e7b5c"));
        lichaam.setStroke(Color.web("#262235"));
        lichaam.setStrokeWidth(2);

        Circle linker_arm = new Circle(18, -23, 12, Color.web("#8c6b54"));
        linker_arm.setStroke(Color.web("#262235"));
        linker_arm.setStrokeWidth(2);

        Circle rechter_arm = new Circle(18, 23, 12, Color.web("#8c6b54"));
        rechter_arm.setStroke(Color.web("#262235"));
        rechter_arm.setStrokeWidth(2);

        getChildren().addAll(linker_arm, rechter_arm, lichaam);

        setMinSize(0, 0);
        setPrefSize(0, 0);
        setMaxSize(0, 0);

        update();
    }

    public void update() {
        setTranslateX(char_model.getX());
        setTranslateY(char_model.getY());
        setRotate(char_model.getRotation());
    }
}
