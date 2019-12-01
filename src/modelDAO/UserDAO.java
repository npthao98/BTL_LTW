package modelDAO;
import java.sql.*;

import dbconnect.DBConnect;

public class UserDAO {
public static ResultSet select(String sql) {
		
		Connection con = DBConnect.createConnection();
		try {
			Statement stm=con.createStatement();
			ResultSet rs=stm.executeQuery(sql);
			 return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	public static void insert(String hoten,String address,String sdt,String user,String pass) {
		Connection con=DBConnect.createConnection();
		try {
			PreparedStatement ps=con.prepareStatement("insert into users (username, password, name, address, phone_number) values(?,?,?,?,?)");
			ps.setString(1, user);
			ps.setString(2, pass);
			ps.setString(3, hoten);
			ps.setString(4, address);
			ps.setString(5, sdt);
			ps.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
