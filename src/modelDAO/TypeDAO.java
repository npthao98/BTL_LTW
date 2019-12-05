package modelDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbconnect.DBConnect;
import model.Cake;
import model.Cake_Type;
import model.Type;

public class TypeDAO {
	private static final DBConnect DBConnector = null;
	public static Type getByID(int id) {
		Connection con=DBConnect.createConnection();
			
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
	public static List<Type> getListTypeByListCakeType(List<Cake_Type> listCakeType) {
		List<Type> listType = new ArrayList<Type>();
		for(int i=0; i<listCakeType.size(); i++) {
			Type t = TypeDAO.getByID(listCakeType.get(i).getTypeID());
			listType.add(t);
		}
		return listType;
		
	}
}
