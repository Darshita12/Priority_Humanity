package com.NGO.util;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {

	private static String userName = "root";
	private static String password = "1234";
	private static String connectionURL ="jdbc:mysql://localhost:3306/darshita";
	private static String driverClass ="com.mysql.cj.jdbc.Driver";
	
public static Connection getDBConnetion()
{
	Connection conn = null;
	try {
		Class.forName(driverClass);
		conn = 	DriverManager.getConnection(connectionURL , userName , password);
		if (conn!= null) {
			System.out.println("Connectedddd");
		}
		else
		{
			System.out.println("not Conecteddd");
		}
		}
	
	catch (SQLException e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	catch(ClassNotFoundException e)
	 {
		e.printStackTrace();
	 }
	return conn;

}
	
	public static void main(String[] args) {
		
		getDBConnetion();
	}

}
