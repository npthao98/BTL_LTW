/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelDAO;

import dbconnect.DBConnect;
import dbconnect.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Account;
import model.Client;
import model.User;

/**
 *
 * @author Duck
 */
public class ClientDAO {
    private static final DBConnect DBConnector = null;
    
    public static Client getByID(int id) throws SQLException {
        Connection con = DBConnect.createConnection();
        PreparedStatement ps = con.prepareStatement("select * from client where ID=?");
        try {
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            while(rs.next()) {
                int ID = rs.getInt(1);
                String name = rs.getString(2);
                String address=rs.getString(3);
                String phone=rs.getString(4);
                String email=rs.getString(5);
                Client acc=new Client(ID, name, address, phone, email);
                return acc;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ps.close();
        return null;
    }
    
    public static void update(int id, String name, String address) {
        Connection con=DBConnect.createConnection();
        try {
            PreparedStatement ps=con.prepareStatement("update client set Name=?, Address=? where ID=?");
            ps.setString(1, name);
            ps.setString(2, address);
            ps.setInt(3, id);
            ps.execute();
            ps.close();
        } catch (SQLException e) {
                // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static Client checkAccountExid(User user) throws ClassNotFoundException, SQLException{
        Connection conn = MyConnection.getConnection();
        String sql = "SELECT * FROM client";

        Statement state = conn.createStatement();
        ResultSet res = state.executeQuery(sql);
        
        while(res.next()){
            if(res.getInt(1) == user.getClientID()){
                Client t = new Client(res.getInt(1), res.getString(2), res.getString(3),
                    res.getString(4), res.getString(5));
                return t;
            }
           
        }
        
        return null;
    }
    
    public static boolean registClient(Client client) throws ClassNotFoundException, SQLException{
        Connection conn = MyConnection.getConnection();
        String sql = "INSERT INTO client(Name, Address, Phone, Email)"
              + " values (?, ?, ?, ?) ";
        PreparedStatement pstm = conn.prepareStatement(sql,
            Statement.RETURN_GENERATED_KEYS);
 
        pstm.setString(1, client.getName());
        pstm.setString(2, client.getAddress());
        pstm.setString(3, client.getPhone());
        pstm.setString(4, client.getEmail());
        
        int affectedRows = pstm.executeUpdate();
        
        if (affectedRows == 0) {
            return false;
        }

        ResultSet generatedKeys = pstm.getGeneratedKeys();
        
        if (generatedKeys.next()) {
            client.setID(generatedKeys.getInt(1));
        }
 
        return true;
    }

}