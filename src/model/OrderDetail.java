package model;

import java.util.List;

public class OrderDetail {
	private int id;
	private String address;
	private int total;
	private int state;
	List<OrderItem> orderItem;
	public OrderDetail(int id, String address, int total, int state, List<OrderItem> orderItem) {
		super();
		this.id = id;
		this.address = address;
		this.total = total;
		this.state = state;
		this.orderItem = orderItem;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public List<OrderItem> getOrderItem() {
		return orderItem;
	}
	public void setOrderItem(List<OrderItem> orderItem) {
		this.orderItem = orderItem;
	}
	
	
}
