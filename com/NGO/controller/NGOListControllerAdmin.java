package com.NGO.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.NGO.Bean.NGOBean;
import com.NGO.Dao.NGODao;

public class NGOListControllerAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		NGODao ngoDao=new NGODao();
		List<NGOBean> listOfNGO=new ArrayList<NGOBean>();
		listOfNGO=ngoDao.NGOlist();
		
		request.setAttribute("NGOList", listOfNGO);
		request.getRequestDispatcher("NGOList.jsp").forward(request, response);
	
	}

}
