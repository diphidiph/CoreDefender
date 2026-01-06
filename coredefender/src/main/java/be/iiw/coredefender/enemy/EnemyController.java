/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package be.iiw.coredefender.enemy;

import be.iiw.coredefender.building.StashModel;
import java.util.ArrayList;
import java.util.Iterator;

public class EnemyController {

    private final ArrayList<EnemyModel> enemies = new ArrayList<>();
    private final StashModel stash;

    public EnemyController(StashModel stash) {
        this.stash = stash;
    }

    public void update(double deltaTime) {

        Iterator<EnemyModel> it = enemies.iterator();

        while (it.hasNext()) {
            EnemyModel enemy = it.next();

            enemy.update(deltaTime, stash.getX(), stash.getY());

            if (!enemy.isAlive()) {
                it.remove();
            } 
            else if (isColliding(enemy)) {
                stash.takeDamage(enemy.getDamage());
                it.remove();
            }
        }
    }

    private boolean isColliding(EnemyModel enemy) {
        double dx = enemy.getX() - stash.getX();
        double dy = enemy.getY() - stash.getY();
        return Math.sqrt(dx * dx + dy * dy) < 15;
    }

    public void addEnemy(EnemyModel enemy) {
        enemies.add(enemy);
    }

    public ArrayList<EnemyModel> getEnemies() {
        return enemies;
    }
}
