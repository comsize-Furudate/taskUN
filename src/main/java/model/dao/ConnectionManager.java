package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	
	private final static String URL = "jdbc:mysql://localhost:3306/taskdb";
	private final static String USER = "root";
	private final static String PASSWORD = "mysql";
<<<<<<< HEAD
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(URL,USER,PASSWORD);
	}
=======
	
	public static Connection getConnection() throws SQLException,ClassNotFoundException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}

>>>>>>> d76b576c85ad9efd6f9b70c66d3feff91417e333
}
