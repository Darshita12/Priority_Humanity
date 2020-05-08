package com.Donation.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Donation.Bean.DonationBean;
import com.Donation.Dao.DonationDao;


public class DonationInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		int DonationAmount = Integer.parseInt(request.getParameter("DonationAmount"));
		System.out.println(DonationAmount);
		 
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		   LocalDate now = LocalDate.now();
		   System.out.println(dtf.format(now));

		
		DonationBean donationBean = new DonationBean();	
		donationBean.setDonationamount(DonationAmount);
		donationBean.setDonationdate(dtf.format(now));
		
		
		if(new DonationDao().addDonation(donationBean)) {
			response.sendRedirect("DonationListController");
		}
		else {
			//response.sendRedirect("DonationListController");
			response.sendError(405);
		}
	}
}
