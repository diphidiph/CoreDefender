
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.iiw.coredefender.enemy;

import be.iiw.coredefender.collidable.Collidable;
import be.iiw.coredefender.level.Level;

public class EnemyModel implements Collidable{



    // basis stats
    private final double baseMaxHealth = 100;
    private final double baseDamage = 5;
    private final double speed = 3;

    // dynamische stats
    private double health;
    private double damage;
    private Level level;
    

    // positie
    private double x;
    private double y;

    // Maakt een nieuwe enemy aan met type
    public EnemyModel(double startX, double startY, Level level) {
        this.x = startX;
        this.y = startY;
        this.level = level;
        this.health = getUpgradedHealth();
        this.damage = getUpgradedDamage();
    }

    // ===== Movement =====
    public void update(double deltaTime, double targetX, double targetY) {
        moveTowards(targetX, targetY, deltaTime);
    }

    private void moveTowards(double targetX, double targetY, double deltaTime) {
        double dx = targetX - x;
        double dy = targetY - y;

        double length = Math.sqrt(dx * dx + dy * dy);
        if (length == 0) return;

        dx /= length;
        dy /= length;

        x += dx * speed * deltaTime;
        y += dy * speed * deltaTime;
    }

    // ===== Combat =====
    public void takeDamage(double amount) {
        health -= amount;
        if (health < 0) health = 0;
    }

    public boolean isAlive() {
        return health > 0;
    }

    // ===== Level scaling =====
    private double getUpgradedHealth() {
        return level.upgradedHealth(baseMaxHealth, 1.8);
    }

    private double getUpgradedDamage() {
        return level.upgradedDamage(baseDamage, 1.8);
    }

    public double getHealth() {
        return health;
    }

    public double getDamage() {
        return damage;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Level getLevel() {
        return level;
    }
    @Override
    public double getRadius() {
        return 10;
    }
}

