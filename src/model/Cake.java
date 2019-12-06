package model;

import java.io.Serializable;
import java.sql.Date;

public class Cake implements Serializable{
    
    static final long serialVersionUID = 5L;
     
    private int ID;
    private String Name;
    private int Price;
    private String Description;
    public Cake(int iD, String name, int price, String description) {
            super();
            ID = iD;
            Name = name;
            Price = price;
            Description = description;
    }
    public Cake() {

    }
    public int getID() {
            return ID;
    }
    public void setID(int iD) {
            ID = iD;
    }
    public String getName() {
            return Name;
    }
    public void setName(String name) {
            Name = name;
    }
    public int getPrice() {
            return Price;
    }
    public void setPrice(int price) {
            Price = price;
    }
    public String getDescription() {
            return Description;
    }
    public void setDescription(String description) {
            Description = description;
    }

	

}