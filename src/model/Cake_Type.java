package model;

public class Cake_Type {
	private int CakeID;
	private int TypeID;
	public Cake_Type() {
		super();
	}
	public Cake_Type(int cakeID, int typeID) {
		super();
		CakeID = cakeID;
		TypeID = typeID;
	}
	public int getCakeID() {
		return CakeID;
	}
	public void setCakeID(int cakeID) {
		CakeID = cakeID;
	}
	public int getTypeID() {
		return TypeID;
	}
	public void setTypeID(int typeID) {
		TypeID = typeID;
	}
	
	
}
