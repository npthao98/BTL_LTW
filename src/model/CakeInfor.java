/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Duck
 */
public class CakeInfor {
    private Cake cake;
    private ArrayList<Type> type;

    public CakeInfor(Cake cake, ArrayList<Type> type) {
        this.cake = cake;
        this.type = type;
    }
    
    public Cake getCake() {
        return cake;
    }

    public ArrayList<Type> getType() {
        return type;
    }

    public void setCake(Cake cake) {
        this.cake = cake;
    }

    public void setType(ArrayList<Type> type) {
        this.type = type;
    }


    
}
