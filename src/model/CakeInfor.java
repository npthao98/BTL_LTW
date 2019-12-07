/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Duck
 */
public class CakeInfor implements Serializable{
    
    static final long serialVersionUID = 6L;
    
    private Cake cake;
    private ArrayList<Type> type;
    private ArrayList<ImageUrl> img;
    private int dem;
    
    public CakeInfor(Cake cake, ArrayList<Type> type, ArrayList<ImageUrl> img) {
        this.cake = cake;
        this.type = type;
        this.img = img;
        this.dem = 1;
    }
    
    public Cake getCake() {
        return cake;
    }
    public int getIDCake(){
        return this.cake.getID();
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

    public String getImgList(){
        return this.img.get(0).getUrl();
    }

    public int getDem(){
        return this.dem;
    }
    public void tangDem(){
        this.dem++;
    }
    public void giamDem(){
        this.dem--;
    }
    public void setDem(int t){
        this.dem = t;
    }
}
