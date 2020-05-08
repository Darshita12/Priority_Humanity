package com.User.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.User.bean.StateBean;
import com.User.bean.UserBean;
import com.User.util.DBConnection;

public class StateDao {
	
	Connection conn=null;
	PreparedStatement pstmt;
	ResultSet rs;
	public List<StateBean> selectState()
	{
		conn=DBConnection.getDBConnection();
		List<StateBean> listOfState=new ArrayList<StateBean>();
		
		if(conn!=null)
		{
			try {
				String selectSQL="select * from state";
				pstmt=conn.prepareStatement(selectSQL);
				rs=pstmt.executeQuery();
				while(rs.next())
				{
					StateBean stateBean=new StateBean();
					stateBean.setState_Id(rs.getInt("State_Id"));
					stateBean.setState_Name(rs.getString("State_Name"));
					listOfState.add(stateBean);
				}
			} catch (SQLException e) {
				// TODO: handle exception
			e.printStackTrace();
			}
		}
		return listOfState;
	}

}
