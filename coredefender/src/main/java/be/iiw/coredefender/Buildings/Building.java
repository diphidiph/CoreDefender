/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.iiw.coredefender.Buildings;

import be.iiw.coredefender.Enemy.EnemyModel;
import be.iiw.coredefender.Level.Level;

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
        
        this.health = getUpgradedHealth();        
        }
    
    public double getBaseMaxHealth(){
        return baseMaxHealth;
    }
    /**
     * @return the health
     */
    public final double getUpgradedHealth() {
        return level.UpgradedHealth(baseMaxHealth, 2); // x = 2 (groeifactor)
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
    
    public double takeDamage(EnemyModel enemy){         
        double damage = enemy.getUpgradedDamage();
        health -= damage;
        if (health < 0){
            health = 0;
        }
        return health;
    }
    public boolean isAlive(){
        return health > 0;
    }
    public void getHealed(){
        health = health + 0.2;
    }
    public boolean setUpgrade(){
        switch (level) {
            case level_1:
                level = Level.level_2;
                return true;
            case level_2:
                level = Level.level_3;
                return true;
            default:
                return false;
        }
    }
}
