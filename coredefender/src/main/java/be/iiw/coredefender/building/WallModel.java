/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.iiw.coredefender.building;

import be.iiw.coredefender.level.Level;

/**
 *
 * @author Gebruiker
 */
public class WallModel extends Building {
     private static final double baseFullHP = 100;
    
        
     public WallModel(int x, int y, Level level) {
        super(BuildingType.WALL,x, y, level, baseFullHP); 
        
        }
     
      @Override
    public double getRadius() {
        return 34;
    }
   
         
}
