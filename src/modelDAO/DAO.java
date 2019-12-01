package modelDAO;

import java.sql.Connection;
import java.sql.SQLException;

import dbconnect.MySQLConn;

public abstract class DAO {
	
	public static Connection conn;
	
	public static void Init() throws ClassNotFoundException, SQLException {
		conn = MySQLConn.getMySQLConnection();
	}
	
}
