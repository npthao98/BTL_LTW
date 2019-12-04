package modelDAO;
import java.sql.*;

import dbconnect.DBConnect;
import model.Client;
import model.User;

public class ClientDAO {
	public static Client getByID(int id) {
		Connection con=DBConnect.createConnection();
			
			PreparedStatement ps;
			try {
				ps = con.prepareStatement("select * from client where ID=?");
				ps.setInt(1, id);
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					int ID = rs.getInt(1);
					String name = rs.getString(2);
					String address=rs.getString(3);
				
					String phone=rs.getString(4);
					String email=rs.getString(5);
					Client acc=new Client(ID, name, address, phone, email);
					return acc;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return null;
			
		
	}

}
