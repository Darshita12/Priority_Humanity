package com.Event.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Event.bean.EventBean;
import com.Event.dao.EventDao;

/**
 * Servlet implementation class EventUpdateServlet
 */
public class EventUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int EventId = Integer.parseInt(request.getParameter("eid"));
		String EventName = request.getParameter("Eventname");
		String EventAddress = request.getParameter("Eventaddress");
		String Date = request.getParameter("EventDate");

		EventBean eventBean = new EventBean();

		eventBean.setEventid(EventId);
		eventBean.setEventname(EventName);
		eventBean.setEventaddress(EventAddress);
		eventBean.setEventDate(Date);

		if(new EventDao().UpdateEvent(eventBean)) {
			response.sendRedirect("EventListController");
		}
		else {
			response.sendRedirect("EventListController");
		}
	

	}

}
