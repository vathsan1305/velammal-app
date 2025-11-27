package utils;
import java.sql.*;
import java.util.ResourceBundle;
public class MySqlSConnection {
	
	public static Connection getMySqlConnection() throws SQLException{

		 try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL JDBC Driver not found in WAR", e);
        }
		
		ResourceBundle bundle = ResourceBundle.getBundle("application");

        String url = bundle.getString("jdbc.url");
        String user = bundle.getString("jdbc.username");
        String pass = bundle.getString("jdbc.password");

        return DriverManager.getConnection(url, user, pass);
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


