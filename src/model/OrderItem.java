package model;

/**
 * @author N.P Thao
 *
 */
public class OrderItem {

	
	private String cakeName;
	
	private int quantity;
	

	public OrderItem(String cakeName, int quantity) {
		super();
		this.cakeName = cakeName;
		this.quantity = quantity;
	}

	public String getCakeName() {
		return cakeName;
	}

	public void setCakeName(String cakeName) {
		this.cakeName = cakeName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
	
	
}
