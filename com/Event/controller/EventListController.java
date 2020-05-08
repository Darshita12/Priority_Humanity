package com.Event.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Event.bean.EventBean;
import com.Event.dao.EventDao;
import com.mysql.cj.Session;


public class EventListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<EventBean> listOfEvent = new  ArrayList<EventBean>();
		EventDao eventDao = new EventDao();
		listOfEvent = eventDao.eventlist();
		request.setAttribute("listOfEvent", listOfEvent);
		System.out.println("---------------------------------");
		request.getRequestDispatcher("Event.jsp").forward(request, response);
	
	}

}
