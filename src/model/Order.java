package model;

public class Order {
	private int ID;
	private String Time;
	private int Total;
	private String Address;
	private int State;
	public Order() {
		super();
	}
	public Order(int iD, String time, int total,String address, int state ) {
		super();
		ID = iD;
		Time = time;
		Address = address;
		Total = total;
		State = state;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getTime() {
		return Time;
	}
	public void setTime(String time) {
		Time = time;
	}
	public int getTotal() {
		return Total;
	}
	public void setTotal(int total) {
		Total = total;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public int getState() {
		return State;
	}
	public void setState(int state) {
		State = state;
	}
	@Override
	public String toString() {
		return "Order [ID=" + ID + ", Time=" + Time + ", Total=" + Total + ", State=" + State + "]";
	}
	
	
}
