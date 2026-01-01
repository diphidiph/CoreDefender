/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.iiw.coredefender.Buildings;

import be.iiw.coredefender.Level.Level;

public class Stash_Model extends Building {
    private double goldAmount; 
    private static final double baseFullHP = 200;
    
        
     public Stash_Model(int x, int y, Level level) {
        super(x, y, level, baseFullHP); 
        this.goldAmount = 0;
    }
    
    public void addGold(double income){
        goldAmount += income;
        }
    public double getGoldAmount(){
        return goldAmount;                       
        }
         
      
    
    
}
