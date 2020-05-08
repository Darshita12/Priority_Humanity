package com.Donation.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.Donation.Bean.DonationBean;
import com.Donation.util.DBConnection;

public class DonationDao {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public boolean addDonation(DonationBean donationBean) {
		boolean flag = false;

		conn = DBConnection.getDBConnetion();

		if (conn != null) {

			String insertSQL = "insert into Donation(DonationAmount,Date)values(?,?)";
			try {

				pstmt = conn.prepareStatement(insertSQL);
				pstmt.setInt(1, donationBean.getDonationamount());
				pstmt.setString(2, donationBean.getDonationdate());
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
	}// end add donation

	public List<DonationBean> Donationlist() {

		conn = DBConnection.getDBConnetion();
		List<DonationBean> listOfDonation = new ArrayList<DonationBean>();

		if (conn != null) {
			String selectsql = "select * from Donation";
			try {

				pstmt = conn.prepareStatement(selectsql);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					DonationBean donationBean = new DonationBean();
					donationBean.setDonationid(rs.getInt("donationid"));
					donationBean.setDonationamount(rs.getInt("donationamount"));
					donationBean.setDonationdate(rs.getString("date"));
					listOfDonation.add(donationBean);

				}

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

		} // end if

		return listOfDonation;
	}// end of list

	public boolean deleteEvent(int did) {
		boolean flag = false;

		conn = DBConnection.getDBConnetion();
		if (conn != null) {
			String deletesql = "delete from donation where donationid = ?";
			try {
				pstmt = conn.prepareStatement(deletesql);
				pstmt.setInt(1, did);
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
	}// end delete

	public DonationBean getData(int did) {

		conn = DBConnection.getDBConnetion();
		DonationBean donationBean = new DonationBean();

		if (conn != null) {

			try {
				String selectsql = "select * from donation where donationid = ?";
				pstmt = conn.prepareStatement(selectsql);
				pstmt.setInt(1, did);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					donationBean.setDonationid(rs.getInt("donationid"));
					donationBean.setDonationamount(rs.getInt("donationamount"));
					donationBean.setDonationdate(rs.getString("donationdate"));
				}
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}

		} // end if

		return donationBean;

	}

	public boolean UpdateDonation(DonationBean donationBean) {
		boolean flag = false;

		conn = DBConnection.getDBConnetion();

		if (conn != null) {
			try {
				String updatesql = "update donation set donationAmount=? where donationid=?";
				pstmt = conn.prepareStatement(updatesql);
				pstmt.setInt(1, donationBean.getDonationamount());
				pstmt.setInt(2, donationBean.getDonationid());
				int res = pstmt.executeUpdate();

				if (res > 0) {
					flag = true;
				}

			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}

		return flag;
	}// end update
}
