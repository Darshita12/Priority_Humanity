package com.User.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.User.bean.UserBean;
import com.User.util.DBConnection;

public class UserDao {

	Connection conn=null;
	PreparedStatement pstmt;
	ResultSet rs;
	public void addUser(UserBean userBean)
	{
		conn=DBConnection.getDBConnection();
		if(conn!=null)
		{
			try {
				String insertSQL="insert into project_user(User_Firstname,User_Lastname,User_Email,User_Password,User_Contact,state,city,gender)values(?,?,?,?,?,?,?,?)";
				pstmt=conn.prepareStatement(insertSQL);
				pstmt.setString(1, userBean.getFirstName());
				pstmt.setString(2, userBean.getLastName());
				pstmt.setString(3, userBean.getEmail());
				pstmt.setString(4, userBean.getPassword());
				pstmt.setString(5, userBean.getContact());
				pstmt.setString(6, userBean.getState());
				pstmt.setString(7, userBean.getCity());
				pstmt.setString(8, userBean.getGender());
				int res=pstmt.executeUpdate();
				if(res>0)
				{
					System.out.println("data inserted");
				}
				else
				{
					System.out.println("data is not inserted");
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	public List<UserBean> listOfUser()
	{
		conn=DBConnection.getDBConnection();
		List<UserBean> listOfUser=new ArrayList<UserBean>();
		
		if(conn!=null)
		{
			try {
				String selectSQL="select * from project_user";
				pstmt=conn.prepareStatement(selectSQL);
				rs=pstmt.executeQuery();
				while(rs.next())
				{
					UserBean userBean=new UserBean();
					userBean.setUserId(rs.getInt("User_Id"));
					userBean.setFirstName(rs.getString("User_Firstname"));
					userBean.setLastName(rs.getString("User_Lastname"));
					userBean.setEmail(rs.getString("User_Email"));
					userBean.setPassword(rs.getString("User_Password"));
					userBean.setContact(rs.getString("User_Contact"));
					
					userBean.setCity(rs.getString("state"));
					userBean.setState(rs.getString("city"));
					listOfUser.add(userBean);
				}
			} catch (SQLException e) {
				// TODO: handle exception
			e.printStackTrace();
			}
		}
		return listOfUser;
	}
	public UserBean listOfUser1()
	{
		conn=DBConnection.getDBConnection();
		List<UserBean> listOfUser=new ArrayList<UserBean>();
		UserBean userBean=new UserBean();
		if(conn!=null)
		{
			try {
				String selectSQL="select * from project_user";
				pstmt=conn.prepareStatement(selectSQL);
				rs=pstmt.executeQuery();
				while(rs.next())
				{
					
					userBean.setUserId(rs.getInt("User_Id"));
					userBean.setFirstName(rs.getString("User_Firstname"));
					userBean.setLastName(rs.getString("User_Lastname"));
					userBean.setEmail(rs.getString("User_Email"));
					userBean.setPassword(rs.getString("User_Password"));
					userBean.setContact(rs.getString("User_Contact"));
					
					userBean.setCity(rs.getString("state"));
					userBean.setState(rs.getString("city"));
					/* listOfUser.add(userBean); */
				}
			} catch (SQLException e) {
				// TODO: handle exception
			e.printStackTrace();
			}
		}
		return userBean;
	}
	public void deleteUser(int UserId)
	{
		conn=DBConnection.getDBConnection();
		if(conn!=null)
		{
			try {
				String deleteSQL="delete from project_user where User_Id=?";
				pstmt=conn.prepareStatement(deleteSQL);
				pstmt.setInt(1, UserId);
				int res=pstmt.executeUpdate();
				if(res>0)
				{
					System.out.println("data deleted");
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}
	}
	public UserBean editUser(int UserId)
	{
		conn=DBConnection.getDBConnection();
		UserBean userBean=null;
		if(conn!=null)
		{
			try {
				String selectSQL="select * from project_user where User_Id=?";
				pstmt=conn.prepareStatement(selectSQL);
				pstmt.setInt(1, UserId);
				rs=pstmt.executeQuery();
				while(rs.next())
				{
					userBean=new UserBean();
					userBean.setFirstName(rs.getString("User_Firstname"));
					userBean.setLastName(rs.getString("User_Lastname"));
					userBean.setEmail(rs.getString("user_email"));
					userBean.setPassword(rs.getString("user_password"));
					userBean.setContact(rs.getString("user_contact"));
					userBean.setUserId(rs.getInt("user_id"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}
		return userBean;
	}
	public boolean updateUser(UserBean userBean)
	{
		boolean flag=false;
		conn=DBConnection.getDBConnection();
		if(conn!=null)
		{
			try {
				String updateSQL="update project_user set User_Firstname=?,User_Lastname=?,User_Email=?,User_Password=?,User_Contact=? where User_Id=?";
				pstmt=conn.prepareStatement(updateSQL);
				System.out.println("--user id "+userBean.getUserId());
				pstmt.setString(1, userBean.getFirstName());
				pstmt.setString(2, userBean.getLastName());
				pstmt.setString(3, userBean.getEmail());
				pstmt.setString(4, userBean.getPassword());
				pstmt.setString(5, userBean.getContact());
				pstmt.setInt(6, userBean.getUserId());
				int res=pstmt.executeUpdate();
				if(res>0)
				{

					System.out.println("y=updated...");
					flag=true;
				}
			} catch (SQLException e) {
				// TODO: handle exception
			e.printStackTrace();
			}
		}
		return flag;
	}
	
	public UserBean login(String email,String password)
	{
		conn=DBConnection.getDBConnection();
		UserBean userBean=null;
		if(conn!=null)
		{
			String selectSQL="select * from project_user where User_email=? and user_password=?";
			try {
				pstmt=conn.prepareStatement(selectSQL);
				pstmt.setString(1, email);
				pstmt.setString(2, password);
				rs=pstmt.executeQuery();
				while(rs.next())
				{
					userBean=new UserBean();
					userBean.setUserId(rs.getInt("User_Id"));
					userBean.setFirstName(rs.getString("User_Firstname"));
					userBean.setLastName(rs.getString("User_Lastname"));
					userBean.setEmail(rs.getString("User_Email"));
					userBean.setPassword(rs.getString("User_Password"));
					userBean.setContact(rs.getString("User_Contact"));
					userBean.setGender(rs.getNString("gender"));
					userBean.setCity(rs.getString("state"));
					userBean.setState(rs.getString("city"));
				}
			} catch (SQLException e) {
				// TODO: handle exception
			e.printStackTrace();
			}
		}
		return userBean;
	}
	public UserBean forgetPwd(UserBean userBean)
	{
		conn=DBConnection.getDBConnection();
		if(conn!=null)
		{
			String selectSQL="select User_Id from project_user where User_email=?";
			try
			{
				pstmt=conn.prepareStatement(selectSQL);
				pstmt.setString(1, userBean.getEmail());
				rs=pstmt.executeQuery();
				while(rs.next())
				{
					
					userBean.setUserId(rs.getInt("User_Id"));
					userBean.setEmail(rs.getString("User_Email"));
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return userBean;
	}
	public boolean setNewPassword(UserBean userBean)
	{
		boolean flag=false;
		conn=DBConnection.getDBConnection();
		if(conn!=null)
		{
			String updateSQL="update project_user set user_password=? where User_Id=?";
			try
			{
				pstmt=conn.prepareStatement(updateSQL);
				pstmt.setString(1, userBean.getPassword());
				pstmt.setInt(2, userBean.getUserId());
				int res=pstmt.executeUpdate();
				if(res>0)
				{
					flag=true;
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		return flag;
	}
	
}
