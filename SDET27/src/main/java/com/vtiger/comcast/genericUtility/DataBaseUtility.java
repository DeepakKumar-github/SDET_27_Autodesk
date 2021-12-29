package com.vtiger.comcast.genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

/**
 * 
 * @author Dk
 *
 */

public class DataBaseUtility {
	/**
	 * 
	 * @throws SQLException
	 */
public void CreateJdbcConnection() throws SQLException {
	Driver driver=new Driver();
	
	//register the Database
	DriverManager.registerDriver(driver);
	
	//get the connection
	Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
	
	
}
public void closeJdbcConnection(Connection connection) throws SQLException {
	connection.close();
	System.out.println("Database connection is closed");
}
}

