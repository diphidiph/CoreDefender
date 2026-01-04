/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.iiw.coredefender.building;

import be.iiw.coredefender.level.Level;

/**
 *
 * @author Yediael Ratahinarivelo
 */
public class GoldMine_Model extends Building {
    private static final double baseFullHP = 50;
    private static final double baseIncome = 0.3;
    private double upgradedIncome;
    
    
    public GoldMine_Model(int x, int y, Level level) {
        super(BuildingType.GOLDMINE, x, y, level,baseFullHP);
        
        
        this.upgradedIncome = getIncome();
        
    }
    public final double getIncome(){
        return getLevel().upgradedIncome(baseIncome, 5);
    }   
  
            
    
}
