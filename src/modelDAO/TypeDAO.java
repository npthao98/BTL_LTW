package modelDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbconnect.DBConnect;
import dbconnect.MyConnection;
import java.sql.Statement;
import model.Cake;
import model.Cake_Type;
import model.Type;

public class TypeDAO {
//    private static final DBConnect DBConnector = null;
    
    private static ArrayList<Type> types;
    
    public static Type getByID(int id){
        Connection con = DBConnect.createConnection();
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("select * from type where ID=?");
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            while(rs.next()) {
                    int ID = rs.getInt(1);
                    String name = rs.getString(2);
                    Type acc=new Type(ID, name);
                    return acc;
            }
        } catch (SQLException e) {
                // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    
    public static ArrayList<Type> getAllType() throws ClassNotFoundException, SQLException{
        Connection con = DBConnect.createConnection();
        Statement state = con.createStatement();
        
        ArrayList<Type> result = new ArrayList<Type>();
        
        ResultSet res = state.executeQuery("select * from type");
        while(res.next()){
            result.add(new Type(res.getInt(1), res.getString(2)));
        }
        con.close();
        return result;
    }
    
    public static ArrayList<Type> getByCake(Cake cake) throws ClassNotFoundException, SQLException {
        Connection con = DBConnect.createConnection();
        ArrayList<Type> result = new ArrayList<Type>();
        String sql = "SELECT type.ID, type.Name FROM type, cake_type WHERE cake_type.CakeID=? AND cake_type.TypeID = type.ID";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, cake.getID());
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            result.add(new Type(rs.getInt(1), rs.getString(2)));
        }
        con.close();
        return result;
    }

    public static List<Type> getListTypeByListCakeType(List<Cake_Type> listCakeType) {
        List<Type> listType = new ArrayList<Type>();
        for(int i=0; i<listCakeType.size(); i++) {
            Type t = TypeDAO.getByID(listCakeType.get(i).getTypeID());
            listType.add(t);
        }
        return listType;
    }
    
}
