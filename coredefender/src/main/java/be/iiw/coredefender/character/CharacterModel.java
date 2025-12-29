/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template*/ 

package be.iiw.coredefender.character;

/** * * @author kinga */ 
public class CharacterModel { 
    private int x, y;
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
           dx = 2;
    }
    
    
    public void links() {
        dx = -2;
    }
   
      
    public void onder() {
           dy = 2;
       
    
    }    
    public void boven() {
           dy = -2;          
    } 
    public void stopX(){
        dx = 0;
    }
    public void stopY(){
        dy = 0;
    }
       
    public void tick() {
    x += dx;
    y += dy;
}
}
