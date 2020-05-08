package com.Event.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Event.bean.EventBean;
import com.Event.dao.EventDao;
import com.Event.util.ValidationUtils;


public class EventInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String EventName = request.getParameter("EventName");
		String EventAddress = request.getParameter("EventAddress");
		String Date = request.getParameter("Date");

		EventBean eventBean = new EventBean();

		boolean isError = false;
		if (ValidationUtils.isEmpty(EventName)) {
			isError = true;
			request.setAttribute("EventName", "<html><font color ='RED'>*Event NAME REQUIRED..</font></html>");
		} else {
			eventBean.setEventname(EventName);
		}

		if (ValidationUtils.isEmpty(EventAddress)) {
			isError = true;
			request.setAttribute("EventAddress", "<html><font color ='RED'>*Event Address REQUIRED..</font></html>");
		} else {
			eventBean.setEventaddress(EventAddress);
		}

		if (ValidationUtils.isEmpty(Date)) {
			isError = true;
			request.setAttribute("Date", "<html><font color ='RED'>*Date REQUIRED..</font></html>");
		} else {
			eventBean.setEventDate(Date);
		}

		if (isError) {
			request.getRequestDispatcher("Event.jsp").forward(request, response);
		}

		else {
			if (new EventDao().addEvent(eventBean)) {
				response.sendRedirect("EventListController");
			} else {
				response.sendError(404);
			}
		}
	}

}
