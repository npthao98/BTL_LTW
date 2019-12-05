package model;

public class Cake_Order {
	private int ID;
	private int OrderID;
	private int CakeID;
	private int Quantity;
	public Cake_Order() {
		super();
	}
	public Cake_Order(int iD, int orderID, int cakeID, int quantity) {
		super();
		ID = iD;
		OrderID = orderID;
		CakeID = cakeID;
		Quantity = quantity;
	}
	public Cake_Order(int orderID, int cakeID, int quantity) {
		super();
		OrderID = orderID;
		CakeID = cakeID;
		Quantity = quantity;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getOrderID() {
		return OrderID;
	}
	public void setOrderID(int orderID) {
		OrderID = orderID;
	}
	public int getCakeID() {
		return CakeID;
	}
	public void setCakeID(int cakeID) {
		CakeID = cakeID;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	
	
}
