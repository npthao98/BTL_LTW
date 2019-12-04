package model;

public class Client {
	private int ID;
	private String Name;
	private String Address;
	private String Phone;
	private String Email;
	public Client() {
		
	}
  	public Client(String name, String address, String phone, String email){
            Name = name;
            Address = address;
            Phone = phone;
            Email = email;
	}      
	public Client(int iD, String name, String address, String phone, String email) {
            ID = iD;
            Name = name;
            Address = address;
            Phone = phone;
            Email = email;
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
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
	
}
