package com.Event.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Event.bean.EventBean;
import com.Event.dao.EventDao;

/**
 * Servlet implementation class EditEventServlet
 */
public class EditEventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int eid = Integer.parseInt(request.getParameter("eid"));
		 EventBean eventBean = new EventBean();
		 EventDao eventDao = new EventDao();
		 eventBean = eventDao.getData(eid);
		 request.setAttribute("eventBean", eventBean);
		 request.getRequestDispatcher("EventEdit.jsp").forward(request, response);
		
	}

}
