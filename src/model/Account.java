package model;

public class Account{
	
	public static String table_name = "";
	
        private int ID;
	private String username;
	private String pass;
	
	public Account(String username, String pass) {
		this.username = username;
		this.pass = pass;
	}
	
	public String getName() {
		return this.username;
	}
	public String getPass() {
		return this.pass;
	}
        
        public void setID(int ID){
            this.ID = ID;
        }
        public int getID(){
            return this.ID;
        }
}
