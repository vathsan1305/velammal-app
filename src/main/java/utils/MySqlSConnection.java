package utils;
import java.sql.*;
import java.util.ResourceBundle;
public class MySqlSConnection {
	
	public static Connection getMySqlConnection() throws SQLException{
		
		ResourceBundle bundle = ResourceBundle.getBundle("application"); //bundling up the properties
		
		return DriverManager.getConnection(bundle.getString("jdbc.url"),bundle.getString("jdbc.username"),bundle.getString("jdbc.password")); //connecting to dbms
	}


	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			System.out.println(getMySqlConnection());
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}*/

}


