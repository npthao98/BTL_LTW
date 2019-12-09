package modelDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbconnect.DBConnect;
import model.Cake_Type;
import model.Order_Client;
import model.User;

public class OrderClientDAO {
	private static final DBConnect DBConnector = null;
	public static List<Order_Client> getByClientID(int clientID) {
        Connection con=DBConnect.createConnection();
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("select * from order_client where ClientID=?");
            ps.setInt(1, clientID);
            ResultSet rs=ps.executeQuery();
            List<Order_Client> res = new ArrayList<Order_Client>();
            while(rs.next()) {
                int OrderID = rs.getInt(1);
                int ClientID = rs.getInt(2);
                Order_Client acc = new Order_Client(OrderID, ClientID);
                res.add(acc);
            }
            return res;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }
	public static Order_Client getByOrderID(int orderID) {
        Connection con=DBConnect.createConnection();
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("select * from order_client where OrderID=?");
            ps.setInt(1, orderID);
            ResultSet rs=ps.executeQuery();
            while(rs.next()) {
                int OrderID = rs.getInt(1);
                int ClientID = rs.getInt(2);
                Order_Client acc = new Order_Client(OrderID, ClientID);
                return acc;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }
	
	public static void insert(int order_id, int client_id) {
		Connection con=DBConnect.createConnection();
		try {
			PreparedStatement ps=con.prepareStatement("insert into order_client(OrderID, ClientID) value(?,?)");
			ps.setInt(1, order_id);
			ps.setInt(2, client_id);
			ps.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
