/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.iiw.coredefender.world;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author kinga
 */

public class WorldView extends Region {
    private int width;
    private int height;
    private final int tileSize = 64;

    public WorldView(int width, int height) {
        this.width = width;
        this.height = height;

        renderTiles();
    }

    public void renderTiles() {
        getChildren().clear();

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Rectangle tile = new Rectangle(tileSize, tileSize);
                tile.setFill(Color.web("#46583d"));
                tile.setStroke(Color.web("#3f4f39"));
                tile.setX(x * tileSize);
                tile.setY(y * tileSize);

                getChildren().add(tile);
            }
        }
    }
}