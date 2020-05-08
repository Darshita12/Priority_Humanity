package com.User.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	
	public static String Username="root";
	public static String password="1234";
	public static String urlConnection="jdbc:mysql://localhost:3306/darshita";
	public static String driverClass="com.mysql.cj.jdbc.Driver";
	
	 Connection conn=null;
	public static Connection getDBConnection() 
	{
		 Connection conn=null;
		 try {
			 Class.forName(driverClass);
				conn=DriverManager.getConnection(urlConnection, Username, password);
				if(conn!=null)
				{
					System.out.println("connected");
				}
				else
				{
					System.out.println("not connected");
				}
		} catch (SQLException e) {
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
		
		DBConnection.getDBConnection();
	}
}