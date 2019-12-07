package model;

import java.io.Serializable;

public class Type extends Object implements Serializable{

    static final long serialVersionUID = 7L;
    
    private int ID;
    private String Name;
    public Type() {
            super();
    }
    public Type(int iD, String name) {
            super();
            ID = iD;
            Name = name;
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

	
}
