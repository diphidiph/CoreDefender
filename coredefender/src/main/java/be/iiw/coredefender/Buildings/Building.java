/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.iiw.coredefender.Buildings;

import be.iiw.coredefender.Level.Level;
import be.iiw.coredefender.Level.LevelEffect;

/**
 *
 * @author Gebruiker
 */
public abstract class Building {
    private double baseMaxHealth;
    private double health;
    private int x,y;
    private Level level;

    public Building(int x, int y, Level level,double baseMaxHealth) {
        this.x = x;
        this.y = y;
        this.level= level;
        this.baseMaxHealth = baseMaxHealth;
        
        this.health = getLeveledHealth();{
        return level.(baseMaxHealth, 2); // x = 2 (groeifactor)
    }
    }
    public int getBaseMaxHealth(){
        return baseMaxHealth;
    }
    /**
     * @return the health
     */
    public int getLeveledHealth() {
        
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @return the level
     */
    public Level getLevel() {
        return level;
    }
    
     public int getdamage(){
        int damage = Enemy.getdamage();
        health -= damage;
        if (health < 0) health = 0;
        return health;
    }
}
