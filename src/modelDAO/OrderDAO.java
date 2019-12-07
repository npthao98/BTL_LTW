package modelDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbconnect.DBConnect;
import model.Cake;
import model.Cake_Type;
import model.Order;
import model.Order_Client;
import model.Type;

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
//					String time = "2019/11/11";
					int total=rs.getInt(3);
					String address = rs.getString(4);
					int state=rs.getInt(5);
					Order acc = new Order(iD, time, total, address, state);
					System.out.println(acc.toString());
					return acc;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return null;
	}
	public static List<Order> getOrdersByClient(List<Order_Client> orderClients) {
        List<Order> orders = new ArrayList<Order>();
        for(int i=0; i<orderClients.size(); i++) {
            Order t = OrderDAO.getByID(orderClients.get(i).getOrderID());
            orders.add(t);
        }
        return orders;
    }
	public static void cancelOrder(int id) {
		Connection con=DBConnect.createConnection();
		try {
			PreparedStatement ps=con.prepareStatement("update bakery.order set State=4 where ID=? ");
			ps.setInt(1, id);
			ps.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void updateStateOrder(int id, int state) {
		Connection con=DBConnect.createConnection();
		try {
			PreparedStatement ps=con.prepareStatement("update bakery.order set State=? where ID=? ");
			ps.setInt(1, state);
			ps.setInt(2, id);
			ps.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
