package com.Donation.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Donation.Bean.DonationBean;
import com.Donation.Dao.DonationDao;

public class DonationListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<DonationBean> listOfDonation = new  ArrayList<DonationBean>();
		DonationDao  donationDao = new DonationDao();
		
		listOfDonation = donationDao.Donationlist();
		request.setAttribute("listOfDonation", listOfDonation);
		request.getRequestDispatcher("DonationList.jsp").forward(request, response);
	
	}

}
