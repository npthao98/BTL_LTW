package modelDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbconnect.DBConnect;
import dbconnect.MyConnection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Cake;
import model.Cake_Order;
import model.Cake_Type;
import model.Client;
import model.Type;

public class CakeDAO {
	private static final DBConnect DBConnector = null;
        
	public static Cake getByID(int id) {
            Connection con = DBConnect.createConnection();

            PreparedStatement ps;
            try {
                    ps = con.prepareStatement("select * from cake where ID=?");
                    ps.setInt(1, id);
                    ResultSet rs=ps.executeQuery();
                    while(rs.next()) {
                            int ID = rs.getInt(1);
                            String name = rs.getString(2);
                            int price=rs.getInt(3);
                            String description=rs.getString(4);
                            Cake acc=new Cake(ID, name, price, description);
                            return acc;
                    }
            } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
            }

            return null;

		
	}
        
        public static ArrayList<Cake> getAllCake() throws ClassNotFoundException, SQLException{
            ArrayList<Cake> result = new ArrayList<Cake>();
            
            Connection conn = MyConnection.getConnection();
            
            String sql = "SELECT * FROM cake";
            Statement state = conn.createStatement();
            ResultSet res = state.executeQuery(sql);
            
            while(res.next()){
                result.add(new Cake(res.getInt(1), res.getString(2), res.getInt(3), res.getString(4)));
            }
            
            return result;
        }
        
        public static List<Cake> getCakesByOrderCakes(List<Cake_Order> CakeOrders) {
            List<Cake> listCakes = new ArrayList<Cake>();
            for(int i=0; i<CakeOrders.size(); i++) {
                Cake t = CakeDAO.getByID(CakeOrders.get(i).getCakeID());
                listCakes.add(t);
            }
            return listCakes;
        }
}
