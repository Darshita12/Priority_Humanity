package com.Donation.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Donation.Bean.DonationBean;
import com.Donation.Dao.DonationDao;

/**
 * Servlet implementation class EditDonationServlet
 */
public class EditDonationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int did = Integer.parseInt(request.getParameter("did"));
		DonationDao donationDao = new DonationDao();
		DonationBean donationBean = new DonationBean();
		donationBean = donationDao.getData(did);
		request.setAttribute("donationBean", donationBean);
		request.getRequestDispatcher("DonationEdit.jsp").forward(request, response);
	}

}
