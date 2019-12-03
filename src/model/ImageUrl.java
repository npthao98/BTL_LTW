package model;

public class ImageUrl {
	private int ID;
	private int CakeID;
	private String Url;
	public ImageUrl() {
		super();
	}
	public ImageUrl(int iD, int cakeID, String url) {
		super();
		ID = iD;
		CakeID = cakeID;
		Url = url;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getCakeID() {
		return CakeID;
	}
	public void setCakeID(int cakeID) {
		CakeID = cakeID;
	}
	public String getUrl() {
		return Url;
	}
	public void setUrl(String url) {
		Url = url;
	}
	
	
}
