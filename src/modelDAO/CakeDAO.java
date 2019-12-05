package modelDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbconnect.DBConnect;
import dbconnect.MyConnection;
import java.sql.Statement;
import java.util.ArrayList;
import model.Cake;
import model.Client;

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
            
            Connection conn = DBConnect.createConnection();
            
            String sql = "SELECT * FROM cake";
            Statement state = conn.createStatement();
            ResultSet res = state.executeQuery(sql);
            
            while(res.next()){
                result.add(new Cake(res.getInt(1), res.getString(2), res.getInt(3), res.getString(4)));
            }
            
            return result;
        }
}
