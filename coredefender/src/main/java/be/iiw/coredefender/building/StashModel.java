/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.iiw.coredefender.building;

import be.iiw.coredefender.level.Level;

public class StashModel extends Building {
    private double goldAmount; 
    private static final double baseFullHP = 200;
    
        
     public StashModel(int x, int y, Level level) {
        super(BuildingType.GOLDSTASH,x, y, level, baseFullHP); 
        this.goldAmount = 0;
    }
    
    public void addGold(double income){
        goldAmount += income;
        }
    public double getGoldAmount(){
        return goldAmount;                       
        }
         
      
    
    
}
