/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package be.iiw.coredefender.Level;

/**
 *
 * @author Gebruiker
 */
public enum Level {
    //een enum met de levels een een getal ermee gekoppeld
    // dit zijn eigenlijk 3 objecten van type Level (met een parameter)
    level_1(0), 
    level_2(1),
    level_3(2);
    
    private final int exponent;//een datamember "exponent" die niet aanpasbaar is 

    Level(int exponent) { // de parameter van zo een Level opbject noemen we "exponent"
        this.exponent = exponent; // de datamember exponent wordt gelijk de parameter die bij een Level object ingevuld wordt 
    }

    public double nieuwMaxHealth(int baseMaxHealth, int a) { // methode voor nieuwe gelevelde Health, vraagt de volle health in het begin en grondtal a  
        return (baseMaxHealth * Math.pow(a, exponent)); 
    }
}


