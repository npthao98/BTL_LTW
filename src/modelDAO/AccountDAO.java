package modelDAO;

import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;

import dbconnect.DBConnect;
import model.Account;

public class AccountDAO extends DAO{
	
	public static String table = "account";
	
	public static ArrayList<Account> getAll() throws ClassNotFoundException, SQLException{
		
		Connection conn = DBConnect.createConnection();
		
		String sql = "SELECT * FROM account";
		Statement state = conn.createStatement();
		ResultSet res = state.executeQuery(sql);
		ArrayList<Account> result = new ArrayList<Account>();
		while(res.next()) {
			result.add(new Account(res.getString(2), res.getString(3)));
		}
		
		conn.close();
		return result;
	}

	public static boolean checkIsExid(Account t) throws ClassNotFoundException, SQLException {
		
		Connection conn = DBConnect.createConnection();
		ArrayList<Account> list = getAll();
		for(int i = 0; i < list.size(); i++) {
			if(t.getName() == list.get(i).getName() && t.getPass() == list.get(i).getPass()) {
				return true;
			}
		}
		return false;
	}
	

}
