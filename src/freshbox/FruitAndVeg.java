/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package freshbox;

/**
 *
 * @author Emily
 */
public class FruitAndVeg {
    public String fvName;
    //private double fvPrice;
    //private double fvWeight;
    
    /**
     *constructor
     */
    public FruitAndVeg () {
        
    }
    
    public FruitAndVeg(String fvName){
        this.fvName = fvName;
    }

    /**
     *
     * set method
     */
    public void setFvName(String name){
        fvName = name;
    }

    /**
     *
     * get method
     */
    public String getFvName() {
        return fvName;
    }
    
}
