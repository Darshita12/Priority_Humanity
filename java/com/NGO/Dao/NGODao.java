package com.NGO.Dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.NGO.Bean.NGOBean;
import com.NGO.Bean.NGOTypeBean;
import com.NGO.util.DBConnection;

public class NGODao {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public boolean addNGO(NGOBean ngoBean) {
		boolean flag = false;

		conn = DBConnection.getDBConnetion();

		if (conn != null) {

			System.out.println(ngoBean.getCategory());
			String insertSQL = "insert into NgoReg(Name,EmailId,Password,Director,Address,Authorized_EmailId,Contact_no,Mobile_no,URL,State,City,file,Category)values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			int res;
			try {

				pstmt = conn.prepareStatement(insertSQL);
				pstmt.setString(1, ngoBean.getName());
				pstmt.setString(2, ngoBean.getEmailId());
				pstmt.setString(3, ngoBean.getPassword());
				pstmt.setString(4, ngoBean.getDirector());
				pstmt.setString(5, ngoBean.getAddress());
				pstmt.setString(6, ngoBean.getAuthorized_EmailID());
				pstmt.setString(7, ngoBean.getContactno());
				pstmt.setString(8, ngoBean.getMobileno());
				pstmt.setString(9, ngoBean.getURL());
				pstmt.setString(10, ngoBean.getState());
				pstmt.setString(11, ngoBean.getCity());
				pstmt.setString(12, ngoBean.getFile());
				pstmt.setInt(13, ngoBean.getCategory());
				res = pstmt.executeUpdate();

				if (res > 0) {
					flag = true;
				}

			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}

		} // end if

		return flag;
	}// end add NGO

	public List<NGOBean> NGOlist() {

		conn = DBConnection.getDBConnetion();
		List<NGOBean> listOfNGO = new ArrayList<NGOBean>();

		if (conn != null) {
			String selectsql = "select * from NGOReg";
			try {

				pstmt = conn.prepareStatement(selectsql);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					NGOBean ngoBean = new NGOBean();
					ngoBean.setId(rs.getInt("Id"));
					ngoBean.setName(rs.getString("Name"));
					ngoBean.setCategory(rs.getInt("Category"));
					ngoBean.setEmailId(rs.getString("EmailId"));
					ngoBean.setPassword(rs.getString("Password"));
					ngoBean.setDirector(rs.getString("Director"));
					ngoBean.setAddress(rs.getString("Address"));
					ngoBean.setAuthorized_EmailID(rs.getString("Authorized_EmailID"));
					ngoBean.setContactno(rs.getString("Contact_no"));
					ngoBean.setMobileno(rs.getString("Mobile_no"));
					ngoBean.setURL(rs.getString("URL"));
					ngoBean.setState(rs.getString("State"));
					ngoBean.setCity(rs.getString("City"));
					listOfNGO.add(ngoBean);

				}

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

		} // end if

		return listOfNGO;
	}// end of list

