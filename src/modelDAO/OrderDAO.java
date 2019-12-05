package modelDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbconnect.DBConnect;
import model.Cake;
import model.Order;

public class OrderDAO {
	private static final DBConnect DBConnector = null;
	public static Order getByID(int id) {
		Connection con=DBConnect.createConnection();
			
			PreparedStatement ps;
			try {
				ps = con.prepareStatement("select * from bakery.order where ID=?");
				ps.setInt(1, id);
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					int iD = rs.getInt(1);
//					String time = rs.getString(2);
					String time = rs.getDate(2).toString();
					int total=rs.getInt(3);
					int state=rs.getInt(4);
					Order acc = new Order(iD, time, total, state);
					System.out.println(acc.toString());
					return acc;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return null;
			
		
	}
}
