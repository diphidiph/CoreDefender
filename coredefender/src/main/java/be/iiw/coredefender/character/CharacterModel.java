/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.iiw.coredefender.character;

/**
 *
 * @author kinga
 */
public class CharacterModel {
    private int x,y;
    private int dx,dy;
    
    public CharacterModel() {
        this(0,0);
    }
    
    public CharacterModel(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public void rechts() {
        if(dx <= 3) {
            dx++;
        }
    }
    
    public void links() {
        if(dx >= -3) {
            dx--;
        }
    }
    
    public void onder() {
        if(dy <= 3) {
            dy++;
        }
    }
    
    public void boven() {
        if(dy >= -3) {
            dy--;
        }
    }
    
    public void tick() {
        x += dx;
        y += dy;
    }
}
