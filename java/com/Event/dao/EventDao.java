package com.Event.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.Event.bean.EventBean;
import com.Event.util.DBConnection;

public class EventDao {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public boolean addEvent(EventBean eventBean) {
		boolean flag = false;

		conn = DBConnection.getDBConnetion();

		if (conn != null) {

			String insertSQL = "insert into Event(Eventname,Eventaddress,Date)values(?,?,?)";
			try {
				
				pstmt = conn.prepareStatement(insertSQL);
				pstmt.setString(1, eventBean.getEventname());
				pstmt.setString(2, eventBean.getEventaddress());
				pstmt.setString(3, eventBean.getEventDate());
				int res = pstmt.executeUpdate();

				if (res > 0) {
					flag = true;
				}

			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}

		} // end if

		return flag;
	}// end addAEvent

	public List<EventBean> eventlist() {

		conn = DBConnection.getDBConnetion();
		List<EventBean> listOfEvent = new ArrayList<EventBean>();

		if (conn != null) {
			String selectsql = "select * from Event";
			try {
				
				pstmt = conn.prepareStatement(selectsql);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					EventBean eventBean = new EventBean();
					eventBean.setEventid(rs.getInt("eventid"));
					eventBean.setEventname(rs.getString("eventname"));
					eventBean.setEventaddress(rs.getString("eventaddress"));
					eventBean.setEventDate(rs.getString("Date"));
					listOfEvent.add(eventBean);
				}

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

		}//end if

		return listOfEvent;
	}//end of list

	public boolean deleteEvent(int eid) {
		 boolean flag = false;
		 
		 conn = DBConnection.getDBConnetion();
		 if(conn != null) {
			 String deletesql = "delete from event where eventid = ?";
			 try {
				pstmt = conn.prepareStatement(deletesql);
				pstmt.setInt(1, eid);
				int res = pstmt.executeUpdate();
				if(res>0) {
					flag = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		 }//end if
		 
		 return flag;
	}//end delete
	
	public EventBean getData(int eid) {
		
		conn = DBConnection.getDBConnetion();
		EventBean eventBean = new EventBean();
		
		if(conn != null) {
			
			try {
				String selectsql = "select * from event where eventid = ?";
				pstmt = conn.prepareStatement(selectsql);
				pstmt.setInt(1, eid);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					eventBean.setEventid(rs.getInt("eventid"));
					eventBean.setEventname(rs.getString("eventname"));
					eventBean.setEventaddress(rs.getString("eventaddress"));
					eventBean.setEventDate(rs.getString("eventDate"));
				}
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			
		}//end if
		
		
		return eventBean;
				
	}
	
	public boolean UpdateEvent(EventBean eventBean) {
	boolean flag = false;
	
	conn = DBConnection.getDBConnetion();
	
	if(conn != null) {
		try {
			String updatesql = "update event set eventname=?,eventaddress=?,date = ? where eventid=?";
			pstmt = conn.prepareStatement(updatesql);
			pstmt.setString(1, eventBean.getEventname());
			pstmt.setString(2, eventBean.getEventaddress());
			pstmt.setString(3, eventBean.getEventDate());
			pstmt.setInt(4, eventBean.getEventid());
			int res = pstmt.executeUpdate();
		
			if(res>0) {
				flag = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	
	
	return flag;
	}//end update
}

