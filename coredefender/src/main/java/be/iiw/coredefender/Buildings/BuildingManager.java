/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.iiw.coredefender.Buildings;

import be.iiw.coredefender.Level.Level;
import java.util.ArrayList;

/**
 *
 * @author Gebruiker
 */
public class MineList {
    private ArrayList<GoldMine_Model> MineList;
    private final int MAX_AANTAL= 6; //aantal mines
    
    public MineList(){
        MineList =  new ArrayList<>();        
        
        for (int i=0;i < MAX_AANTAL; i++){
            MineList.add(new GoldMine_Model(Level.level_1));
}
}
