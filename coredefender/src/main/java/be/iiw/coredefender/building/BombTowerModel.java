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
public class BombTowerModel extends Building{
     private static final double baseFullHP = 100;
    
        
     public BombTowerModel(int x, int y, Level level) {
        super(BuildingType.CANON,x, y, level, baseFullHP); 
        
        }
}
