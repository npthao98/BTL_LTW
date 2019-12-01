package modelDAO;

import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;

public class AccountDAO extends DAO{
	public static String table = "acount";
	
	public static void find(String username) throws ClassNotFoundException, SQLException{
		Init();
		String sql = "SELECT * FROM acount";
		Statement state = conn.createStatement();
		ResultSet res = state.executeQuery(sql);
	}
	
	

}
