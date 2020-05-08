package com.NGO.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.NGO.Bean.NGOBean;
import com.NGO.Dao.NGODao;

public class NGOListByCauseDonate extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		NGODao ngoDao=new NGODao();
		int Category=Integer.parseInt(request.getParameter("txtNGOCategory"));
		List<NGOBean> listOfNGO=new ArrayList<NGOBean>();
		listOfNGO=ngoDao.NGOlist1(Category);
		HttpSession session=request.getSession();
		session.setAttribute("Category1", true);
		session.setAttribute("listOfNGO", listOfNGO);
		request.getRequestDispatcher("donate.jsp").forward(request, response);	}

}
