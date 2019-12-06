package modelDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import dbconnect.DBConnect;
import dbconnect.MyConnection;
import model.Cake;
import model.ImageUrl;

public class ImageurlDAO {
//    private static final DBConnect DBConnector = null;

    public static List<ImageUrl> getByCakeID(int cakeID) {
        Connection con=DBConnect.createConnection();
        PreparedStatement ps;
        try {
                ps = con.prepareStatement("select * from imageurl where CakeID=?");
                ps.setInt(1, cakeID);
                ResultSet rs=ps.executeQuery();
                List<ImageUrl> res = new ArrayList<ImageUrl>();
                while(rs.next()) {
                        int ID = rs.getInt(1);
                        int CakeID = rs.getInt(2);
                        String Url=rs.getString(3);
                        ImageUrl imageurl = new ImageUrl(ID, CakeID, Url);
                        res.add(imageurl);
                }
                return res;
        } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }

        return null;
    }

    public static ArrayList<ImageUrl> getByCake(Cake cake) throws ClassNotFoundException, SQLException {
        Connection con = DBConnect.createConnection();
        PreparedStatement ps = con.prepareStatement("select * from imageurl where CakeID=?");
        try {
            ps.setInt(1, cake.getID());
            ResultSet rs = ps.executeQuery();
            ArrayList<ImageUrl> res = new ArrayList<ImageUrl>();
            while(rs.next()) {
                    int ID = rs.getInt(1);
                    int CakeID = rs.getInt(2);
                    String Url = rs.getString(3);
                    ImageUrl imageurl = new ImageUrl(ID, CakeID, Url);
                    res.add(imageurl);
            }
            return res;
        } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }

        return null;
    }
}
