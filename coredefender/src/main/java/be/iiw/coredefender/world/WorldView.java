/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.iiw.coredefender.world;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author kinga
 */

public class WorldView extends Region {
        private final int tileSize = 36;
        private final int viewWidth;  // in tiles
        private final int viewHeight; // in tiles
        private final Rectangle[][] tileGrid;

        private final int worldWidth;  // in tiles
        private final int worldHeight; // in tiles

    public WorldView(int worldWidth, int worldHeight, int viewWidth, int viewHeight) {
        this.worldWidth = worldWidth;
        this.worldHeight = worldHeight;
        this.viewWidth = viewWidth;
        this.viewHeight = viewHeight;

        tileGrid = new Rectangle[viewWidth][viewHeight];
        initializeTiles();
    }
    
    private void initializeTiles() {
        for (int x = 0; x < viewWidth; x++) {
            for (int y = 0; y < viewHeight; y++) {
                Rectangle tile = new Rectangle(tileSize, tileSize);
                tile.setFill(Color.web("#46583d"));
                tile.setStroke(Color.web("#3f4f39"));
                tileGrid[x][y] = tile;
                getChildren().add(tile);
            }
        }
    }
    
    public void updateTiles(double playerX, double playerY) {
        int centerTileX = (int) (playerX / tileSize);
        int centerTileY = (int) (playerY / tileSize);

        for (int x = 0; x < viewWidth; x++) {
            for (int y = 0; y < viewHeight; y++) {
                int worldX = centerTileX - viewWidth / 2 + x;
                int worldY = centerTileY - viewHeight / 2 + y;

                Rectangle tile = tileGrid[x][y];

                if (worldX >= 0 && worldX < worldWidth && worldY >= 0 && worldY < worldHeight) {
                    tile.setVisible(true);
                    tile.setX(worldX * tileSize);
                    tile.setY(worldY * tileSize);
                } else {
                    tile.setVisible(false);
                }
            }
        }
    }

    public void renderResources(Iterable<ResourceModel> resources) {
        for (ResourceModel r : resources) {
            Circle c = new Circle(64);
            c.setLayoutX(r.getX());
            c.setLayoutY(r.getY());

            if (r.getType() == ResourceType.TREE) {
                c.setFill(Color.FORESTGREEN);
                c.setUserData("TREE");
            } else {
                c.setFill(Color.GRAY);
                c.setUserData("STONE");
            }

            getChildren().add(c);
        }
    }
}
