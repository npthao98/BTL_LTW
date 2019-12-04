package modelDAO;
import java.sql.*;

import dbconnect.DBConnect;
import dbconnect.MyConnection;
import model.Account;
import model.Client;
import model.User;

public class UserDAO {
    public static String table = "client";
    
    
    public static ResultSet select(String sql) {
        Connection con = DBConnect.createConnection();
        try {
                Statement stm=con.createStatement();
                ResultSet rs=stm.executeQuery(sql);
                 return rs;
        } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
        return null;

    }
    
    public static void insert(String hoten,String address,String sdt,String user,String pass) {
        Connection con=DBConnect.createConnection();
        try {
                PreparedStatement ps=con.prepareStatement("insert into users (username, password, name, address, phone_number) values(?,?,?,?,?)");
                ps.setString(1, user);
                ps.setString(2, pass);
                ps.setString(3, hoten);
                ps.setString(4, address);
                ps.setString(5, sdt);
                ps.execute();

        } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
    }

    public static User getUserByAccount(Account acc) throws ClassNotFoundException, SQLException{
        Connection conn = MyConnection.getConnection();
        String sql = "SELECT * FROM user";
        Statement state = conn.createStatement();
        ResultSet res = state.executeQuery(sql);
        while(res.next()){
            if(res.getString(3).compareTo(acc.getName()) == 0 &&
                    res.getString(4).compareTo(acc.getPass()) == 0){
                User t = new User(res.getInt(1), res.getInt(2), res.getString(3),
                            res.getString(4), res.getInt(5));
                return t;
            }
        }
        return null;
    }
    
    public static boolean checkAccountExid(Account acc) throws ClassNotFoundException, SQLException{
        Connection conn = MyConnection.getConnection();
        String sql = "SELECT UseName FROM user";
        Statement state = conn.createStatement();
        ResultSet res = state.executeQuery(sql);
        while(res.next()){
            if(res.getString(1).compareTo(acc.getName()) == 0){
                return true;
            }
        }
        return false;
    }
   
    public static boolean saveNewUser(User user) throws ClassNotFoundException, SQLException{
        Connection conn = MyConnection.getConnection();
        String sql = "INSERT INTO user(ClientID, UseName, Password, Role) "
              + " values (?, ?, ?, ?) ";
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setInt(1, user.getClientID());
        pstm.setString(2, user.getUserName());
        pstm.setString(3, user.getPassword());
        pstm.setInt(4, user.getRole());
        
        int affectedRows = pstm.executeUpdate();
        
        if (affectedRows == 0) {
            return false;
        }
 
        return true;
    }
}
