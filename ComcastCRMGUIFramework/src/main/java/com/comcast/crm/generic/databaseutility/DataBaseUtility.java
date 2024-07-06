package com.comcast.crm.generic.databaseutility;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;
public class DataBaseUtility {
	Connection conn;
	public void getConnection(String url,String username,String password) throws SQLException {
		try {
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		conn=DriverManager.getConnection(url, username, password);
		}
		catch (Exception e) {	
		}
	}
public void getConnection() throws SQLException {	
		try {
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		conn=DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/projects","root@%","root");
		}
		catch (Exception e) {		
		}
	}
	public void closeDbconnection() throws SQLException {
		try {
		conn.close();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	} 
	public ResultSet executeSelectQuery(String query) throws SQLException {
		ResultSet set=null;
		try {
		Statement stat=conn.createStatement();
		 set=stat.executeQuery(query);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return set;
	}
	
	public int executeNonSelectQuery(String query) {
		
		int result=0;
		try {
			Statement stat=conn.createStatement();
			result= stat.executeUpdate(query);
			}
			catch (Exception e) {
				// TODO: handle exception
			}
		return result;
		
			
	}

}
