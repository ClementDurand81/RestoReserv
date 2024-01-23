package DAO;

import java.sql.*;

public class ConnexionBDD {

	 @SuppressWarnings("unused")
	private Connection connection;
	 
	public static Connection getConnection() throws ClassNotFoundException {
		
		//Connexion à la base de données
		
		try {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://127.0.0.1:3306/restoreserv";
			String username = "root";
			String password = "";
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url,username,password);
			return conn;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
