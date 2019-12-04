package modelDAO;
import java.sql.*;

import dbconnect.DBConnect;
import model.User;

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
	public static User getByUser(String user,String pass) {
		Connection con=DBConnect.createConnection();
			
			PreparedStatement ps;
			try {
				ps = con.prepareStatement("select * from user where username=? and password=?");
				ps.setString(1, user);
				ps.setString(2, pass);
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					int ID = rs.getInt(1);
					int ClientID = rs.getInt(2);
					String UserName=rs.getString(3);
				
					String Password=rs.getString(4);
					int Role= rs.getInt(5);
					User acc=new User(ID, ClientID, UserName, Password, Role);
					return acc;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return null;
			
		
	}
	public static User getByID(int id) {
		Connection con=DBConnect.createConnection();
			
			PreparedStatement ps;
			try {
				ps = con.prepareStatement("select * from user where ID=?");
				ps.setInt(1, id);
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					int ID = rs.getInt(1);
					int ClientID = rs.getInt(2);
					String UserName=rs.getString(3);
				
					String Password=rs.getString(4);
					int Role= rs.getInt(5);
					User acc=new User(ID, ClientID, UserName, Password, Role);
					return acc;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return null;
			
		
	}
	public static User getByClientID(int clientID) {
		Connection con=DBConnect.createConnection();
			
			PreparedStatement ps;
			try {
				ps = con.prepareStatement("select * from user where ClientID=?");
				ps.setInt(1, clientID);
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					int ID = rs.getInt(1);
					int ClientID = rs.getInt(2);
					String UserName=rs.getString(3);
				
					String Password=rs.getString(4);
					int Role= rs.getInt(5);
					User acc=new User(ID, ClientID, UserName, Password, Role);
					return acc;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return null;
			
		
	}

}
