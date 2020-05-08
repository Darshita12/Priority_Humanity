package com.Admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Admin.bean.AdminBean;
import com.User.bean.UserBean;
import com.User.util.DBConnection;

public class AdminDao {
	Connection conn=null;
	PreparedStatement pstmt;
	ResultSet rs;
	public AdminBean login(String email,String password)
	{
		conn=DBConnection.getDBConnection();
		AdminBean adminBean=null;
		if(conn!=null)
		{
			String selectSQL="select * from admin where email=? and password=?";
			try {
				pstmt=conn.prepareStatement(selectSQL);
				pstmt.setString(1, email);
				pstmt.setString(2, password);
				rs=pstmt.executeQuery();
				while(rs.next())
				{
					adminBean=new AdminBean();
					adminBean.setId(rs.getInt("Id"));
					
				}
			} catch (SQLException e) {
				// TODO: handle exception
			e.printStackTrace();
			}
		}
		return adminBean;
	}
	
}
