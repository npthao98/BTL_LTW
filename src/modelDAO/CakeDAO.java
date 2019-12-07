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
import model.CakeInfor;
import model.Cake_Order;
import model.Cake_Type;
import model.Client;
import model.ImageUrl;
import model.Type;

public class CakeDAO {
//	private static final DBConnect DBConnector = null;
    public static Cake getByID(int id) throws SQLException {
        Connection con = DBConnect.createConnection();
        PreparedStatement ps = con.prepareStatement("select * from cake where ID=?");
        try {
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
        ps.close();
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
        conn.close();
        return result;
    }
        
    public static List<Cake> getCakesByOrderCakes(List<Cake_Order> CakeOrders) throws SQLException {
        List<Cake> listCakes = new ArrayList<Cake>();
        for(int i=0; i<CakeOrders.size(); i++) {
            Cake t = CakeDAO.getByID(CakeOrders.get(i).getCakeID());
            listCakes.add(t);
        }
        return listCakes;
    }
    
    public ArrayList<CakeInfor> getAllCakeInfor() throws SQLException{
        ArrayList<CakeInfor> result = new ArrayList<CakeInfor>();
        String sqlCake = "SELECT * FROM Cake",
            sqlType = "SELECT * FROM Type",
            sqlUrl = "SELECT * FROM ImageUrl";
        Connection conn = DBConnect.createConnection();
        Statement state = conn.createStatement();
        
        ResultSet cake = state.executeQuery(sqlCake),
                  type = state.executeQuery(sqlType),
                   url = state.executeQuery(sqlUrl);
        ArrayList<Cake> cakes = new ArrayList<Cake>();
        ArrayList<Type> types = new ArrayList<Type>();
        ArrayList<ImageUrl> urls = new ArrayList<ImageUrl>();
        
        while(cake.next()){
            cakes.add(new Cake(cake.getInt(1), cake.getString(2), cake.getInt(3), cake.getString(4)));
        }
        while(type.next()){
            types.add(new Type(type.getInt(1), type.getString(2)));
        }
        while(url.next()){
            urls.add(new ImageUrl(url.getInt(1), url.getInt(2), url.getString(3)));
        }
        
        for(int i = 0; i < cakes.size(); i++){
            
        }
        
        
        conn.close();
        
        return result;
    }
}
