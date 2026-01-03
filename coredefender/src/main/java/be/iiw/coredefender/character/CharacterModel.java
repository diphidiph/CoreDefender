/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template*/ 

package be.iiw.coredefender.character;

/** * * @author kinga */ 

public class CharacterModel { 
    private int x, y;
    private int dx, dy;
    private double rotation;
    private final int v = 6;

    private int wood = 0;
    private int stone = 0;
    private int gold = 0;

    public CharacterModel() {
        this(0,0);
    }

    public CharacterModel(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setRotation(double rotation) {
        this.rotation = rotation;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public double getRotation() { return rotation; }

    public void rechts() { dx = v; }
    public void links() { dx = -v; }
    public void onder() { dy = v; }
    public void boven() { dy = -v; }

    public void stopX() { dx = 0; }
    public void stopY() { dy = 0; }

    public void tick(int worldWidth, int worldHeight, double charWidth, double charHeight) {
        x += dx;
        y += dy;

        // inside world
        if (x < 0) x = 0;
        if (y < 0) y = 0;
        if (x > worldWidth - charWidth) x = (int)(worldWidth - charWidth);
        if (y > worldHeight - charHeight) y = (int)(worldHeight - charHeight);
    }

    public void addWood() { wood++; }
    public void addStone() { stone++; }
    public void addGold() { gold++; }
    
    public void removeWood() {
        if (wood >= 0) {
        wood--;
        }
    }
    public void removeStone() {
        if (stone >= 0) {
        stone--;
        }
    }

    public void removeGold() {
        if (gold >= 0) {
        gold--;
        }
    }

    public int getWoodCount() { return wood; }
    public int getStoneCount() { return stone; }
    public int getGoldCount() { return gold; }
}
