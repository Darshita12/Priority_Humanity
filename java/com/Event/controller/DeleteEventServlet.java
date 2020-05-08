package com.Event.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Event.dao.EventDao;

public class DeleteEventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

int eid =  Integer.parseInt(request.getParameter("eid"));
		
		System.out.println(eid);
		if(new EventDao().deleteEvent(eid)) {
			response.sendRedirect("EventListController");
		}
		else {
			response.sendRedirect("EventListController");	
		}
			
		
	}


	}


