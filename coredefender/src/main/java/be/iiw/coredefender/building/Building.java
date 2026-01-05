/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 * R. Yediael
 */
package be.iiw.coredefender.building;


import be.iiw.coredefender.collidable.Collidable;
import be.iiw.coredefender.level.Level;

/**
 *
 * @author Ratahinarivelo Yediael
 * Dit is de abstracte classe voor alle gebouwen. 
 */
public abstract class Building implements Collidable{
    private final double baseFullHP; //de normale (niet-geüpgrade) max health.
    private double HP;
    private int x,y; // een gebouw heeft een positie waarop hij geplaatst is.
    private Level level;
    private double collX, collY;    // middelpunt voor collision
    private int width, height;

    public Building(BuildingType type,int x, int y, Level level,double baseFullHP) {
        this.x = x;
        this.y = y;
        this.level= level;
        this.baseFullHP = baseFullHP; 
        this.width = type.getWidth();
        this.height = type.getHeight();
        this.collX = x + width / 2;
        this.collY = y + height / 2;
        
        
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
    public double getRenderX() {
        return x;
    }

    /**
     * @return the y
     */
    public double getRenderY() {
        return y;
    }
    
    @Override
    public double getX() {
        return collX;
    }
    @Override
    public double getY() {
        return collY;
    }
    

    /**
     * @return the level
     */
    public Level getLevel() {
        return level;
    }
    
    public double takeDamage(double damage){        
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
    
     @Override
    public double getRadius() {
        return 34; // bijv groter gebouw
    }
    
}
