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
import com.NGO.Bean.NGOTypeBean;
import com.NGO.Dao.NGODao;


public class NGOListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		NGODao ngoDao=new NGODao();
		List<NGOBean> listOfNGO1=new ArrayList<NGOBean>();
		System.out.println("hii");
		listOfNGO1=ngoDao.NGOlist();

		/*
		 * List<NGOTypeBean> listOfNGOType=new ArrayList<NGOTypeBean>();
		 * listOfNGOType=ngoDao.NGOtypelist(); request.setAttribute("listOfNGOType",
		 * listOfNGOType);
		 * 
		 */
		System.out.println(listOfNGO1);
		request.setAttribute("NGOList", listOfNGO1 );
		request.getRequestDispatcher("SearchNgo.jsp").forward(request, response);
		
	}

}
