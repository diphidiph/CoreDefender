/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.iiw.coredefender.Enemy;

import be.iiw.coredefender.Level.Level;

/**
 *
 * @author Gebruiker
 */
public class EnemyModel {
    private int maxHealth;
    private int health;
    private Level level;
    private int damage;
    private int x0, y0;
    
    public EnemyModel(int x0, int y0, Level level){
        this.x0= x0;
        this.y0= y0;
        this.level = level;
        
        
    }
    
    
    
}
