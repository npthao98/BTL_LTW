package modelDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dbconnect.DBConnect;
import model.Cake;
import model.Order;
import model.OrderDetail;
import model.OrderItem;
import model.Order_Client;

public class OrderDetailDAO {

	private static final DBConnect DBConnector = null;

	public static ArrayList<OrderDetail> getAllOrder() throws ClassNotFoundException, SQLException{
        ArrayList<OrderDetail> result = new ArrayList<OrderDetail>();
        
        Connection conn = DBConnect.createConnection();
        
        String sql = "SELECT id FROM `order`";
        Statement state = conn.createStatement();
        ResultSet res = state.executeQuery(sql);
        while(res.next()){
        	int id = res.getInt(1);
        	OrderDetail orderDetail = getByID(id);
        	result.add(orderDetail);
        }
        
        return result;
    }
	public static ArrayList<OrderDetail> getOrdersByClient(int clientID) throws ClassNotFoundException, SQLException{
		ArrayList<OrderDetail> result = new ArrayList<OrderDetail>();
		try {
			
	        ArrayList<Order_Client> orderClients = (ArrayList<Order_Client>)OrderClientDAO.getByClientID(clientID);
	        ArrayList<Order> orders = (ArrayList<Order>)OrderDAO.getOrdersByClient(orderClients);
	        
	        for(int i=0; i<orders.size(); i++) {
	        	int id = orders.get(i).getID();
	        	OrderDetail orderDetail = getByID(id);
	        	result.add(orderDetail);
	        }
	        
	        return result;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
		
        
    }
	public static OrderDetail getByID(int id) {
        Connection con = DBConnect.createConnection();

        PreparedStatement ps;
        try {
                ps = con.prepareStatement("SELECT order.ID,order.Address,Name,Quantity,Total,State FROM `cake`, `cake_order`, `order` "
                		+ "WHERE cake_order.OrderID = order.ID AND cake_order.CakeID = cake.ID AND order.ID = ?");
                ps.setInt(1, id);
                ResultSet rs=ps.executeQuery();
                List<OrderItem> orderItems = new ArrayList<OrderItem>();
                int ID=1;
                String address="";
                int total=1;
                int state=1;
                while(rs.next()) {
                	ID= rs.getInt(1);
                	address = rs.getString(2);
                	String name = rs.getString(3);
                	int quantity = rs.getInt(4);
                	total = rs.getInt(5);
                	state = rs.getInt(6);
            		OrderItem orderItem = new OrderItem(name, quantity);
            		orderItems.add(orderItem);
                }
                OrderDetail orderDetail= new OrderDetail(ID,address, total, state, orderItems);
                return orderDetail;
        } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }

        return null;

	
}
}
