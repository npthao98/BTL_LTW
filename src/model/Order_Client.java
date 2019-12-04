package model;

public class Order_Client {
	private int OrderID;
	private int ClientID;
	public Order_Client() {
		super();
	}
	public Order_Client(int orderID, int clientID) {
		super();
		OrderID = orderID;
		ClientID = clientID;
	}
	public int getOrderID() {
		return OrderID;
	}
	public void setOrderID(int orderID) {
		OrderID = orderID;
	}
	public int getClientID() {
		return ClientID;
	}
	public void setClientID(int clientID) {
		ClientID = clientID;
	}
	
	
}
