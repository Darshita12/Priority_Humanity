package com.Donation.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Donation.Dao.DonationDao;

/**
 * Servlet implementation class DeleteDonationServlet
 */
public class DeleteDonationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int did =  Integer.parseInt(request.getParameter("did"));
	
		if(new DonationDao().deleteEvent(did)) {
			response.sendRedirect("DonationListController");
		}
		else {
			response.sendRedirect("DonationListController");
			
		}
	}

}
