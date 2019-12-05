package modelDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbconnect.DBConnect;
import dbconnect.MyConnection;
import model.Cake;
import model.Cake_Type;
import model.ImageUrl;

public class CakeTypeDAO {
    private static final DBConnect DBConnector = null;
    
    public static List<Cake_Type> getByCakeID(int cakeID) {
        Connection con=DBConnect.createConnection();
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("select * from cake_type where CakeID=?");
            ps.setInt(1, cakeID);
            ResultSet rs=ps.executeQuery();
            List<Cake_Type> res = new ArrayList<Cake_Type>();
            while(rs.next()) {
                    int CakeID = rs.getInt(1);
                    int TypeID = rs.getInt(2);
                    Cake_Type cakeType = new Cake_Type(CakeID, TypeID);
                    res.add(cakeType);
            }
            return res;
        } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
        return null;
    }
    
    
    public static List<Cake_Type> getByCake(Cake cake) throws ClassNotFoundException, SQLException {
        Connection con = MyConnection.getConnection();
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("select * from cake_type where CakeID=?");
            ps.setInt(1, cake.getID());
            ResultSet rs=ps.executeQuery();
            List<Cake_Type> res = new ArrayList<Cake_Type>();
            while(rs.next()) {
                int CakeID = rs.getInt(1);
                int TypeID = rs.getInt(2);
                Cake_Type cakeType = new Cake_Type(CakeID, TypeID);
                res.add(cakeType);
            }
            return res;
        } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
        return null;
    }
    
}
