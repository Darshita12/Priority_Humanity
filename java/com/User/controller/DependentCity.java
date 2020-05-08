package com.User.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.User.bean.CityBean;
import com.User.dao.CityDao;

public class DependentCity extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int valajax = Integer.parseInt(request.getParameter("valajax"));
		CityDao cityDao=new CityDao();
		List<CityBean> listOfCity=new ArrayList<CityBean>();
		listOfCity=cityDao.listofCity(valajax);
		request.setAttribute("ListOfCity", listOfCity);
		request.getRequestDispatcher("UserReg.jsp").forward(request, response);

	}

}
