/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.iiw.coredefender.Buildings;

import be.iiw.coredefender.Enemy.EnemyModel;
import be.iiw.coredefender.Level.Level;

/**
 *
 * @author Ratahinarivelo Yediael
 * Dit is de abstracte classe voor alle gebouwen. 
 */
public abstract class Building {
    private double baseFullHP; //de normale (niet-geüpgrade) max health.
    private double HP;
    private int x,y; // een gebouw heeft een positie waarop hij geplaatst is.
    private Level level;

    public Building(int x, int y, Level level,double baseFullHP) {
        this.x = x;
        this.y = y;
        this.level= level;
        this.baseFullHP = baseFullHP; 
        
        
        this.HP = getMaxHealth();//health begint altijd vol (en is afhankelijk van de level)     
        }
    
    public double getBaseMaxHealth(){
        return baseFullHP;
    }
    /**
     * @return the health
     */
    public final double getMaxHealth() {
        return level.upgradedHealth(baseFullHP, 2); // x = 2 (groeifactor)
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
        HP -= damage;
        if (HP < 0){
            HP = 0;
        }
        return HP;
    }
    public boolean isAlive(){
        return HP > 0;
    }
    public void getHealed(){
        HP = HP + 0.2;
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
