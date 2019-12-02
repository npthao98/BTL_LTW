package model;

public class Account extends Model	{
	
	public static String table_name = "";
	
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
	@Override
	public void create(Model t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Model t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Model t) {
		// TODO Auto-generated method stub
		
	}

}
