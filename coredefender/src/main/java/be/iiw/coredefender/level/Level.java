/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package be.iiw.coredefender.level;

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

    public double upgradedHealth(double baseFullHP, double a) { // methode voor nieuwe gelevelde Health, vraagt de basis Maxhealth en grondtal a 
        return (baseFullHP * Math.pow(a, exponent)); 
    }
    
     public double upgradedDamage(double baseDamage, double a) { // methode voor nieuwe gelevelde damage
        return (baseDamage * Math.pow(a, exponent)); 
    }
    
    public double upgradedIncome(double baseIncome, double a) { // methode voor nieuwe gelevelde income voor mines 
        return (baseIncome * Math.pow(a, exponent)); 
    }
}


