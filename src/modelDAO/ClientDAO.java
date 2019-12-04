/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelDAO;

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