	public void deleteNGO(int NGOId) {
		conn = DBConnection.getDBConnetion();
		if (conn != null) {
			try {
				String deleteSQL = "delete from NgoReg where Id=?";
				pstmt = conn.prepareStatement(deleteSQL);
				pstmt.setInt(1, NGOId);
				int res = pstmt.executeUpdate();
				if (res > 0) {
					System.out.println("data deleted");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public NGOBean editNGO(int Id) {
		conn = DBConnection.getDBConnetion();
		NGOBean ngoBean = null;
		if (conn != null) {
			try {
				String selectSQL = "select * from NgoReg where Id=?";
				pstmt = conn.prepareStatement(selectSQL);
				pstmt.setInt(1, Id);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					ngoBean = new NGOBean();
					ngoBean.setId(rs.getInt("Id"));
					ngoBean.setName(rs.getString("Name"));
					ngoBean.setCategory(rs.getInt("Category"));
					ngoBean.setEmailId(rs.getString("EmailId"));
					ngoBean.setPassword(rs.getString("Password"));
					ngoBean.setDirector(rs.getString("Director"));
					ngoBean.setAddress(rs.getString("Address"));
					ngoBean.setAuthorized_EmailID(rs.getString("Authorized_EmailID"));
					ngoBean.setContactno(rs.getString("Contact_no"));
					ngoBean.setMobileno(rs.getString("Mobile_no"));
					ngoBean.setURL(rs.getString("URL"));
					ngoBean.setState(rs.getString("State"));
					ngoBean.setCity("City");

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ngoBean;
	}

	public boolean updateNGO(NGOBean ngoBean) {
		boolean flag = false;
		conn = DBConnection.getDBConnetion();
		if (conn != null) {
			try {
				String updateSQL = "update NgoReg set Name=?,Category=?,EmailId=?,Password=?,Director=?,Address=?,Authorized_EmailID=?,Contact_no=?,Mobile_no=?,URL=?,State=?,City=? where Id=?";
				pstmt = conn.prepareStatement(updateSQL);
				pstmt.setString(1, ngoBean.getName());
				pstmt.setInt(2, ngoBean.getCategory());
				pstmt.setString(3, ngoBean.getEmailId());
				pstmt.setString(4, ngoBean.getPassword());
				pstmt.setString(5, ngoBean.getDirector());
				pstmt.setString(6, ngoBean.getAddress());
				pstmt.setString(7, ngoBean.getAuthorized_EmailID());
				pstmt.setString(8, ngoBean.getContactno());
				pstmt.setString(9, ngoBean.getMobileno());
				pstmt.setString(10, ngoBean.getURL());
				pstmt.setString(11, ngoBean.getState());
				pstmt.setString(12, ngoBean.getCity());
				pstmt.setInt(13, ngoBean.getId());
				int res=pstmt.executeUpdate();
				if(res>0)
				{

					System.out.println("y=updated...");
					flag=true;
				}
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}

		}
		return flag;
	}
	
	public NGOBean login(String email,String password)
	{
		conn=DBConnection.getDBConnetion();
		NGOBean ngoBean=null;
		if(conn!=null)
		{
			String selectSQL="select * from NgoReg where EmailId=? and Password=?";
			try
			{
				pstmt=conn.prepareStatement(selectSQL);
				pstmt.setString(1, email);
				pstmt.setString(2, password);
				rs=pstmt.executeQuery();
				while(rs.next())
				{
					ngoBean=new NGOBean();
					ngoBean.setId(rs.getInt("Id"));
					ngoBean.setName(rs.getString("Name"));
					ngoBean.setCategory(rs.getInt("Category"));
					ngoBean.setEmailId(rs.getString("EmailId"));
					ngoBean.setPassword(rs.getString("Password"));
					ngoBean.setDirector(rs.getString("Director"));
					ngoBean.setAddress(rs.getString("Address"));
					ngoBean.setAuthorized_EmailID(rs.getString("Authorized_EmailID"));
					ngoBean.setContactno(rs.getString("Contact_no"));
					ngoBean.setMobileno(rs.getString("Mobile_no"));
					ngoBean.setURL(rs.getString("URL"));
					ngoBean.setState(rs.getString("State"));
					ngoBean.setCity("City");

				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return ngoBean;
	}
	public List<NGOTypeBean> NGOtypelist() {

		conn = DBConnection.getDBConnetion();
		List<NGOTypeBean> listOfNGOType = new ArrayList<NGOTypeBean>();

		if (conn != null) {
			String selectsql = "select * from NGOtype";
			try {

				pstmt = conn.prepareStatement(selectsql);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					NGOTypeBean ngoTypeBean = new NGOTypeBean();
					ngoTypeBean.setId1(rs.getInt("Category"));
					ngoTypeBean.setType(rs.getString("type"));
					
					listOfNGOType.add(ngoTypeBean);

				}

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

		} // end if

		return listOfNGOType;
	}// end of list
	public List<NGOBean> NGOlist1(int category) {

		conn = DBConnection.getDBConnetion();
		List<NGOBean> listOfNGO = new ArrayList<NGOBean>();

		if (conn != null) {
			/*
			 * String selectsql =
			 * "SELECT ngoreg.name,ngoreg.emailId,ngoreg.url,ngoreg.contact_no, ngoreg.category, ngoreg.address FROM ngoreg INNER JOIN ngotype ON ngoreg.category=ngoreg.category where ngoreg.category=?"
			 * ;
			 */
			String selectsql = "SELECT ngoreg.name,ngoreg.emailId,ngoreg.url,ngoreg.contact_no, ngoreg.category, ngoreg.address FROM ngoreg where ngoreg.category=?";
			try {

				pstmt = conn.prepareStatement(selectsql);
				pstmt.setInt(1, category);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					NGOBean ngoBean = new NGOBean();
					ngoBean.setName(rs.getString("name"));
					ngoBean.setEmailId(rs.getString("emailId"));
					ngoBean.setURL(rs.getString("url"));
					ngoBean.setContactno(rs.getString("contact_no"));
					ngoBean.setCategory(rs.getInt("category"));
					ngoBean.setAddress(rs.getString("address"));
					listOfNGO.add(ngoBean);

				}

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

		} // end if

		return listOfNGO;
	}// end of list
}
