/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template*/ 

package be.iiw.coredefender.character;

/** * * @author kinga */ 
public class CharacterModel { 
    private int x, y;
    private int dx,dy;
    private double rotation;
    private final int v = 4; //velocity
        
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
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public double getRotation() {
        return rotation;
    }
    
    public void rechts() {
        dx = v;
    }
    
    
    public void links() {
        dx = -v;
    }
   
      
    public void onder() {
        dy = v;
    }    
    
    public void boven() {
        dy = -v;          
    }
    
    public void stopX() {
        dx = 0;
    }
    
    public void stopY() {
        dy = 0;
    }
       
    public void tick() {
        x += dx;
        y += dy;
    }
}
