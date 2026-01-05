
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.iiw.coredefender.enemy;

import be.iiw.coredefender.level.Level;

/**
 *
 * @author Gebruiker
 */
public class EnemyModel {
    private final double baseMaxHealth = 100;
    private final double basedamage = 25;
    private double health;
    private double damage;
    private Level level;    
    private int x0, y0;
    private int x,y;
    
    public EnemyModel(int x0, int y0, Level level){
        this.x0= x0;
        this.y0= y0;
        this.level = level;
                        
        this.health = getUpgradedHealth();
        this.damage = getUpgradedDamage(); 
    }
    
    public final double getUpgradedHealth(){
        return level.upgradedHealth(baseMaxHealth, 1.8);
    }

     public final double getUpgradedDamage(){
        return level.upgradedDamage(basedamage, 1.8);
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