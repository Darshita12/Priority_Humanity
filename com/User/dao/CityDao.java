package com.User.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.User.bean.CityBean;
import com.User.util.DBConnection;

public class CityDao {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public List<CityBean> selectcity(){
		
		
		conn = DBConnection.getDBConnection();
		List<CityBean> listOfCity = new ArrayList<CityBean>();
		if(conn!=null) {
			
			
			try {
				String select = "select * from city ";
				pstmt = conn.prepareStatement(select);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					
					CityBean cityBean = new CityBean();
					cityBean.setCityId(rs.getInt("cityid"));
					cityBean.setCityName(rs.getString("cityname"));
					cityBean.setState_Id(rs.getInt("State_Id"));
					listOfCity.add(cityBean);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		return listOfCity;
	}

	public List<CityBean> listofCity(int State_Id)
	{
		conn=DBConnection.getDBConnection();
		List<CityBean> listofCity=new ArrayList<CityBean>();
		if(conn!=null)
		{
			String selectSQL="select city.state_Id,city.CityId,city.CityName from city inner join state on state.State_Id=city.State_Id where state.State_Id=?";
			try {
				pstmt=conn.prepareStatement(selectSQL);
				pstmt.setInt(1, State_Id);
				rs=pstmt.executeQuery();
				while(rs.next())
				{
					CityBean cityBean=new CityBean();
					cityBean.setCityId(rs.getInt("CityId"));
					cityBean.setCityName(rs.getString("CityName"));
					cityBean.setState_Id(rs.getInt("State_Id"));
					listofCity.add(cityBean);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}
		return listofCity;
	}
}
